package com.chzu.tic.action;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.chzu.tic.model.News;
import com.chzu.tic.model.User;
import com.chzu.tic.util.PageBean;
import com.opensymphony.xwork2.ModelDriven;

public class AdminAction extends AdminBaseAction implements
		ModelDriven<AdminAction>, ServletRequestAware {
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private AdminAction adminAction;
	private News news = new News();
	private User user = new User();

	private int page; // 第几页
	private PageBean pageBean; // 包含分布信息的bean
	//提示信息
    private String tip;

	public int getPage() {
		return page;
	}

	public void setPage(int page) { // 若URL中无此参数,会默认为第1页
		this.page = page;
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}
	
	/**
	 * 加载新闻发布news_release.jsp
	 * 
	 * @return
	 * @throws Exception
	 */
	public String release() throws Exception {
		return "release";
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	/**
	 * 添加公告。。。
	 * 
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception {
		news.setTitle(request.getParameter("news_title"));
		news.setContent(request.getParameter("news_content"));
		SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
		String date = fm.format(new Date());
		Timestamp time = new Timestamp(fm.parse(date).getTime());
		news.setDate(time);
		System.out.println(news.getTitle());
		System.out.println(news.getContent());
		System.out.println(news.getDate());
		adminService.saveNotice(news);
		return "success";
	}

	@Override
	public AdminAction getModel() {
		return adminAction;
	}

	/**
	 * 获得所有用户的信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String user() throws Exception {
		List<User> lists = adminService.findAllUser();
		for (User user : lists) {
			System.out.println(user);
		}
		request.setAttribute("lists", lists);
		return "list_user";
	}

	/**
	 * 管理员添加用户 需要对此方法的各个参数的空值情况进行判断， 用public String validateAddoneUser()throws
	 * Exception进行判断， 或者用jquery判断
	 * 
	 * @return
	 * @throws Exception
	 */
	public String addoneUser() throws Exception {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");
		String email = request.getParameter("email");
		String type = request.getParameter("type1");
		user=adminService.findByName(username);
		if (user.getUsername().equals(username)) {//用户已存在
			setTip("该用户名已存在！");
			return "input";
		}
		user.setPassword(password);
		user.setRepassword(repassword);
		if (user.getPassword().equals(user.getRepassword())) {
			user.setUsername(username);
			user.setPassword(password);
			user.setEmail(email);
			user.setType(Integer.parseInt(type));
			adminService.addUser(user);
		}
		return "success";
	}

	/**
	 * 对用户添加进行验证
	 * 
	 * @return
	 * @throws Exception
	 */
	public String validateAddoneUser() throws Exception {
		// if(request.getParameter("password")!=request.getParameter("repassword"))
		// {
		// String result="两次密码不一致";
		// request.setAttribute("result", "result");
		//
		// }

		return "admin_addoneUser";
	}

	/**
	 * 新闻管理分页显示
	 * 
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception {
		// 分页的pageBean,参数pageSize表示每页显示记录数,page为当前页
		pageBean = adminService.queryForPage(5, page);
		return "newsLists";
	}

	/**
	 * deleteOneUser 从getUserList.jsp的删除action跳转过来。。。 管理用户模块， 删除某个用户
	 */
	public String deleteOneUser() throws Exception {
		String userId = request.getParameter("userId");
		Integer id = Integer.parseInt(userId);
		adminService.delete(id);
		// 上面是执行删除操作，下面是再执行查找操作。。。。
		List<User> lists = adminService.findAllUser();
		request.setAttribute("lists", lists);
		return "getUsersList";

	}

	/**
	 * showOneNews 编辑news功能
	 */
	public String showOneNews() throws Exception {
		// 测试是否能拿到数据。。。
		String newsId = request.getParameter("notice.id");
		// System.out.println(newsId);
		Integer id = Integer.parseInt(newsId);
		// 执行按照NewsID查找新闻。。。
		news = adminService.get(id);
		// System.out.println(news);
		request.setAttribute("news", news);
		return "newsUpdate";

	}

	/**
	 * deleteOneNews
	 */
	public String deleteOneNews() throws Exception {

		news.setId(Integer.parseInt(request.getParameter("notice.id")));
		Integer id = news.getId();
		System.out.println(id);
		adminService.deleteOneNews(id);
		// 分页的pageBean,参数pageSize表示每页显示记录数,page为当前页
		pageBean = adminService.queryForPage(5, page);
		return "newsLists";
	}

	/**
	 * updateOneNews 编辑新闻。。。
	 */
	public String updateOneNews() throws Exception {
		String newsId = request.getParameter("id");
		// System.out.println(newsId);
		news = adminService.get(Integer.parseInt(newsId));
		news.setTitle(request.getParameter("news_title"));
		news.setContent(request.getParameter("news_content"));
		SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
		String date = fm.format(new Date());
		Timestamp time = new Timestamp(fm.parse(date).getTime());
		news.setDate(time);
		// System.out.println(news.getTitle());
		// System.out.println(news.getContent());
		// System.out.println(news.getDate());
		adminService.UpdateOneNews(news);
		return "add";
	}

	/**
	 * newsdetails 新闻详情。。。
	 */
	public String newsDetails() throws Exception {
		String newsId = request.getParameter("notice.id");
		news = adminService.get(Integer.parseInt(newsId));
		request.setAttribute("news", news);
		return "newsdetails";
	}

}
