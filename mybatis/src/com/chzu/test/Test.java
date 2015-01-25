package com.chzu.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;

import com.chzu.dao.UserDao;
import com.chzu.dao.UserDaoByAnnotation;
import com.chzu.model.User;

/**
 * 测试mybatis增删改查
 * @author yanxing
 */
public class Test {
	private static SqlSessionFactory sessionFactory;
	private static Reader reader;
	private static final String CONFIG = "mybatis-config.xml";
	private static SqlSession session;

	// 运行之前，加载mybatis配置文件
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("加载配置文件……");
		reader = Resources.getResourceAsReader(CONFIG);
		sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		System.out.println("加载配置文件成功");
		session = sessionFactory.openSession();
	}

	/**
	 * 测试查询user,不使用接口方式
	 * select命名空间为com.chzu.model.UserMapper
	 */
	@org.junit.Test
	public void testQuery() throws IOException {
		User user = session.selectOne("com.chzu.model.UserMapper.getUser",1);
		System.out.println(user);
	}
	
	/**
	 * 测试查询user,使用接口方式
	 */
	@org.junit.Test
	public void testQueryInter() throws IOException {
		UserDao userDao=session.getMapper(UserDao.class);
		User user=userDao.getUser(1);
		System.out.println(user);
	}
	
	/**
	 * 测试查询所有的user,使用接口方式
	 */
	@org.junit.Test
	public void testQueryAllUser() throws IOException {
		UserDao userDao=session.getMapper(UserDao.class);
		List<User> list=userDao.getAllUser();
		for (User user2 : list) {
			System.out.println(user2);
		}
	}
	
	//添加user,使用接口方式
	@org.junit.Test
	public void testSaveUser() throws IOException {
		User user=new User(null ,"yanxing","男","中国");
		UserDao userDao=session.getMapper(UserDao.class);
		userDao.saveUser(user);
		session.commit();//提交事务，写入数据库
		System.out.println("增加的user的id值="+user.getId());
	}
	
	// 更新user,使用接口方式
	@org.junit.Test
	public void testUpdateUser() throws IOException {
		UserDao userDao = session.getMapper(UserDao.class);
		User user = userDao.getUser(3);
		user.setSex("male");
		userDao.updateUser(user);
		session.commit();// 提交事务，写入数据库
		System.out.println("更改后的User："+user);
	}
	
	// 删除user,使用接口方式
	@org.junit.Test
	public void testDeleteUser() throws IOException {
		UserDao userDao = session.getMapper(UserDao.class);
		userDao.deleteUser(3);
		session.commit();// 提交事务，写入数据库
	}
	
	// 使用注解
	@org.junit.Test
	public void testByAnnotation() throws IOException {
		UserDaoByAnnotation userDao = session.getMapper(UserDaoByAnnotation.class);
		List<User> list=userDao.getAllUser();
		for (User user : list) {
			System.out.println(user);
		}
	}

}
