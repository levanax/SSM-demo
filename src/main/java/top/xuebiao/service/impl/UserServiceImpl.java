package top.xuebiao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import static java.util.Optional.ofNullable;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import top.xuebiao.dao.IUserMapper;
import top.xuebiao.po.User;

@Service
public class UserServiceImpl implements top.xuebiao.service.IUserService {

	@Autowired
	private IUserMapper userMapper;

	Map<String, User> users = new HashMap<String, User>();
	
	
	@Override
	public boolean login(String loginID, String password) {
		if(userMapper.login(loginID, password)) {
			User user = new  User("1", "2", "3");
			users.put("1", user);
			return true;
		}else {
			return false;
		}
	}

	@Override
	public Optional<User> findByToken(String token) {
		System.out.print("--------------------");
		System.out.print("----findByToken-------findByToken--------"+token);
		System.out.print("--------------------");
		// TODO Auto-generated method stub
		return Optional.ofNullable(users.get("1"));
	}
}
