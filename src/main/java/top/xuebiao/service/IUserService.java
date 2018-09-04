package top.xuebiao.service;

import top.xuebiao.security.User;
import java.util.Optional;

public interface IUserService {

	boolean login(String loginID, String password);

	Optional<User> findByToken(String token);
}
