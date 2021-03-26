package com.huawei.test;

import com.huawei.dao.IUserDao;
import com.huawei.domain.QueryVo;
import com.huawei.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.jws.soap.SOAPBinding;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @author yqx
 * @Company https://www.huawei.com
 * @date 2021/3/24 19:08
 * @desc
 */
public class MybatisCRUDTest {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IUserDao userDao;
    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        factory = builder.build(in);
        session = factory.openSession();
        userDao = session.getMapper(IUserDao.class);
    }

    /**
     * 测试根据id查询用户
     */
    @Test
    public void testFindById(){
        User user = userDao.findById(41);
        System.out.println(user);
    }

    /**
     * 测试保存一个用户
     */
    @Test
    public void testSaveUser(){
        User user = new User();
        user.setUsername("modify User property");
        user.setAddress("北京市顺义区");
        user.setSex("男");
        user.setBirthday(new Date());
        userDao.saveUser(user);

    }

    /**
     * 测试更新用户
     */
    @Test
    public void testUpdateUser(){
        User user = userDao.findById(42);
        user.setAddress("北京市顺义区");
        int res = userDao.updateUser(user);
        System.out.println(res);
    }

    /**
     * 测试根据id删除用户
     */
    @Test
    public void testDeleteUser(){
        int res = userDao.deleteUser(50);
        System.out.println(res);
    }
    @Test
    public void testFindByName(){
//        List<User> users = userDao.findByName("%王%");
        List<User> users = userDao.findByName("王");
        for(User user:users){
            System.out.println(user);
        }
    }

    /**
     * 测试查询总记录条数
     */
    @Test
    public void testFindTotal(){
        int total = userDao.findTotal();
        System.out.println(total);
    }

    /**
     * 测试根据QueryVo的添加查询用户
     */
    @Test
    public void testFindByVo(){
        QueryVo vo = new QueryVo();
        User user = new User();
        user.setUsername("%王%");
        vo.setUser(user);
        List<User> users = userDao.findByVo(vo);
        for(User u:users){
            System.out.println(u);
        }
    }
    @Test
    public void testFindAll(){
        List<User> users = userDao.findAll();
        for(User u:users){
            System.out.println(u);
        }
    }
    @After
    public void destroy() throws IOException {
        session.commit();
        session.close();
        in.close();
    }
}
