package howin.dimChat.dao;

import howin.dimChat.models.LoginModel;
import org.apache.ibatis.annotations.*;

@Mapper
public interface LoginDao {

    @Insert("INSERT INTO account(email, password) VALUES(#{email}, #{password})")
    int createUser(@Param("email") String email, @Param("password") String password);

    @Delete("DELETE FROM account WHERE email = #{email}")
    int deleteUser(@Param("email") String email);

    @Delete("UPDATE account SET password = #{password} WHERE email = #{email}")
    int modifyUser(@Param("email") String email, @Param("password") String password);

    @Select("SELECT * FROM account WHERE email = #{email}")
    LoginModel getPassword(@Param("email") String email);
}
