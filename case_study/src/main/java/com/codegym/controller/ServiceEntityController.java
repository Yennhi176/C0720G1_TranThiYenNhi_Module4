package com.codegym.controller;

import com.codegym.entity.service_entity.RentType;
import com.codegym.entity.service_entity.ServiceEntity;
import com.codegym.entity.service_entity.ServiceType;
import com.codegym.service.service_entity.RentTypeService;
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
@RequestMapping("/service")
public class ServiceEntityController {
    @Autowired
    private ServiceEntityService serviceEntityService;
    @Autowired
    private ServiceTypeService serviceTypeService;
    @Autowired
    private RentTypeService rentTypeService;

    @ModelAttribute("listServiceType")
    public List<ServiceType> listServiceType() {
        return serviceTypeService.findAll();
    }

    @ModelAttribute("listRentType")
    public List<RentType> listRentType() {
        return rentTypeService.findAll();
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<ServiceEntity> listServiceEntity = serviceEntityService.findAll();
        model.addAttribute("listServiceEntity", listServiceEntity);
        return "service/list";
    }

    @GetMapping("/create")
    public String goToCreate(Model model) {
        model.addAttribute("serviceEntity", new ServiceEntity());
        model.addAttribute("listServiceEntity",serviceEntityService.findAll());
        return "service/create";
    }

    @PostMapping("/save")
    public String create(Model model, @Valid @ModelAttribute ServiceEntity serviceEntity, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if(bindingResult.hasErrors()){
            model.addAttribute("listServiceEntity",serviceEntityService.findAll());
            return "service/create";
        }
        serviceEntityService.save(serviceEntity);
        redirectAttributes.addFlashAttribute("success", "Saved customer successfully!");
        return "redirect:/service/list";
    }

}
