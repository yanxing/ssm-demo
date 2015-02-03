package com.chzu.dao;

import com.chzu.model.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author yanxing on 2015/1/28.
 * student数据操作
 */
public interface StudentDao extends BaseDao<Student> {

    @Select("select * from student where id=#{id}")
    @Override
    public Student get(Integer id);

    @Delete("delete from student where id=#{id}")
    @Override
    public void delete(Integer id);

    @Insert("insert into student(number,name,sex,birthday) values(#{number},#{name},#{sex},#{birthday})")
    @Override
    public void save(Student object);

    @Update("update student set number=#{number},name=#{name},sex=#{sex},birthday=#{birthday}")
    @Override
    public void update(Student object);

    @Select("select * from student")
    public List<Student> findAll();
}
