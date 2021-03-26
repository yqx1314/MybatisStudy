package com.huawei.dao;


import com.huawei.domain.Account;

import java.util.List;

/**
 * @author yqx
 * @Company https://www.huawei.com
 * @date 2021/3/25 10:09
 * @desc
 */
public interface IAccountDao {
    /**
     * 查询所有账户，同时获取账户所属用户名称以及地址信息
     * @return
     */
    List<Account> findAll();
}
