package top.xuebiao.controller.user;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import top.xuebiao.service.IUserService;
import top.xuebiao.vo.Greeting;
import top.xuebiao.vo.UserData;

@RestController
public class UserController {

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
			@RequestParam(value = "p2", defaultValue = "test") String p1) {
		String[] arr = { "a", "b", "c", p1 };
		Map<String, Object> r = new HashMap<String, Object>();
		r.put("list", arr);
		return r;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Map<String, Object>>  login(RequestEntity<String> request, @RequestBody(required = false) String loginID,
			@RequestBody(required = false) String password) {
		Map<String, Object> r = new HashMap<String, Object>();
		boolean isSuccess = userService.login(loginID, password);
		if (isSuccess) {
			r.put("code", "ok");
			UserData u = userService.getUserData(1);
			System.out.print(u.getName());
		} else {
			r.put("code", "L00001");
		}
		return new ResponseEntity<>(r,HttpStatus.OK);
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
