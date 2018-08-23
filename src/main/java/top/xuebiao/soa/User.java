package top.xuebiao.soa;

import org.springframework.boot.CommandLineRunner;

import top.xuebiao.dao.UserMapper;

public class User  implements CommandLineRunner{
	private  UserMapper userMapper;
	
	public User(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	

	@Override
	public void run(String... args) throws Exception {
		userMapper.login("", "");
	}
}
