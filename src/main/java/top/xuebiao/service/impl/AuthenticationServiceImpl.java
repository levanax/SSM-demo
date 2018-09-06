package top.xuebiao.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import top.xuebiao.common.Util;
import top.xuebiao.service.IAuthenticationService;
import top.xuebiao.service.IUserService;

@Service
public class AuthenticationServiceImpl implements IAuthenticationService {


	/**
	 * key : token
	 * value: user
	 */
	private static Map<String,UserDetails> users;
	static{
		users=  new HashMap<String,UserDetails>();
	}
	
	@Autowired
	private IUserService userService;
	
	@Override
	public Optional<String> login(String username, String password) {
		String token = null;
		int userID = userService.login(username, password);
		if(Util.isNotNull(userID)) {
		    String uuid = UUID.randomUUID().toString();
		    token = uuid + username;
		    List<String>  roles = userService.queryRoles(userID);
		    String[] rolesTemp = roles.toArray(new String[roles.size()]);
			UserDetails userDetails = User.withUsername(username).password(password).roles(rolesTemp).build();
			users.put(token, userDetails);
		}
		return Optional.ofNullable(token);
	}

	/**
	 * 返回一个 spring 用于判断的 userDetials 对象
	 */
	@Override
	public Optional<UserDetails> findByToken(String token) {
		return Optional.ofNullable(users.get(token));
	}

	@Override
	public void logout(UserDetails user) {
	}
}
