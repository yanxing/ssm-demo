package com.chzu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.chzu.model.User;

/**
 * 对user增删改查接口，通过注解方式
 * 
 * @author yanxing
 *
 */
public interface UserDaoByAnnotation {

	// 根据id查询User,方法名需要和XML文件中id值对应
	@Select("select * from user_table where id=#{id}")
	public User getUser(Integer id);

	// 查询所有的user
	@Select("select * from user_table")
	public List<User> getAllUser();

	// 添加user
	@Insert("inser into user_table(name,sex,address) values(#{name},#{sex},#{address})")
	public void saveUser(User user);

	// 更新user
	@Update("update user_table set name=#{name},sex=#{sex},address=#{address} where id=#{id}")
	public void updateUser(User user);

	// 删除user
	@Delete("delete from user_table where id=#{id}")
	public void deleteUser(Integer id);

}
