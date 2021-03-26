package com.huawei.dao;

import com.huawei.domain.User;

import java.util.List;

/**
 * @author yqx
 * @Company https://www.huawei.com
 * @date 2021/3/25 13:56
 * @desc
 */
public interface IUserDao {
    /**
     * 查询所有的用户信息
     * @return
     */
    List<User> findAll();
}
