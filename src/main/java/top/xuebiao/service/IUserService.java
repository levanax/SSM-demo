package top.xuebiao.service;

import java.util.Optional;

import top.xuebiao.po.UserDetail;

public interface IUserService {

	boolean login(String loginID, String password);

	Optional<UserDetail> findByToken(String token);
}
