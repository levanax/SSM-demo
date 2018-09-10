package top.xuebiao.controller.user;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.CollectionUtils;
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
import top.xuebiao.service.IUserService;

@CrossOrigin(origins = { "*" })
@RequestMapping(value = "user")
@RestController
public class UserController {
	Logger logger = LoggerFactory.getLogger(UserController.class);

	private final AtomicLong counter = new AtomicLong();

	@Autowired
	private IUserService userService;
	private static final String LOG_TEMPLATE_LOGIN = "counter%s - Login: loginID=%s,password=%s";
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

        String name = "World";
		boolean isSuccess = userService.login(loginID, password);
		if (isSuccess) {
			Map<String, String> data = new HashMap<String, String>();
			data.put("token", "token");
			return Responser.success(data);
		} else {
			return Responser.reply("L0001", "loginID or password is incorrect", HttpStatus.OK);
		}
	}
}
