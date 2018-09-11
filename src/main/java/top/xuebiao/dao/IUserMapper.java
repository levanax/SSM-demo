package top.xuebiao.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface IUserMapper {

	/**
	 * @param loginID
	 * @param password
	 * @return userID
	 */
	@Select("select id from user_tbl where login_id = #{loginID} and login_password = #{password}")
	Integer login(@Param("loginID") String loginID,@Param("password") String password);
	
	List<String> queryRoles(@Param("userID") int userID);
	
}
