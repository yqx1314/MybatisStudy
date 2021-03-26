package com.huawei.dao;

import com.huawei.domain.QueryVo;
import com.huawei.domain.User;

import java.util.List;

/**
 * @author yqx
 * @Company https://www.huawei.com
 * @date 2021/3/24 19:01
 * @desc
 */
public interface IUserDao {
    /**
     * 根据id查询相应的用户
     * @param userid
     * @return
     */
    User findById(Integer userid);

    /**
     * 保存用户
     * @param user
     * @return
     */
    int saveUser(User user);

    /**
     * 更新用户
     * @param user
     * @return
     */
    int updateUser(User user);

    /**
     * 根据id删除用户
     * @param uid
     * @return
     */
    int deleteUser(Integer uid);

    /**
     * 根据名称模糊查询
     * @param username
     * @return
     */
    List<User> findByName(String username);

    /**
     * 查询总记录条数
     * @return
     */
    int findTotal();

    /**
     * 根据QueryVo的添加查询用户
     * @param vo
     * @return
     */
    List<User> findByVo(QueryVo vo);

    /**
     * 查询所有用户
     * @return
     */
    List<User> findAll();
}
