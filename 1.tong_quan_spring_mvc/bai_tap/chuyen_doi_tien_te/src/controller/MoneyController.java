package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.MoneyService;

@Controller
public class MoneyController {
    @Qualifier("moneyServiceImpl")
    @Autowired
    private MoneyService moneyService;

    @GetMapping({"/change"})
    public String change(@RequestParam double USD, Model model) {
       double result = moneyService.change(USD);
        model.addAttribute("result", result);
        return "change";
    }
}
