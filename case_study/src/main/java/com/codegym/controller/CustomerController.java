package com.codegym.controller;

import com.codegym.entity.customer.Customer;
import com.codegym.entity.customer.CustomerType;
import com.codegym.service.customer.CustomerService;
import com.codegym.service.customer.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerTypeService customerTypeService;

    @ModelAttribute("listCustomerType")
    public List<CustomerType> listCustomerType(){
        return customerTypeService.findAll();
    }
    @GetMapping("/list")
    public String goToList(Model model, @PageableDefault(size = 3) Pageable pageable,
                           @RequestParam Optional<String> keyword){
        String keywordAfterCheck = "";
        if (!keyword.isPresent()){
            model.addAttribute("listCustomer",customerService.findAllBy(pageable));
        }else {
            keywordAfterCheck = keyword.get();
            model.addAttribute("listCustomer",this.customerService.findByCustomerNameContainingOrCustomerAddressContaining(keywordAfterCheck,keywordAfterCheck,pageable));
        }
        model.addAttribute("keywordAfterCheck",keywordAfterCheck);

        return "customer/list";
    }

    @GetMapping("/create")
    public String goToCreate(Model model){
        model.addAttribute("customer",new Customer());
        model.addAttribute("listCustomer",customerService.findAll());
        return "customer/create";
    }
    @PostMapping("/save")
    public String save(Model model,@Valid @ModelAttribute Customer customer, BindingResult bindingResult,
                       RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            model.addAttribute("listCustomer",customerService.findAll());
            return "customer/create";
        }
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("success","Saved customer successfully!");
        return "redirect:/customer/list";
    }
    @GetMapping("/{id}/edit")
    public String goToEdit(@PathVariable Long id,Model model){
        model.addAttribute("customer",customerService.findById(id));
        return "customer/edit";
    }
    @PostMapping("/update")
    public String Edit(Model model,@Valid @ModelAttribute Customer customer,BindingResult bindingResult,RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            model.addAttribute("listCustomer",customerService.findAll());
            return "customer/create";
        }
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("success", "Modified customer successfully!");
        return "redirect:/customer/list";
    }
    @GetMapping("/delete")
    public String goToDelete(@RequestParam String idDelete){
     Customer customer=  this.customerService.findById(Long.parseLong(idDelete));
       this.customerService.delete(customer);
        return "redirect:/customer/list";
    }
//    @PostMapping("/delete")
//    public String delete(@ModelAttribute Customer customer,RedirectAttributes redirectAttributes){
//        customerService.delete(customer);
//        redirectAttributes.addFlashAttribute("success", "Removed customer successfully!");
//        return "redirect:/customer/list";
//    }
    @GetMapping("/{id}/view")
    public String view(@PathVariable Long id,Model model){
        model.addAttribute("customer",customerService.findById(id));
        return "/customer/view";
    }
}
