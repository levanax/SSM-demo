/**
 * 
 */
package top.xuebiao.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * spring security @CrossOrigin setting, 不使用这种方式，代码留存
 * @author levana.xue
 *
 */
//@Configuration
//@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {

//	@Override
//	public void addCorsMappings(CorsRegistry registry) {
//		registry.addMapping("/**").allowedOrigins("*").allowedMethods("*").exposedHeaders("Authorization","Content-Type").allowCredentials(true).allowedHeaders("Authorization","Content-Type");
//	}

}
