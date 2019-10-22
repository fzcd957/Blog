package com.devin.blog.dao;

import com.devin.blog.po.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface TagRepository extends CrudRepository<Tag, Long> {

    Page<Tag> findAll(Pageable pageable);

    Tag findByName(String name);
}
