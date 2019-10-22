package com.devin.blog.web.admin;

import com.devin.blog.po.Tag;
import com.devin.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class TagController {


    @Autowired
    private TagService tagService;

    @GetMapping("/tags")
    public String list(@PageableDefault(size = 5, sort = {"id"}, direction = Sort.Direction.DESC)
                               Pageable pageable, Model model) {
        model.addAttribute("page", tagService.listTag(pageable));
        return "admin/tags";
    }

    @GetMapping("/tags/input")
    public String addInput() {
        return "admin/tags-input";
    }

    @PostMapping("/tags")
    public String save(Tag tag) {
        Tag t = tagService.saveTag(tag);
        if (t == null) {

        } else {

        }
        return "redirect:/admin/tags";
    }
}
