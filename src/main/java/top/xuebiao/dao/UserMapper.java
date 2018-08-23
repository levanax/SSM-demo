package top.xuebiao.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

	@Select("select count(*)>0 from user_tbl where login_id = #{loginID} and login_password = #{password}")
	boolean login(@Param("loginID") String loginID,@Param("password") String password);
}
