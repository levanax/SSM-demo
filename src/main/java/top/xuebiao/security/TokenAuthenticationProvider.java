package top.xuebiao.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import top.xuebiao.service.IUserAuthenticationService;

import org.springframework.security.core.userdetails.UsernameNotFoundException;


@Component
public final class TokenAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {
	
	@NonNull
	@Autowired
	IUserAuthenticationService userAuthenticationService;

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
		// TODO Auto-generated method stub
		System.out.println("TokenAuthenticationProvider：additionalAuthenticationChecks...."+ userAuthenticationService);

	}

	@Override
	protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		System.out.println("TokenAuthenticationProvider：retrieveUser...."+ userAuthenticationService);
		final Object token = authentication.getCredentials();
		return Optional
			      .ofNullable(token)
			      .map(String::valueOf)
			      .flatMap(userAuthenticationService::findByToken)
			      .orElseThrow(() -> new UsernameNotFoundException("Cannot find user with authentication token=" + token));
	}
}
