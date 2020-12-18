package com.codegym.controller;

import com.codegym.entity.contract.Contract;
import com.codegym.entity.customer.Customer;
import com.codegym.entity.employee.Employee;
import com.codegym.entity.service_entity.RentType;
import com.codegym.entity.service_entity.ServiceEntity;
import com.codegym.entity.service_entity.ServiceType;
import com.codegym.service.contract.ContractService;
import com.codegym.service.customer.CustomerService;
import com.codegym.service.employee.EmployeeService;
import com.codegym.service.service_entity.ServiceEntityService;
import com.codegym.service.service_entity.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private ContractService contractService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private ServiceEntityService serviceEntityService;

    @ModelAttribute("listCustomer")
    public List<Customer> listCustomer() {
        return customerService.findAll();
    }

    @ModelAttribute("listEmployee")
    public List<Employee> listEmployee() {
        return employeeService.findAll();
    }

    @ModelAttribute("listService")
    public List<ServiceEntity> listService() {
        return serviceEntityService.findAll();
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Contract> listContract = contractService.findAll();
        model.addAttribute("listContract", listContract);
        return "contract/list";
    }

    @GetMapping("/create")
    public String goToCreate(Model model) {
        model.addAttribute("contract", new Contract());
        model.addAttribute("listContract", contractService.findAll());
        return "contract/create";
    }

    @PostMapping("/save")
    public String create(Model model, @Valid @ModelAttribute Contract contract, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        new Contract().validate(contract, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("listContract", contractService.findAll());
            return "contract/create";
        }
        contractService.save(contract);
        redirectAttributes.addFlashAttribute("success", "Saved customer successfully!");
        return "redirect:/contract/list";
    }
}
