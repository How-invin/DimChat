package howin.dimChat.dao;

import howin.dimChat.models.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface LoginDao {

    @Insert("INSERT INTO account(username, password, role) VALUES(#{username}, #{password}, #{role})")
    int createUser(@Param("username") String username, @Param("password") String password, @Param("role") String role);

    @Delete("DELETE FROM account WHERE username = #{username}")
    int deleteUser(@Param("username") String username);

    @Update("UPDATE account SET password = #{password} WHERE username = #{username}")
    int modifyUser(@Param("username") String username, @Param("password") String password);

    @Select("SELECT * FROM account WHERE username = #{username}")
    @Results({
        @Result(column="id", property="id", jdbcType= JdbcType.INTEGER, id=true),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="role", property="role", jdbcType=JdbcType.VARCHAR)
    })
    User getPassword(@Param("username") String username);

}
