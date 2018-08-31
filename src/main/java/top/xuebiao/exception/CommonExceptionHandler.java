package top.xuebiao.exception;

import java.sql.SQLException;
import java.util.Map;

import javax.validation.UnexpectedTypeException;

import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import top.xuebiao.common.Responser;
import top.xuebiao.constant.ResponseCode;

/**
 * 异常处理
 * @author levana.xue
 *
 */
@ControllerAdvice
public class CommonExceptionHandler {


    @ExceptionHandler({AppException.class})
    @ResponseBody
    public ResponseEntity<Object> appExceptionHandler(AppException e){
    	e.printStackTrace();
        return Responser.reply(e.getCode(), e.getMessage(), HttpStatus.FORBIDDEN); 
    }

    @ExceptionHandler({CannotGetJdbcConnectionException.class, PersistenceException.class, SQLException.class, DataAccessException.class})
    @ResponseBody
    public ResponseEntity<Object> persistenceExceptionHandler(Exception e){
    	e.printStackTrace();
        return Responser.error(ResponseCode.D0001,  ResponseCode.D0001_DESC); 
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseEntity<Object> unexpectedTypeExceptionHandler(MethodArgumentNotValidException e) {
        return Responser.reply(ResponseCode.V0001, e.getBindingResult().toString(), HttpStatus.BAD_REQUEST); 
    }
    
	 /**
     *  拦截Exception类的异常
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<Object> exceptionHandler(Exception e){
    	e.printStackTrace();
        return Responser.error(ResponseCode.S0001,  ResponseCode.S0001_DESC); 
    }
}
