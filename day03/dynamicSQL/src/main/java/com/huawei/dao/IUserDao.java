package com.huawei.dao;

import com.huawei.domain.QueryVo;
import com.huawei.domain.User;

import java.util.List;

/**
 * @author yqx
 * @Company https://www.huawei.com
 * @date 2021/3/25 9:00
 * @desc
 */
public interface IUserDao {
    /**
     * 根据用户信息，查询用户列表
     * @param user
     * @return
     */
    List<User> findByUser(User user);

    /**
     * 根据id集合查询用户
     * @param vo
     * @return
     */
    List<User> findInIDs(QueryVo vo);
}
