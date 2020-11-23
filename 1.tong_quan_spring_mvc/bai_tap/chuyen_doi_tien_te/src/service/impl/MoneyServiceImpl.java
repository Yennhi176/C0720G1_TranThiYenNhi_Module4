package service.impl;

import org.springframework.stereotype.Service;
import service.MoneyService;

@Service
public class MoneyServiceImpl implements MoneyService {
    @Override
    public double change(double number) {
        return number * 23000;
    }
}
