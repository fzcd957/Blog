package com.devin.blog.web;

import com.devin.blog.service.BlogService;
import com.devin.blog.service.TagService;
import com.devin.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private TagService tagService;

    @GetMapping("/")
    public String index(@PageableDefault(size = 7, sort = {"updateTime"}, direction = Sort.Direction.DESC)
                                Pageable pageable, Model model) {
        model.addAttribute("page", blogService.listBlog(pageable));
        model.addAttribute("types", typeService.listTop(6));
        model.addAttribute("tags", tagService.listTop(10));
        model.addAttribute("recommendBlogs", blogService.listRecommendBlog(8));
        return "index";
    }

    @GetMapping("/search")
    public String search(@PageableDefault(size = 7, sort = {"updateTime"}, direction = Sort.Direction.DESC)
                                 Pageable pageable, Model model, @RequestParam String query) {
        model.addAttribute("page", blogService.listBlog("%" + query + "%", pageable));
        model.addAttribute("query", query);
        return "search";
    }

    @GetMapping("/blog/{id}")
    public String blog(@PathVariable Long id, Model model) {
        model.addAttribute("blog", blogService.getBlog(id));
        return "blog";
    }
}
