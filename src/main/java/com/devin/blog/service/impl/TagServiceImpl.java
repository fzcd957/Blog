package com.devin.blog.service.impl;

import com.devin.blog.dao.TagRepository;
import com.devin.blog.handler.NotFoundException;
import com.devin.blog.po.Tag;
import com.devin.blog.service.TagService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagRepository tagRepository;

    @Transactional
    @Override
    public Tag saveTag(Tag Tag) {
        return tagRepository.save(Tag);
    }

    @Transactional
    @Override
    public Tag getTag(Long id) {
        return tagRepository.findById(id).get();
    }

    @Transactional
    @Override
    public Page<Tag> listTag(Pageable pageable) {
        return tagRepository.findAll(pageable);
    }

    @Transactional
    @Override
    public Tag updateTag(Long id, Tag Tag) {
        Tag t = tagRepository.findById(id).get();
        if (t == null) {
            throw new NotFoundException("不存在该标签");
        }
        BeanUtils.copyProperties(Tag, t);
        return tagRepository.save(t);
    }

    @Transactional
    @Override
    public void deleteTag(Long id) {
        tagRepository.deleteById(id);
    }
}
