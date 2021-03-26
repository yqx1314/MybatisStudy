package com.huawei.domain;

import java.io.Serializable;

/**
 * @author yqx
 * @Company https://www.huawei.com
 * @date 2021/3/24 20:06
 * @desc
 */
public class QueryVo implements Serializable {
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
