package service.impl;

import org.springframework.stereotype.Service;
import service.CaculatorService;
@Service
public class CaculatorServiceImpl implements CaculatorService {

    public double sum(double num1, double num2) {
        return num1 + num2;
    }

    public double sub(double num1, double num2) {
        return num1 - num2;
    }


    public double mul(double num1, double num2) {
        return num1 * num2;
    }

    public double div(double num1, double num2) {
        return num1 / num2;
    }

    public double caculator(double num1, double num2,String caculation) {
        double result = 0;
        switch (caculation) {
            case "Addition(+)":
                result = sum(num1, num2);
                break;
            case "Subtraction(-)":
                result = sub(num1, num2);
                break;
            case "Multiplication(*)":
                result = mul(num1, num2);
                break;
            case "Division(/)":
                result = div(num1, num2);
                break;
            default:
                break;
        }
        return result;
    }
}
