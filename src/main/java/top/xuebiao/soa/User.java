package top.xuebiao.soa;

import top.xuebiao.vo.UserData;

public interface User {

	boolean login(String loginID, String password);
	
	UserData getUserData(int userID);
}
