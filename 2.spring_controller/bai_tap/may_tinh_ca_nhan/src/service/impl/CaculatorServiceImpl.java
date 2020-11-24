package service.impl;

import org.springframework.stereotype.Service;
import service.CaculatorService;
@Service
public class CaculatorServiceImpl implements CaculatorService {
    @Override
    public double sum(double num1, double num2) {
        return num1 + num2;
    }

    @Override
    public double sub(double num1, double num2) {
        return num1 - num2;
    }

    @Override
    public double mul(double num1, double num2) {
        return num1 * num2;
    }

    @Override
    public double div(double num1, double num2) {
        return num1 / num2;
    }
}
