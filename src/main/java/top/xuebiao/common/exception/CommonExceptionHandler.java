package top.xuebiao.common.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import top.xuebiao.common.CommonResponse;

/**
 * 异常处理
 * @author levana.xue
 *
 */
@ControllerAdvice
public class CommonExceptionHandler {

	   /**
     *  拦截Exception类的异常
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Map<String,Object> exceptionHandler(Exception e){
        return CommonResponse.error("E0001",  e.getMessage()); 
    }
}
