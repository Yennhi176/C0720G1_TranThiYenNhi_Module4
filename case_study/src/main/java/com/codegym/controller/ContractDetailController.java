package com.codegym.controller;

import com.codegym.entity.contract.AttachService;
import com.codegym.entity.contract.Contract;
import com.codegym.entity.contract.ContractDetail;
import com.codegym.entity.service_entity.ServiceEntity;
import com.codegym.repository.contract.ContractRepository;
import com.codegym.service.contract.AttachServiceService;
import com.codegym.service.contract.ContractDetailService;
import com.codegym.service.contract.ContractService;
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
@RequestMapping("/contract_detail")
public class ContractDetailController {
    @Autowired
    private ContractDetailService contractDetailService;
    @Autowired
    private AttachServiceService attachServiceService;
    @Autowired
    private ContractService contractService;

    @ModelAttribute("listAttachService")
    public List<AttachService> listAttachService() {
        return attachServiceService.findAll();
    }
    @ModelAttribute("listContract")
    public List<Contract> listContract() {
        return contractService.findAll();
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<ContractDetail> listContractDetail = contractDetailService.findAll();
        model.addAttribute("listContractDetail", listContractDetail);
        return "contract_detail/list";
    }

    @GetMapping("/create")
    public String goToCreate(Model model) {
        model.addAttribute("contractDetail", new ContractDetail());
        model.addAttribute("listContractDetail", contractDetailService.findAll());
        return "contract_detail/create";
    }

    @PostMapping("/save")
    public String create(Model model, @Valid @ModelAttribute ContractDetail contractDetail, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("listContractDetail", contractDetailService.findAll());
            return "contract_detail/create";
        }
        contractDetailService.save(contractDetail);
        redirectAttributes.addFlashAttribute("success", "Saved customer successfully!");
        return "redirect:/contract_detail/list";
    }
}
