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
        double result = 0;
        switch (caculation) {
            case "Addition(+)":
                result = caculatorService.sum(number1, number2);
                break;
            case "Subtraction(-)":
                result = caculatorService.sub(number1, number2);
                break;
            case "Multiplication(*)":
                result = caculatorService.mul(number1, number2);
                break;
            case "Division(/)":
                String message = "vui lòng nhập lại number2 khác không";
                if (number2 != 0) {
                    result = caculatorService.div(number1, number2);
                } else {
                    model.addAttribute("message", message);
                    return "result";
                }
                break;
            default:
                break;
        }
        model.addAttribute("result", result);
        return "result";
    }
}
