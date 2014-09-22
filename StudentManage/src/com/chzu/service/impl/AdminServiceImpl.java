package com.chzu.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.chzu.model.Admin;
import com.chzu.model.ClassGrade;
import com.chzu.model.Student;
import com.chzu.service.AdminService;
import com.chzu.util.PageBean;

public class AdminServiceImpl extends BaseService implements AdminService {

	/**
	 * 返回0登陆成功，返回-1登陆失败
	 */
	@Override
	public int validLogin(Admin admin) {
		if (adminDao.findByNameAndPass(admin).size() > 0) {
			return 0;
		}
		return -1;
	}
	
	/**
	 * 成功返回student对象，否则返回null
	 */
	@Override
	public Student validLogin(Student student) {
		if(studentDao.findByNameAndPass(student).size()>0){
			return studentDao.findByNameAndPass(student).get(0);
		}
		
		return null;
	}

	@Override
	public PageBean queryUserForPage(int pageSize, int page) {
		final String hql = "from Student"; // 查询语句
		int allRow = studentDao.getAllRowCount(hql); // 总记录数
		int totalPage = PageBean.countTotalPage(pageSize, allRow); // 总页数
		final int offset = PageBean.countOffset(pageSize, page); // 当前页开始记录
		final int length = pageSize; // 每页记录数
		final int currentPage = PageBean.countCurrentPage(page);
		List<Student> list = studentDao.findByPage(hql, offset, length); // "一页"的记录

		// 把分页信息保存到Bean中
		PageBean pageBean = new PageBean();
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(currentPage);
		pageBean.setAllRow(allRow);
		pageBean.setTotalPage(totalPage);
		pageBean.setList(list);
		pageBean.init();
		return pageBean;
	}

	@Override
	public Boolean exit(String number) {
	    Student listFile =studentDao.findByName(number);
		if (listFile!=null) {// 相同用户已存在
			return true;
		}
		return false;
	}

	@Override
	public Student findByName(String name) {
		return studentDao.findByName(name);
	}

	@Override
	public void deleteStudent(Integer id) {
		studentDao.delete(id);

	}

	@Override
	public void updateStudent(Student user) {
		studentDao.update(user);

	}

	@Override
	public void addStudent(Student user) {
		studentDao.save(user);

	}

	@Override
	public Student findStudent(Integer id) {
		return studentDao.get(id);
	}

	/**
	 * 
	 * @param mobile
	 *            手机号
	 * @return 手机号格式正确返回true，错误返回false
	 */
	public Boolean isMobile(String mobile) {
		// ^ ：匹配输入的开始位置
		// \：将下一个字符标记为特殊字符或字面值
		// * ：匹配前一个字符零次或几次
		// + ：匹配前一个字符一次或多次
		// (pattern) 与模式匹配并记住匹配
		// \w ：与任何单词字符匹配，包括下划线
		// {n,m} 最少匹配 n 次且最多匹配 m 次
		// [a-z] ：表示某个范围内的字符。与指定区间内的任何字符匹配
		// ?：匹配前面的子表达式零次或一次
		// $ ：匹配输入的结尾
		String regex = "^((\\+86)|(86))?\\d{11}$";// 匹配手机号前带86或是+86的情况
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(mobile);
		return matcher.matches();
	}


	@Override
	public void updateStudent(String number, String username, String sex,
			Date birthday, String phone, Integer id) {
		studentDao.update("update Student t set t.number='"
				+ number + "',t.username = '"
				+ username + "',t.sex='" + sex
				+ "',t.birthday='" + birthday + "',t.phone='"
				+ phone + "'" + " where id ='" + id
				+ "'");
		
	}

	@Override
	public List<ClassGrade> findAllClassGrade() {
		return classGradeDao.findAll();
	}

	@Override
	public ClassGrade findById(Integer id ) {
	   return classGradeDao.get(id);
	}

	@Override
	public ClassGrade findClassGradeByName(String name) {
		return classGradeDao.findByName(name);
	}

	@Override
	public List<Student> getStudentList(Integer clasid) {
		List<Student> students=new ArrayList<Student>();
		//获取指定的班级
		ClassGrade classGrade=classGradeDao.get(clasid);
		//根据班级的students属性得到这个班的所有学生
		Set<Student> classGrades=classGrade.getStudents();
		for (Student student : classGrades) {//遍历set集合把学生放到list集合中
			students.add(student);
		}
		return students;
	}


}
