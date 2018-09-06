package top.xuebiao.controller.user;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import top.xuebiao.common.Responser;
import top.xuebiao.service.IAuthenticationService;
import top.xuebiao.service.IUserService;

@CrossOrigin(origins = { "*" })
@RequestMapping(value = "user")
@RestController
public class UserController {
	Logger logger = LoggerFactory.getLogger(UserController.class);

	private final AtomicLong counter = new AtomicLong();

	@SuppressWarnings("unused")
	@Autowired
	private IUserService userService;
	private static final String LOG_TEMPLATE_LOGIN = "counter%s - Login: loginID=%s,password=%s";
	
	@Autowired
	IAuthenticationService userAuthenticationService;
	/**
	 * user login 登入请求
	 * @param user
	 * @return
	 */
	@PostMapping(value = "/login")
	@ResponseBody
	public ResponseEntity<Object> login(@RequestBody Map<String, String> user) {
		String loginID = user.get("loginID");
		String password = user.get("password");
		logger.info(String.format(LOG_TEMPLATE_LOGIN, counter.incrementAndGet(), loginID, password));
		
		Optional<String> token = userAuthenticationService.login(loginID, password);		
		if (token.isPresent()) {
			Map<String, String> data = new HashMap<String, String>();
			data.put("token", token.get());
			return Responser.success(data);
		} else {
			return Responser.reply("L0001", "loginID or password is incorrect", HttpStatus.OK);
		}
	}
}
