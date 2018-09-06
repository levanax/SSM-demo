package top.xuebiao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;

import top.xuebiao.dao.IUserMapper;

@Service
public class UserServiceImpl implements top.xuebiao.service.IUserService {

	@Autowired
	private IUserMapper userMapper;

	@Override
	public int login(String loginID, String password) {
		return userMapper.login(loginID, password);
	}

	@Override
	public List<String> queryRoles(int userID) {
		return userMapper.queryRoles(userID);
	}
}
