package top.xuebiao.soa.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.xuebiao.dao.UserMapper;

@Service
public class User implements top.xuebiao.soa.User {

	@Autowired
	private UserMapper userMapper;
	@Override
	public boolean login(String loginID, String password) {
		return userMapper.login(loginID, password);
	}

}
