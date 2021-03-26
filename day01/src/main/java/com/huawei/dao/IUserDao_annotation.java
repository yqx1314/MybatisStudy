package com.huawei.dao;

import com.huawei.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author yqx
 * @Company https://www.huawei.com
 * @date 2021/3/24 16:34
 * @desc
 */
public interface IUserDao_annotation {
    /**
     * 查询所有用户
     * @return Users
     */
    @Select("select * from user")
    List<User> findAll();
}
