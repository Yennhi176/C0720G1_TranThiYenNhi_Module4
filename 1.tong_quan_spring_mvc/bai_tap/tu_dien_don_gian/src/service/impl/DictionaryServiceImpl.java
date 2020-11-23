package service.impl;

import org.springframework.stereotype.Service;
import service.DictionaryService;

import java.util.HashMap;
import java.util.Map;
@Service
public class DictionaryServiceImpl implements DictionaryService {

    private static Map<String, String> stringMap = new HashMap<>();
    static {
        stringMap.put("red", "đỏ");
        stringMap.put("green", "xanh lá cây");
        stringMap.put("yellow", "vàng");
        stringMap.put("black", "đen");
    }


    @Override
    public String search(String english) {
        return stringMap.get(english);
    }
}
