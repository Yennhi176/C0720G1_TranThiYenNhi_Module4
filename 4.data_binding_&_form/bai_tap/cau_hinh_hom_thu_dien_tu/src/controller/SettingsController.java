package controller;

import model.Settings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class SettingsController {

@GetMapping({"","/index"})
    public String goIndexSettings(Model model){
        model.addAttribute("settingsObj",new Settings());
        return "index";
    }
@PostMapping("/index")
    public String indexSetting(Model model, @ModelAttribute Settings settingsObj){
    model.addAttribute("languages",settingsObj.getLanguages());
    model.addAttribute("pageSize",settingsObj.getPageSize());
    model.addAttribute("spamsFilter",settingsObj.getSpamsFilter());
    model.addAttribute("signature",settingsObj.getSignature());
    return "list";
    }
}
