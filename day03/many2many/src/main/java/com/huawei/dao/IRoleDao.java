package com.huawei.dao;


import com.huawei.domain.Role;

import java.util.List;

/**
 * @author yqx
 * @Company https://www.huawei.com
 * @date 2021/3/25 13:56
 * @desc
 */
public interface IRoleDao {
    /**
     * 查询所有角色
     * @return
     */
    List<Role>  findAll();
}
