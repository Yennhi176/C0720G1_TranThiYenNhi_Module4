package com.codegym.controller;

import com.codegym.entity.employee.*;
import com.codegym.service.employee.*;
import com.codegym.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private PositionService positionService;
    @Autowired
    private DivisionService divisionService;
    @Autowired
    private EducationDegreeService educationDegreeService;
    @Autowired
    private UserService userService;

    @ModelAttribute("listPosition")
    public List<Position> listPosition() {
        return positionService.findAll();
    }

    @ModelAttribute("listDivision")
    public List<Division> listDivision() {
        return divisionService.findAll();
    }

    @ModelAttribute("listEducationDegree")
    public List<EducationDegree> listEducationDegree() {
        return educationDegreeService.findAll();
    }

    @ModelAttribute("listUser")
    public List<AppUser> listUser() {
        return userService.findAll();
    }

    @GetMapping("/list")
    public String goToList(Model model, @PageableDefault(size = 3) Pageable pageable,
                           @RequestParam Optional<String> keyword) {
        String keywordAfterCheck = "";
        if (!keyword.isPresent()) {
            model.addAttribute("listEmployee", employeeService.findAllBy(pageable));
        } else {
            keywordAfterCheck = keyword.get();
            model.addAttribute("listEmployee", employeeService.searchByName(keywordAfterCheck, pageable));
        }
        model.addAttribute("keywordAfterCheck", keywordAfterCheck);

        return "employee/list";
    }

    @GetMapping("/create")
    public String goToCreate(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("listEmployee", employeeService.findAll());

        return "employee/create";
    }

    @PostMapping("/save")
    public String save(Model model, @Valid @ModelAttribute Employee employee, BindingResult bindingResult,
                       RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("listEmployee", employeeService.findAll());
            return "employee/create";
        }
        employeeService.save(employee);
        redirectAttributes.addFlashAttribute("success", "Saved customer successfully!");
        return "redirect:/employee/list";
    }

    @GetMapping("/{id}/edit")
    public String goToEdit(@PathVariable Long id, Model model) {
        model.addAttribute("employee", employeeService.findById(id));
        return "employee/edit";
    }

    @PostMapping("/update")
    public String Edit(@ModelAttribute Employee employee, RedirectAttributes redirectAttributes) {
        employeeService.save(employee);
        redirectAttributes.addFlashAttribute("success", "Modified customer successfully!");
        return "redirect:/employee/list";
    }

    @GetMapping("/delete")
    public String goToDelete(@RequestParam String idDelete) {
        Employee employee = employeeService.findById(Long.parseLong(idDelete));
        employeeService.delete(employee);
        return "redirect:/employee/list";
    }

    //    @GetMapping("/{id}/delete")
//    public String goToDelete(@PathVariable Long id,Model model){
//        model.addAttribute("employee",employeeService.findById(id));
//        return "employee/delete";
//    }
//    @PostMapping("/delete")
//    public String delete(@ModelAttribute Employee employee,RedirectAttributes redirectAttributes){
//        employeeService.delete(employee);
//        redirectAttributes.addFlashAttribute("success", "Removed customer successfully!");
//        return "redirect:/employee/list";
//    }
    @GetMapping("/{id}/view")
    public String view(@PathVariable Long id, Model model) {
        model.addAttribute("employee", employeeService.findById(id));
        return "/employee/view";
    }

//    @RequestMapping(value = {"/welcome"}, method = RequestMethod.GET)
//    public String welcomePage(Model model) {
//        model.addAttribute("title", "Welcome");
//        model.addAttribute("message", "This is welcome page!");
//        return "login/welcomePage";
//    }
//
//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public String loginPage(Model model) {
//
//        return "login/loginPage";
//    }
//
//    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
//    public String logoutSuccessfulPage(Model model) {
//        model.addAttribute("title", "Logout");
//        return "login/logoutSuccessfulPage";
//    }
//
//    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
//    public String userInfo(Model model, Principal principal) {
//
//        // Sau khi user login thanh cong se co principal
//        String userName = principal.getName();
//
//        System.out.println("User Name: " + userName);
//
//        User loginedUser = (User) ((Authentication) principal).getPrincipal();
//
//        String userInfo = WebUtils.toString(loginedUser);
//        model.addAttribute("userInfo", userInfo);
//
//        return "login/userInfoPage";
//    }
//
//    @RequestMapping(value = "/admin", method = RequestMethod.GET)
//    public String adminPage(Model model, Principal principal) {
//
//        User loginedUser = (User) ((Authentication) principal).getPrincipal();
//
//        String userInfo = WebUtils.toString(loginedUser);
//        model.addAttribute("userInfo", userInfo);
//
//        return "login/adminPage";
//    }
//
//    @RequestMapping(value = "/403", method = RequestMethod.GET)
//    public String accessDenied(Model model, Principal principal) {
//
//        if (principal != null) {
//            User loginedUser = (User) ((Authentication) principal).getPrincipal();
//
//            String userInfo = WebUtils.toString(loginedUser);
//
//            model.addAttribute("userInfo", userInfo);
//
//            String message = "Hi " + principal.getName() //
//                    + "<br> You do not have permission to access this page!";
//            model.addAttribute("message", message);
//
//        }
//        return "login/403Page";
//    }
}
