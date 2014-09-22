package com.chzu.service;


import java.util.Date;
import java.util.List;

import com.chzu.model.Admin;
import com.chzu.model.ClassGrade;
import com.chzu.model.Student;
import com.chzu.util.PageBean;

public interface AdminService {
	
	int validLogin(Admin admin);//管理员验证登录
	
	public Student validLogin(Student student);//学生验证登录
	
	/**
 	 * 验证添加的学生是否已经存在
 	 */
	public Boolean exit(String number);
	
    /**
	 * 根据学号查询学生
	 */
    public Student findByName(String number);
    
    /**
     * 根据id查询学生
     */
    public Student findStudent(Integer id);
    
    
    
    /**
     * 根据id删除学生
     */
    public void deleteStudent( Integer id);
    
    /**
     * 更新学生全部信息
     */
    public void updateStudent(Student student);
    
    /**
     *
     * 更新学生信息
     * @param number 学号
     * @param username  姓名
     * @param sex 性别
     * @param birthday 出生日期
     * @param phone 手机号
     * @param id 指定要更新学生的id
     */
    public void updateStudent(String number,String username,String sex,Date birthday,String phone,Integer id);
    
    
    /**
     * 添加学生
     * 
     */
    public void addStudent(Student user);
    
    /**
     * 学生分页查询
     * @param pageSize 每页大小
     * @param page 当前第几页
     * @return 封装了分页信息(包括记录集list)的Bean
     */
    public PageBean queryUserForPage(int pageSize,int currentPage);
    
    public Boolean isMobile(String mobile);
    
    /**
     * 获取所有班级
     * @return
     */
    public List<ClassGrade> findAllClassGrade();
    
    /**
     * 根据id获取班级
     * @return
     */
    public ClassGrade findById(Integer id);
    
    /**
     * 根据名称获取班级
     */
    public ClassGrade findClassGradeByName(String name);	
    
    /**
     * 获取同一个班的学生
     * @param clasid 班级id
     * @return
     */
    public List<Student> getStudentList(Integer clasid);
    
    	
}
