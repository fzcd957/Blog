package com.devin.blog.dao;

import com.devin.blog.po.Type;
import org.springframework.data.jpa.repository.JpaRepository;
public interface TypeRepository extends JpaRepository<Type, Long> {

    Type findByName(String name);
}
