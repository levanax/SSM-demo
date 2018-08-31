package top.xuebiao.vo;

public class Response {

	public static final String CODE_OK = "ok";
	
	private String code = "";
	private String message = "";
	private Object data;
	
	
	public Response(Object data) {
		super();
		this.code = Response.CODE_OK;
		this.data = data;
	}

	public Response(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public Response(String code, String message, Object data) {
		super();
		this.code = code;
		this.message = message;
		this.data = data;
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

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	
}
