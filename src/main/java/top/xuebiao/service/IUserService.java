package top.xuebiao.service;

import top.xuebiao.vo.UserData;

public interface IUserService {

	boolean login(String loginID, String password);
	
	UserData getUserData(int userID);
}
