package top.xuebiao.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.NegatedRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import static java.util.Objects.requireNonNull;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
class AppSecurityConfigurer extends WebSecurityConfigurerAdapter {

	private static final RequestMatcher PUBLIC_URLS = new OrRequestMatcher(
			new AntPathRequestMatcher("/public/**"),
			new AntPathRequestMatcher("/user/login"));

	private static final RequestMatcher PROTECTED_URLS = new NegatedRequestMatcher(PUBLIC_URLS);

	AppUserDetailsAuthenticationProvider provider;

	AppSecurityConfigurer(final AppUserDetailsAuthenticationProvider provider) {
		super();
		this.provider = requireNonNull(provider);
	}

	@Override
	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(provider);
	}

	@Override
	public void configure(final WebSecurity web) {
		web.ignoring().requestMatchers(PUBLIC_URLS);
	}

	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		http.sessionManagement().sessionCreationPolicy(STATELESS).and().exceptionHandling()
				// this entry point handles when you request a protected page and you are not
				// yet
				// authenticated
				.defaultAuthenticationEntryPointFor(forbiddenEntryPoint(), PROTECTED_URLS).and()

				// role config
				.authorizeRequests().antMatchers(HttpMethod.PUT, "/products/{id}").hasRole("ADMIN")
				.and()
				.authorizeRequests().antMatchers(HttpMethod.DELETE, "/products/**").hasRole("ADMIN")
				.and()
				//provider
				.authenticationProvider(provider)
				.addFilterBefore(restAuthenticationFilter(), AnonymousAuthenticationFilter.class).authorizeRequests()
				
				// cors 
				.requestMatchers(PROTECTED_URLS).authenticated().and().cors().and().csrf().disable()
				.formLogin().disable()
				//http 认证
				.httpBasic().realmName("TEST_REALM").authenticationEntryPoint(getBasicAuthEntryPoint())
				//...
				.and().logout().disable();
	}

	@Bean
	AppAuthenticationProcessingFilter restAuthenticationFilter() throws Exception {
		final AppAuthenticationProcessingFilter filter = new AppAuthenticationProcessingFilter(PROTECTED_URLS);
		filter.setAuthenticationManager(authenticationManager());
		filter.setAuthenticationSuccessHandler(successHandler());
		return filter;
	}

	@Bean
	SimpleUrlAuthenticationSuccessHandler successHandler() {
		final SimpleUrlAuthenticationSuccessHandler successHandler = new SimpleUrlAuthenticationSuccessHandler();
		successHandler.setRedirectStrategy(new NoRedirectStrategy());
		return successHandler;
	}

	/**
	 * Disable Spring boot automatic filter registration.
	 */
	@Bean
	FilterRegistrationBean disableAutoRegistration(final AppAuthenticationProcessingFilter filter) {
		final FilterRegistrationBean registration = new FilterRegistrationBean(filter);
		registration.setEnabled(false);
		return registration;
	}

	@Bean
	AuthenticationEntryPoint forbiddenEntryPoint() {
		return new HttpStatusEntryPoint(FORBIDDEN);
	}
	
	/**
	 * ref: https://docs.spring.io/spring-security/site/docs/current/reference/htmlsingle/#cors
	 * spring security @CrossOrigin setting
	 * @return
	 */
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList("*"));
		configuration.setAllowedMethods(Arrays.asList("*"));
		configuration.setAllowedHeaders(Arrays.asList("*"));
		configuration.setAllowCredentials(true);
		long maxAge = 60;
		configuration.setMaxAge(maxAge);
		configuration.setExposedHeaders(Arrays.asList("Authorization","Content-Type"));
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}
	
	/**
	 * 认证
	 * http://websystique.com/spring-security/secure-spring-rest-api-using-basic-authentication/
	 * @return
	 */
	@Bean
    public AppBasicAuthenticationEntryPoint getBasicAuthEntryPoint(){
        return new AppBasicAuthenticationEntryPoint();
    }
}
