package top.xuebiao.controller.user;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import top.xuebiao.service.IUserService;
import top.xuebiao.vo.Greeting;
import top.xuebiao.vo.UserData;

@CrossOrigin(origins = { "*" })
@RequestMapping(value = "user")
@RestController
public class UserController {
	Logger logger = LoggerFactory.getLogger(UserController.class);

	private static final String template = "Hello,%s";
	private final AtomicLong counter = new AtomicLong();

	@Autowired
	private IUserService userService;

	@RequestMapping(value = "/greeting", method = RequestMethod.GET)
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	@RequestMapping("/test")
	public Map<String, Object> test(RequestEntity<String> request,
			@RequestParam(value = "p2", defaultValue = "test") String p1) throws Exception {
		String[] arr = { "a", "b", "c", p1 };
		Map<String, Object> r = new HashMap<String, Object>();
		r.put("list", arr);
		if (arr.length > 0) {
			throw new Exception("eeee");
		}
		return r;
	}

	/**
	 * user login 登入请求
	 * 
	 * @param request
	 * @param loginID
	 * @param password
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/login")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> login(@RequestBody Map<String, String> user) {
		String loginID = user.get("loginID");
		String password = user.get("password");
		logger.info("Login: loginID=" + loginID + ", password=" + password);
		
		Map<String, Object> r = new HashMap<String, Object>();
		boolean isSuccess = userService.login(loginID, password);
		if (isSuccess) {
			r.put("code", "ok");
			UserData u = userService.getUserData(1);
			System.out.print(u.getName());
		} else {
			r.put("code", "L00001");
		}
		return new ResponseEntity<>(r, HttpStatus.OK);
	}

	@RequestMapping("/test1")
	public ResponseEntity<Map<String, Object>> test1() {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/testURL/{loginID}/list")
	public ResponseEntity<Map<String, Object>> testURL(RequestEntity<String> request,
			@PathVariable("loginID") String loginID) {
		request.getHeaders();
		System.out.print(loginID);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
