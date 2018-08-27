package top.xuebiao.common;

import java.util.HashMap;
import java.util.Map;

public class Response {

	public static final String CODE = "code";
	public static final String CODE_OK = "ok";
	public static final String MESSAGE = "message";
	public static final String DATA = "data";
	

	public static Map<String,Object> error(String code, String message){
        Map<String,Object> result = new HashMap<String,Object>();
        result.put(Response.CODE, code);
        result.put(Response.MESSAGE, message);
        return result; 
    }
	
	public static Map<String,Object> success(Object o){
        Map<String,Object> result = new HashMap<String,Object>();
        result.put(Response.CODE, CODE_OK);
        result.put(Response.MESSAGE, "");
        result.put(Response.DATA, o);
        return result; 
    }
}
