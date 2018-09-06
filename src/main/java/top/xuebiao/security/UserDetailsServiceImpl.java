package top.xuebiao.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import top.xuebiao.po.UserDetail;
import top.xuebiao.service.IUserService;

@Service(value = "userDetailService")
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	IUserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
//		Optional<UserDetail> user = userService.findByToken(username);
		UserDetails user = User.withUsername("1").roles("ADMIN").build();
		return user;
	}

}
