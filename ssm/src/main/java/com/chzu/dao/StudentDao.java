package com.chzu.dao;

import com.chzu.model.Student;

/**
 * student数据操作
 * @author yanxing on 2015/1/28.
 */
public interface StudentDao  extends  BaseDao<Student>{

    @Override
    Student get(Integer id);

    @Override
    void delete(Integer id);

    @Override
    void save(Student object);

    @Override
    void update(Student object);
}
