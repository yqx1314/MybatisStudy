###一、搭建mybatis开发环境
#### 1.1 在pom.xml文件中添加Mybatis的坐标
```java
<dependency>
    <groupId>org.mybatis</groupId>
    <artifactId>mybatis</artifactId>
    <version>3.4.5</version>
</dependency>
```
#### 1.2 编写user实体类
```java
public class User implements Serializable {
    private Integer id;
    private String username;
    private Date birthday;
    private String sex;
    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
```
####1.3 编写持久层接口
```java
public interface IUserDao {
    /**
     * 查询所有用户
     * @return Users
     */
    List<com.huawei.domain.User> findAll();
}
```
####1.4 编写持久层接口对应的映射文件IUserDao.xml
创建位置：必须和持久层接口在相同的包中
名称：必须以持久层接口名称命名文件名
```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.itheima.dao.IUserDao">
    <!--配置查询所有-->
    <select id="findAll" resultType="com.huawei.domain.User">
        select * from user
    </select>
</mapper>
```
####1.5 编写sqlMapConfig.xml配置文件
```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
<!--    配置mybatis的环境-->
    <environments default="">
<!--        配置mysql的环境-->
        <environment id="mysql">
<!--            配置事务的类型-->
            <transactionManager type="JDBC"></transactionManager>
<!--            配置数据库的连接信息，用的是数据源-->
            <dataSource type="POOLED">
                <property name="driver" value="com.mysql.jdbc.Driver"/>
                <property name="url" value="jdbc:mysql://localhost:3306/eesy_mybatis"/>
                <property name="username" value="root"/>
                <property name="password" value="mysql"/>
            </dataSource>
        </environment>
    </environments>
<!--    -->
    <mappers>
        <mapper resource="com/huawei/IUserDao.xml"></mapper>
    </mappers>
</configuration>
```
#### 1.6 编写测试类
```java
public class MybatisTest {
    public static void main(String[] args) throws IOException {
        //1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory的构建者对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //3.使用构建者创建工厂对象
        SqlSessionFactory factory = builder.build(in);
        //4.使用SqlSessionFactory生产SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //5.使用sqlSession创建dao接口的代理对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        //6.使用代理对象执行查询方法
        List<User> users = userDao.findAll();
        //7.遍历并释放资源
        for (User user: users) {
            System.out.println(user);
        }
    }
}
```
###二、基于注解的mybatis开发
####2.1 修改持久层接口，添加注解@select
```java
public interface IUserDao_annotation {
    /**
     * 查询所有用户
     * @return Users
     */
    @Select("select * from user")
    List<User> findAll();
}
```
####2.2 修改sqlMapConfig.xml


