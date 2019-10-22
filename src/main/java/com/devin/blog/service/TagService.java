package com.devin.blog.service;

import com.devin.blog.po.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TagService {

    /**
     * 新增标签
     *
     * @param Tag 标签
     * @return 添加后的标签
     */
    Tag saveTag(Tag Tag);

    /**
     * 根据 id 查询标签
     *
     * @param id 标签 id
     * @return 指定标签
     */
    Tag getTag(Long id);

    /**
     * 分页查询
     *
     * @param pageable 分页对象
     * @return 标签列表
     */
    Page<Tag> listTag(Pageable pageable);

    /**
     * 更新标签信息
     *
     * @param id  标签 id
     * @param Tag 更新后的标签
     * @return 更新后的标签
     */
    Tag updateTag(Long id, Tag Tag);

    /**
     * 删除标签
     *
     * @param id 标签 id
     */
    void deleteTag(Long id);
}

