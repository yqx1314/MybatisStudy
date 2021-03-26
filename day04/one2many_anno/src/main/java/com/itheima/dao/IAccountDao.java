package com.itheima.dao;

import com.itheima.domain.Account;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 */
public interface IAccountDao {
    /**
     * 查询所有账户，采用懒加载方式查询账户的所属用户
     * @return
     */
    @Select("select * from account")
    @Results(
            id = "accountMap",
            value = {
                    @Result(id = true,column = "id",property = "id"),
                    @Result(column = "uid",property = "uid"),
                    @Result(column = "money",property = "money"),
                    @Result(column = "uid",property = "user",one = @One(
                            select = "com.itheima.dao.IUserDao.findById",
                            fetchType = FetchType.LAZY
                    ))
            }
    )
    List<Account> findAll();

    /**
     * 根据UID查询对应的账户
     * @param userId
     * @return
     */
    @Select("select * from account where uid=#{id}")
    List<Account> findByUid(Integer userId);
}
