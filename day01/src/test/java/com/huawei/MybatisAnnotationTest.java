package com.huawei;

import com.huawei.dao.IUserDao_annotation;
import com.huawei.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author yqx
 * @Company https://www.huawei.com
 * @date 2021/3/24 16:39
 * @desc
 */
public class MybatisAnnotationTest {
    public static void main(String[] args) throws IOException {
        //1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig2.xml");
        //2.创建SqlSessionFactory的构建者对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //3.使用构建者创建工厂对象
        SqlSessionFactory factory = builder.build(in);
        //4.使用SqlSessionFactory生产SqlSession对象
        SqlSession session = factory.openSession();
        //5.使用sqlSession创建dao接口的代理对象
        IUserDao_annotation userDao = session.getMapper(IUserDao_annotation.class);
        //6.使用代理对象执行查询方法
        List<User> users = userDao.findAll();
        //7.遍历并释放资源
        for (User user: users) {
            System.out.println(user);
        }
        session.close();
        in.close();
    }
}
