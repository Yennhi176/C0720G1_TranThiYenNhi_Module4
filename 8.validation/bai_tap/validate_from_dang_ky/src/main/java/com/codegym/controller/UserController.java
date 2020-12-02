package com.codegym.controller;

import com.codegym.entity.User;
import com.codegym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping({"", "/list"})
    public String goList(Model model) {
        model.addAttribute("listUser", userService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String goCreateUser(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("listUser", userService.findAll());
        return "create";
    }

    @PostMapping("/create")
    public String createUser(Model model, @Valid @ModelAttribute User user,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("listUser", userService.findAll());
            return "create";
        }
        userService.save(user);
        redirectAttributes.addFlashAttribute("success", "Register successfully!");
        return "redirect:/list";
    }
}
