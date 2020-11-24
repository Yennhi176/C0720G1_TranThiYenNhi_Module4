package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.CaculatorService;

@Controller
public class CaculatorController {

    @Qualifier("caculatorServiceImpl")
    @Autowired
    private CaculatorService caculatorService;

    @GetMapping({"/", "/caculator"})
    public String caculator(@RequestParam double number1, @RequestParam double number2, Model model, @RequestParam String caculation) {
        double result = caculatorService.caculator(number1,number2,caculation);
        model.addAttribute("result", result);
        return "result";
    }
}
