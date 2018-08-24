package top.xuebiao.common;

public class Util {

	public static boolean isNull(Object o) {
		return o == null;
	}
	
	public static boolean isNotNull(Object o) {
		return !isNull(o);
	}
	
	public static boolean isEmpty(String s) {
		return s == null || "".equals(s.trim());
	}
	
	public static boolean isNotEmpty(String s) {
		return !isEmpty(s);
	}
}
