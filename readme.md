http://www.mybatis.org/spring-boot-starter/mybatis-spring-boot-autoconfigure/


url跨域问题参考
https://spring.io/guides/gs/rest-service-cors/


# bug1   
```
	// 下面post请求会出错，删除 "RequestEntity<String> request"，即可正常接受 request body参数
	@RequestMapping(value = "/login", method = RequestMethod.POST, headers="Content-Type=application/json")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> login(RequestEntity<String> request, @RequestBody UserContext user) {
		logger.info("Login: loginID=" + user.getLoginID() + ", password=" + user.getPassword());
		;
		Map<String, Object> r = new HashMap<String, Object>();
		boolean isSuccess = userService.login(user.getLoginID(), user.getPassword());
		if (isSuccess) {
			r.put("code", "ok");
			UserData u = userService.getUserData(1);
			System.out.print(u.getName());
		} else {
			r.put("code", "L00001");
		}
		return new ResponseEntity<>(r, HttpStatus.OK);
	}
```