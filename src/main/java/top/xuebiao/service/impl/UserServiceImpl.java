package top.xuebiao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.xuebiao.dao.IUserMapper;
import top.xuebiao.vo.UserData;

@Service
public class UserServiceImpl implements top.xuebiao.service.IUserService {

	@Autowired
	private IUserMapper userMapper;
	@Override
	public boolean login(String loginID, String password) {
		return userMapper.login(loginID, password);
	}

	@Override
	public UserData getUserData(int userID) {
		return userMapper.getUserData(userID);
	}
}
