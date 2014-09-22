package com.chzu.service.impl;

import com.chzu.dao.AdminDao;
import com.chzu.dao.ClassGradeDao;
import com.chzu.dao.DepartmentDao;
import com.chzu.dao.ProfessionalDao;
import com.chzu.dao.StudentDao;

public class BaseService {

	protected AdminDao adminDao;
	protected ClassGradeDao classGradeDao;
	protected DepartmentDao departmentDao;
	protected ProfessionalDao professionalDao;
	protected StudentDao studentDao;

	public AdminDao getAdminDao() {
		return adminDao;
	}

	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	public ClassGradeDao getClassGradeDao() {
		return classGradeDao;
	}

	public void setClassGradeDao(ClassGradeDao classGradeDao) {
		this.classGradeDao = classGradeDao;
	}

	public DepartmentDao getDepartmentDao() {
		return departmentDao;
	}

	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	public ProfessionalDao getProfessionalDao() {
		return professionalDao;
	}

	public void setProfessionalDao(ProfessionalDao professionalDao) {
		this.professionalDao = professionalDao;
	}

	public StudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

}
