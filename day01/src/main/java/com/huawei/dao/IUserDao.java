package com.huawei.dao;

import com.huawei.domain.User;

import java.util.List;

/**
 * @author yqx
 * @Company https://www.huawei.com
 * @date 2021/3/24 15:46
 * @desc 用户的持久层接口
 */
public interface IUserDao {
    /**
     * 查询所有用户
     * @return Users
     */
    List<User> findAll();
}
