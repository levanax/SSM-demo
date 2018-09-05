package top.xuebiao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import static java.util.Optional.ofNullable;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import top.xuebiao.dao.IUserMapper;
import top.xuebiao.po.UserDetail;

@Service
public class UserServiceImpl implements top.xuebiao.service.IUserService {

	@Autowired
	private IUserMapper userMapper;

	Map<String, UserDetail> userDetialMap = new HashMap<String, UserDetail>();
	
	
	@Override
	public boolean login(String loginID, String password) {
		if(userMapper.login(loginID, password)) {
			UserDetail user = new  UserDetail("1", "2", "3");
			userDetialMap.put("1", user);
			return true;
		}else {
			return false;
		}
	}

	@Override
	public Optional<UserDetail> findByToken(String token) {
		System.out.print("--------------------");
		System.out.print("----findByToken-------findByToken--------"+token);
		System.out.print("--------------------");
		return Optional.ofNullable(userDetialMap.get("1"));
	}
}
