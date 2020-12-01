package com.codegym.controller;

import com.codegym.entity.Blog;
import com.codegym.entity.Category;
import com.codegym.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/home-category")
    public String list(Model model) {
        List<Category> listCategory = categoryService.findAll();
        model.addAttribute("listCategory", listCategory);
        return "category/list";
    }

    @GetMapping("/category/create")
    public String create(Model model) {
        model.addAttribute("category", new Category());
        return "category/create";
    }

    @PostMapping("/category/save")
    public String save(@ModelAttribute Category category, RedirectAttributes redirect) {
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
    public String update(@ModelAttribute Category category, RedirectAttributes redirect) {
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
    public String delete(@ModelAttribute Category category, RedirectAttributes redirect) {
        categoryService.remove(category);
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/home-category";
    }
}
