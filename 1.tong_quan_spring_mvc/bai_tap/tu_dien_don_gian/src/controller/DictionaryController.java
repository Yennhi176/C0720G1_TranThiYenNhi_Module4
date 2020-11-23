package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.DictionaryService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DictionaryController {
    @Qualifier("dictionaryServiceImpl")
    @Autowired
    private DictionaryService dictionaryService;

    @GetMapping({"/dictionary"})
    public String dictionary(@RequestParam String english, Model model) {
        String result = dictionaryService.search(english);
        model.addAttribute("result", result);
        return "search";
    }
}
