package top.xuebiao.service;

import java.util.List;

public interface IUserService {

	int login(String loginID, String password);

	List<String> queryRoles(int userID);

}
