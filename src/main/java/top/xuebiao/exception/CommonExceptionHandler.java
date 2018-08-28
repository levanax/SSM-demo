package top.xuebiao.exception;

import java.sql.SQLException;
import java.util.Map;

import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import top.xuebiao.common.Response;
import top.xuebiao.constant.ResponseCode;

/**
 * 异常处理
 * @author levana.xue
 *
 */
@ControllerAdvice
public class CommonExceptionHandler {


    @ExceptionHandler({CannotGetJdbcConnectionException.class, PersistenceException.class, SQLException.class, DataAccessException.class})
    @ResponseBody
    public ResponseEntity<Map<String, Object>> persistenceExceptionHandler(Exception e){
    	e.printStackTrace();
        return Response.error(ResponseCode.D0001,  ResponseCode.D0001_DESC); 
    }
    
	 /**
     *  拦截Exception类的异常
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> exceptionHandler(Exception e){
    	e.printStackTrace();
        return Response.error(ResponseCode.S0001,  ResponseCode.S0001_DESC); 
    }
}
