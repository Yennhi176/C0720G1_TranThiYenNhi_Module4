package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class MoneyController {
    @GetMapping({"/change"})
    public String change(@RequestParam String USD,  Model model){
        int usd = Integer.parseInt(USD);
        int result = usd * 23000;
       model.addAttribute("result",result);
       return "change";
    }
}
