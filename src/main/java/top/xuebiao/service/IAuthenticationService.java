package top.xuebiao.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;


public interface IAuthenticationService {
	
	  Optional<String> login(String username, String password);

	  Optional<UserDetails> findByToken(String token);

	  void logout(UserDetails user);
}
