package top.xuebiao.service;

import java.util.Optional;

import top.xuebiao.po.User;

public interface IUserService {

	boolean login(String loginID, String password);

	Optional<User> findByToken(String token);
}
