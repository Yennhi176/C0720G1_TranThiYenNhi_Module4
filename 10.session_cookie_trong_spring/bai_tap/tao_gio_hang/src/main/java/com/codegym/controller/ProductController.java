package com.codegym.controller;

import com.codegym.entity.Product;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes(value = "listProduct")
public class ProductController {
    @Autowired
    private ProductService productService;

    @ModelAttribute("listProduct")
    public List<Product> listProduct() {
        return new ArrayList<>();
    }

    @GetMapping({"", "product/list"})
    public String list(Model model, RedirectAttributes redirectAttributes) {
        List<Product> listProduct = productService.findAll();
        model.addAttribute("product", listProduct);
        return "product/list";
    }

    @GetMapping("/list-cart")
    public String listProduct(Model model) {
        return "product/list-cart";
    }


    @GetMapping("/create")
    public String goToCreate(Model model) {
        model.addAttribute("product", new Product());
        return "product/create";
    }

    @PostMapping("/save")
    public String create(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        productService.save(product);
        redirectAttributes.addFlashAttribute("success", "Saved product successfully!");
        return "redirect:/product/list";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable Integer id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "product/view";
    }

    @GetMapping("/{id}/addProduct")
    public String addProduct(@SessionAttribute(value = "listProduct") List<Product> listProduct, @PathVariable Integer id, Model model) {
        Product product = productService.findById(id);
        listProduct.add(product);
        return "redirect:/list-cart";
    }

    @GetMapping("/{id}/delete")
    public String deleteProductList(List<Product> listProduct, @PathVariable Integer id) {
        for (Product product : listProduct) {
            if (product.getId().equals(id)) {
                listProduct.remove(product);
                break;
            }
        }
        return "redirect:/list-cart";
    }

    @GetMapping("/deleteAll")
    public String deleteAll(@SessionAttribute List<Product> listProduct) {
      listProduct.clear();
        return "redirect:/list-cart";
    }
}
