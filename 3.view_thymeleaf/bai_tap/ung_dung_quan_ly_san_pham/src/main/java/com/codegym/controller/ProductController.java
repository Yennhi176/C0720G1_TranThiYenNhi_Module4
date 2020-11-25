package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.ProductService;
import com.codegym.service.impl.ProductServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {

    private ProductService productService = new ProductServiceImpl();

    @GetMapping("/")
    public String index(Model model) {
        List<Product> listProduct = productService.findAll();
        model.addAttribute("listProduct", listProduct);
        return "/index";
    }

    @GetMapping("/product/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }

    @PostMapping("/product/save")
    public String save(@ModelAttribute Product product, RedirectAttributes redirect) {
        product.setId((int) (Math.random() * 1000));
        productService.save(product);
        redirect.addFlashAttribute("success", "Saved customer successfully!");
        return "redirect:/";
    }

    @GetMapping("/product/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/edit";
    }
    @PostMapping("/product/update")
    public String update(@ModelAttribute Product product,RedirectAttributes redirect){
        productService.update(product.getId(),product);
        redirect.addFlashAttribute("success","Modified customer successfully!");
        return "redirect:/";
    }
    @GetMapping("/product/{id}/delete")
    public String delete(@PathVariable int id,Model model){
        model.addAttribute("product",productService.findById(id));
        return "/delete";
    }
    @PostMapping("/product/delete")
    public String delete(@ModelAttribute Product product,RedirectAttributes redirect){
        productService.remove(product.getId());
        redirect.addFlashAttribute("success","Removed customer successfully!");
        return "redirect:/";
    }
    @GetMapping("/product/{id}/view")
    public String view(@PathVariable int id,Model model){
        model.addAttribute("product",productService.findById(id));
        return "/view";
    }
}
