package com.levana;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static final String template = "Hello,%s";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	@RequestMapping("/test")
	public Map<String,Object> test(RequestEntity<String> request,@RequestParam(value = "p2", defaultValue = "test") String p1){
		String[] arr =  {"a","b","c", p1 };
		Map<String,Object> r = new HashMap<String, Object>();
		r.put("list", arr);
		return r;
	}

	@RequestMapping("/test1")
	public ResponseEntity<Map<String,Object>> test1(){
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	

	@RequestMapping(value="/testURL/{loginID}/list")
	public ResponseEntity<Map<String,Object>> testURL(RequestEntity<String> request,@PathVariable("loginID") String loginID){
		request.getHeaders();
		System.out.print(loginID);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
