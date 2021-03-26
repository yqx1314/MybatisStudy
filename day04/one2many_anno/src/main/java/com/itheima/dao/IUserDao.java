package com.itheima.dao;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * 在mybatis中针对,CRUD一共有四个注解
 *  @Select @Insert @Update @Delete
 */
@CacheNamespace(blocking = true)
public interface IUserDao {
    /**
     * 查询所有用户
     * @return
     */
    @Select("select * from user")
    @Results(
            id = "userMap",
            value = {
                @Result(id = true,column = "id",property = "userId"),
                @Result(column = "address",property = "userAddress"),
                @Result(column = "sex",property = "userSex"),
                @Result(column = "birthday",property = "userBirthday"),
                @Result(column = "id",property = "accounts",
                            many = @Many(
                                    select = "com.itheima.dao.IAccountDao.findByUid",
                                    fetchType = FetchType.LAZY
                            )
                        )
                }
            )
    List<User> findAll();
    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    @Select("select * from user where id=#{uid}")
    @ResultMap("userMap")
    User findById(Integer id);
}
