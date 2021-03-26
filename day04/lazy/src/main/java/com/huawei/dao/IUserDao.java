package com.huawei.dao;

import com.huawei.domain.User;

import java.util.List;

/**
 * @author yqx
 * @Company https://www.huawei.com
 * @date 2021/3/25 10:45
 * @desc
 */
public interface IUserDao {
    /**
     * 查询所有用户，同时获取每个用户下的所有账户信息
     * @return
     */
    List<User> findAll();

    /**
     * 根据id查询用户
     * @param uid
     * @return
     */
    User findById(Integer uid);
}
