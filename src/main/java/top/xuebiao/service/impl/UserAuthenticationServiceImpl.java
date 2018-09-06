package top.xuebiao.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import top.xuebiao.po.UserDetail;
import top.xuebiao.service.IUserAuthenticationService;
import top.xuebiao.service.IUserService;

@Service
public class UserAuthenticationServiceImpl implements IUserAuthenticationService {

	@Autowired
	private IUserService userService;
	
	@Override
	public Optional<String> login(String username, String password) {
		boolean success = userService.login(username, password);
		
		return Optional.ofNullable("1");
	}

	@Override
	public Optional<UserDetails> findByToken(String token) {
		UserDetails user = User.withUsername("1").password("123456").roles("USER").build();
		
		return Optional.ofNullable(user);
	}

	@Override
	public void logout(UserDetail user) {
	}

}
