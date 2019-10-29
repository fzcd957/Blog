package com.devin.blog.service;

import com.devin.blog.po.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TypeService {

    /**
     * 新增分类
     *
     * @param type 分类
     * @return 添加后的分类
     */
    Type saveType(Type type);

    /**
     * 根据 id 查询分类
     *
     * @param id 分类 id
     * @return 指定分类
     */
    Type getType(Long id);

    /**
     * 根据名称查询分类
     *
     * @param name 分类名称
     * @return 指定分类
     */
    Type getTypeByName(String name);

    /**
     * 分页查询
     *
     * @param pageable 分页对象
     * @return 分类列表
     */
    Page<Type> listType(Pageable pageable);

    /**
     * 更新分类信息
     *
     * @param id   分类 id
     * @param type 更新后的分类
     * @return 更新后的分类
     */
    Type updateType(Long id, Type type);

    /**
     * 删除分类
     *
     * @param id 分类 id
     */
    void deleteType(Long id);

    /**
     * 获取所有的分类
     *
     * @return 所有分类列表
     */
    List<Type> listType();

    List<Type> listTop(Integer size);
}
