package top.xuebiao.common;

import java.util.HashMap;
import java.util.Map;

public class CommonResponse {

	public static Map<String,Object> error(String code, String message){
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("code", code);
        result.put("message", message);
        return result; 
    }
}
