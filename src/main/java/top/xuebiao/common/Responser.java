package top.xuebiao.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import top.xuebiao.vo.Response;

public class Responser {
	

	public static ResponseEntity<Object> error(String code, String message){
        return new ResponseEntity<>(new Response(code, message), HttpStatus.INTERNAL_SERVER_ERROR); 
    }

	public static ResponseEntity<Object> reply(String code, String message, HttpStatus httpStatus){
        return new ResponseEntity<>(new Response(code, message), httpStatus); 
    }
	
	public static ResponseEntity<Object> success(Object o){
        return new ResponseEntity<>(new Response(o), HttpStatus.OK); 
    }

	public static ResponseEntity<Object> success(Object o, HttpStatus httpStatus){
        return new ResponseEntity<>(new Response(o), httpStatus); 
    }
}
