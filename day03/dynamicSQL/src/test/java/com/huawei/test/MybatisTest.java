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

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yqx
 * @Company https://www.huawei.com
 * @date 2021/3/25 9:15
 * @desc
 */
public class MybatisTest {
    private InputStream in;
    private SqlSession sqlSession;
    private IUserDao userDao;

    @Before//用于在测试方法执行之前执行
    public void init()throws Exception{
        //1.读取配置文件，生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.获取SqlSession对象
        sqlSession = factory.openSession(true);
        //4.获取dao的代理对象
        userDao = sqlSession.getMapper(IUserDao.class);
    }

    @After//用于在测试方法执行之后执行
    public void destroy()throws Exception{
        //提交事务
        // sqlSession.commit();
        //6.释放资源
        sqlSession.close();
        in.close();
    }

    @Test
    public void testFindByUser(){
        User user = new User();
        user.setUserName("%王%");
        user.setUserAddress("%顺义%");
        List<User> users = userDao.findByUser(user);
        for(User u:users){
            System.out.println(u);
        }
    }

    @Test
    public void testFindInIds(){
        QueryVo queryVo = new QueryVo();
        ArrayList<Integer> ids = new ArrayList<>();
        ids.add(41);
        ids.add(42);
        ids.add(43);
        ids.add(45);
        queryVo.setIds(ids);
        List<User> users = userDao.findInIDs(queryVo);
        for(User u:users){
            System.out.println(u);
        }
    }
}
