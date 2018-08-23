package top.xuebiao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.xuebiao.dao.UserMapper;
import top.xuebiao.vo.UserData;

@Service
public class User implements top.xuebiao.service.User {

	@Autowired
	private UserMapper userMapper;
	@Override
	public boolean login(String loginID, String password) {
		return userMapper.login(loginID, password);
	}

	@Override
	public UserData getUserData(int userID) {
		return userMapper.getUserData(userID);
	}
}
