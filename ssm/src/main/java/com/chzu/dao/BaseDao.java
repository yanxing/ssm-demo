package com.chzu.dao;

import java.util.ArrayList;

/**
 * 超级接口
 * @author yanxing on 2015/1/28.
 */
public interface BaseDao<T> {

    /**
     * 查找
     */
    public T get(Integer id);

    /**
     * 增加
     */
    public void save(T object );

    /**
     * 删除
     */
    public void delete(Integer id);

    /**
     * 更新
     */
    public void update(T object);

}
