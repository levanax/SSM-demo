package top.xuebiao;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import top.xuebiao.dao.UserMapper;

@SpringBootApplication
public class Application implements CommandLineRunner{

	private final UserMapper userMapper;
	
	public Application(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	
	public static void main(String[] args){
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		boolean r = userMapper.login("levan", "123456");
		System.out.println(r);
	}
}
