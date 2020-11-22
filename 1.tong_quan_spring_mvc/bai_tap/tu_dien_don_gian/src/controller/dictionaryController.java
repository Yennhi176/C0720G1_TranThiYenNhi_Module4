package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class dictionaryController {
    Map<String, String> stringMap = new HashMap<>();

    public String search(String english) {
        stringMap.put("red", "đỏ");
        stringMap.put("green", "xanh lá cây");
        stringMap.put("yellow", "vàng");
        stringMap.put("black", "đen");
        return stringMap.get(english);
    }

    @GetMapping({"/dictionary"})
    public String dictionary(@RequestParam String english, Model model) {
        String result = search(english);
        model.addAttribute("result", result);
        return "search";
    }
}
