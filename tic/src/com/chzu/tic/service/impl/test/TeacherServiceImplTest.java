package com.chzu.tic.service.impl.test;



import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.chzu.tic.dao.UserDao;
import com.chzu.tic.model.User;
import com.chzu.tic.service.impl.TeacherServiceImpl;
import com.chzu.tic.util.PageBean;

/**
 * 对逻辑层TeacherServiceImpl进行测试
 * 
 * @author Administrator
 * 
 */
public class TeacherServiceImplTest {
	public static TeacherServiceImpl teacherServiceImpl;
	private int page; // 第几页
	private PageBean pageBean; // 包含分页信息的bean
	@Autowired
	@Qualifier("userDao")
	private static UserDao userDao;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	public static UserDao getUserDao() {
		return userDao;
	}

	public static void setUserDao(UserDao userDao) {
		TeacherServiceImplTest.userDao = userDao;
	}

	// 运行之前，加载spring配置文件
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("加载配置文件……");
		@SuppressWarnings("resource")
		ApplicationContext context = new FileSystemXmlApplicationContext(
				new String[] { "src/applicationContext.xml" });

		System.out.println("加载配置文件成功");
		//获取spring配置文件中对Service依赖注入的bean值
		teacherServiceImpl = (TeacherServiceImpl) context
				.getBean("teacherService");
		userDao = (UserDao) context.getBean("userDao");
	}

	/**
	 * 测试多对一查询，能不能取到数据
	 * 而不采用一对多，便于分页
	 */
	@SuppressWarnings("unused")
	@Test
	public void testRueryPassForPage() {
		int pageSize = 5;
		String state="已通过";
		// 进行多对一查询，查询的结果为User对象的list集合，其中每一个User对象
		// 封装了相对应的Project对象
		final String hql = "from User as u where u.project is not null and u.state=? "; // 多对一查询
		int allRow = getUserDao().getAllRowCount(hql,state); // 总记录数
		int totalPage = PageBean.countTotalPage(pageSize, allRow); // 总页数
		final int offset = PageBean.countOffset(pageSize, page); // 当前页开始记录
		final int length = pageSize; // 每页记录数
		final int currentPage = PageBean.countCurrentPage(page);
		List<User> list = getUserDao().findByPage(hql,state, offset, length); // "一页"的记录
//		List<User> listTrue = new ArrayList<User>();
//		List<User> listFalse = new ArrayList<User>();
//		for (User user : list) {
//			System.out.println(user.getUsername());
//			System.out.println(user.getProject().getName());
//
//		}
		for (User user : list) {
//			System.out.println(user.getState());
//			if(user.getState().equals("已通过")){
//				listTrue.add(user);
//			}
//			else if(user.getState().equals("未通过")) {
//				listFalse.add(user);
//			}
			System.out.println(user.getUsername());
			System.out.println(user.getProject().getName());
		}
//		System.out.println(listTrue.size());
//		for (User user : listFalse) {
//		System.out.println(user.getUsername());
//		System.out.println(user.getProject().getName());
//
//	}
	}

}
