package com.codegym.controller;

import com.codegym.entity.Book;
import com.codegym.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;
    @GetMapping({"","/list"})
    public String goToList(Model model){
        model.addAttribute("listBook",bookService.findAll());
        return "list";
    }
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("book",new Book());
        return "create";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute Book book, RedirectAttributes redirectAttributes){
        bookService.save(book);
        redirectAttributes.addFlashAttribute("success", "Saved book successfully!");
        return "redirect:/list";
    }
    @GetMapping("/view/{id}")
    public String goToView(@PathVariable Integer id, Model model){
        model.addAttribute("book",bookService.findById(id));
        return "view";
    }
    @GetMapping("/borrowed")
    public String view(@RequestParam(value = "id") Integer id,RedirectAttributes redirectAttributes) throws Exception {
        redirectAttributes.addFlashAttribute("success", "borrowed successfully  " +   bookService.borrowBooks(id));
        return "redirect:/list";
    }
    @GetMapping("/give/{id}")
    public String goToGive(@PathVariable Integer id,Model model){
        model.addAttribute("id",id);
        return "give";
    }
    @PostMapping("/give")
    public String give(@RequestParam Integer id,@RequestParam Integer bookNumber,RedirectAttributes redirectAttributes) {
        String success = bookService.giveBookBack(id,bookNumber);
        redirectAttributes.addFlashAttribute("success",success);
        return "redirect:/list";
    }

    @ExceptionHandler(value = Exception.class)
    public String catchException() {
        return "error_page";
    }
}
