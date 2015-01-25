package com.chzu.dao;

import java.util.List;

import com.chzu.model.User;

/**
 * 增删改查接口,通过XML实现
 * @author yanxing
 *
 */
public interface UserDao {
	
	//根据id查询User,方法名需要和XML文件中id值对应
	public User getUser(Integer id);
	
	//查询所有的user
	public List<User> getAllUser();
	
	//添加user
	public void saveUser(User user);
	
	//更新user
	public void updateUser(User user);
	
	//删除user
    public void deleteUser(Integer id);

}
