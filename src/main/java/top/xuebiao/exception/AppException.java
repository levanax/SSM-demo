package top.xuebiao.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 用于抛出异常响应到前端
 * @author levana.xue
 *
 */
public class AppException extends Exception {
	private static final long serialVersionUID = 1L;
	
	Logger logger = LoggerFactory.getLogger(AppException.class);
	
	private static final String LOG_TEMPLATE_ERROR = "AppException>> %s: %s";
	
	private String code;
	private String message;
	
	@Override
	public void printStackTrace() {
		logger.error(String.format(AppException.LOG_TEMPLATE_ERROR, this.getCode(), this.getMessage()));
	}

	public AppException() {
		super();
	}	

	public AppException(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
