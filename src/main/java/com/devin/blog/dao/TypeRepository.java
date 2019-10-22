package com.devin.blog.dao;

import com.devin.blog.po.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface TypeRepository extends CrudRepository<Type, Long> {

    Page<Type> findAll(Pageable pageable);

    Type findByName(String name);
}
