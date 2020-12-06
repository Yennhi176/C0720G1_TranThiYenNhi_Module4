package com.codegym.controller;

import com.codegym.repository.BlogRepository;
import com.codegym.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/home-category")
    public ResponseEntity<List<BlogRepository.Category>> getAllCategory() {
        List<BlogRepository.Category> listCategory = categoryService.findAll();
       if (listCategory.size()==0){
           return new ResponseEntity<>(HttpStatus.NO_CONTENT);
       }
       return new ResponseEntity<>(listCategory,HttpStatus.OK);
    }

    @GetMapping("/category/create")
    public String create(Model model) {
        model.addAttribute("category", new BlogRepository.Category());
        return "category/create";
    }

    @PostMapping("/category/save")
    public String save(@ModelAttribute BlogRepository.Category category, RedirectAttributes redirect) {
        categoryService.save(category);
        redirect.addFlashAttribute("success", "Saved customer successfully!");
        return "redirect:/home-category";
    }
    @GetMapping("/category/{id}/edit")
    public String edit(@PathVariable String id, Model model) {
        model.addAttribute("category", categoryService.findById(id));
        return "category/edit";
    }
    @PostMapping("/category/update")
    public String update(@ModelAttribute BlogRepository.Category category, RedirectAttributes redirect) {
        categoryService.save(category);
        redirect.addFlashAttribute("success", "Modified customer successfully!");
        return "redirect:/home-category";
    }

    @GetMapping("/category/{id}/delete")
    public String delete(@PathVariable String id, Model model) {
        model.addAttribute("category", categoryService.findById(id));
        return "category/delete";
    }

    @PostMapping("/category/delete")
    public String delete(@ModelAttribute BlogRepository.Category category, RedirectAttributes redirect) {
        categoryService.remove(category);
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/home-category";
    }
}
