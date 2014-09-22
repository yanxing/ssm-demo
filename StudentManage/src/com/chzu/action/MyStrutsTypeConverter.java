package com.chzu.action;

import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import com.chzu.model.ClassGrade;

/**
 * 自定义类型转化器
 * @author Administrator
 *
 */
public class MyStrutsTypeConverter extends StrutsTypeConverter {

	@SuppressWarnings("rawtypes")
	@Override
	public Object convertFromString(Map arg0, String[] arg1, Class arg2) {
//		String clasgradeString=arg1[6];
//		ClassGrade classGrade=new ClassGrade();
		if (arg2==ClassGrade.class) {
//			student.setClassGrade(classGradeString);
//			return (ClassGrade)clasgradeString;
		}
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public String convertToString(Map arg0, Object arg1) {
		return null;
	}

}
