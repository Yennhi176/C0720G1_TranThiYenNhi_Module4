package com.codegym.controller;

import com.codegym.entity.Blog;
import com.codegym.repository.BlogRepository;
import com.codegym.service.BlogService;
import com.codegym.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
@RestController
@Controller
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/home-blog")
    public ResponseEntity<List<Blog>> list() {
        List<Blog> listBlog = blogService.findAll();
        if (listBlog.size()==0){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listBlog,HttpStatus.OK);
    }

    @ModelAttribute("categoryList")
    public Page<BlogRepository.Category> categoryList(Pageable pageable){
        return categoryService.findAll(pageable);
    }

    @GetMapping("/")
    public String index(){
        return "index";
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
    public ResponseEntity<Blog> view(@PathVariable String id) {
        Blog blog = blogService.findById(id);
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

}
