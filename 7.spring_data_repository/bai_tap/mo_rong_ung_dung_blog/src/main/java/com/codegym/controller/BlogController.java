package com.codegym.controller;

import com.codegym.entity.Blog;
import com.codegym.entity.Category;
import com.codegym.service.BlogService;
import com.codegym.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("categoryList")
    public Page<Category> categoryList(Pageable pageable){
        return categoryService.findAll(pageable);
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }
    @GetMapping("/home-blog")
    public String list(Model model, @PageableDefault(size = 3) Pageable pageable,
                       @RequestParam Optional<String> keyword) {
        String keywordAfterCheck = "";

        if (!keyword.isPresent()) {
            model.addAttribute("listBlog", this.blogService.findAllByOrderByDateOfWriting(pageable));
        } else {
            keywordAfterCheck = keyword.get();
            model.addAttribute("listBlog", this.blogService.searchByTitle(keywordAfterCheck, pageable));
        }
        model.addAttribute("keywordAfterCheck", keywordAfterCheck);

        return "blog/list";
    }

    @GetMapping("/blog/create")
    public String create(Model model) {
        model.addAttribute("blog", new Blog());
        return "blog/create";
    }

    @PostMapping("/blog/save")
    public String save(@ModelAttribute Blog blog, RedirectAttributes redirect) {
        blogService.save(blog);
        redirect.addFlashAttribute("success", "Saved customer successfully!");
        return "redirect:/home-blog";
    }

    @GetMapping("/blog/{id}/edit")
    public String edit(@PathVariable String id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "blog/edit";
    }

    @PostMapping("/blog/update")
    public String update(@ModelAttribute Blog blog, RedirectAttributes redirect) {
        blogService.save(blog);
        redirect.addFlashAttribute("success", "Modified customer successfully!");
        return "redirect:/home-blog";
    }

    @GetMapping("/blog/{id}/delete")
    public String delete(@PathVariable String id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "blog/delete";
    }

    @PostMapping("/blog/delete")
    public String delete(@ModelAttribute Blog blog, RedirectAttributes redirect) {
        blogService.remove(blog);
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/home-blog";
    }

    @GetMapping("/blog/{id}/view")
    public String view(@PathVariable String id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "blog/view";
    }
}
