package top.xuebiao.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import top.xuebiao.service.IAuthenticationService;

import org.springframework.security.core.userdetails.UsernameNotFoundException;


@Component
public final class AppUserDetailsAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {
	
	@NonNull
	@Autowired
	IAuthenticationService userAuthenticationService;

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
	}

	/**
	 * 根据token 查出 user对象，提供给spring security 以验证权限
	 */
	@Override
	protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		final Object token = authentication.getCredentials();
		return Optional
			      .ofNullable(token)
			      .map(String::valueOf)
			      //查出的对象，同时会进行权限判断
			      .flatMap(userAuthenticationService::findByToken)
			      .orElseThrow(() -> new UsernameNotFoundException("Cannot find user with authentication token=" + token));
	}
}
