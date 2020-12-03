package com.codegym.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

import java.util.Arrays;


@Aspect
public class Logger {

    @AfterThrowing(pointcut = "execution(public * com.codegym.service.BookService.*(..))",
            throwing = "e")
      public void logError(JoinPoint joinPoint, Exception e) {
        String className = joinPoint.getClass().getSimpleName();
//        String className = String.valueOf(joinPoint.getTarget().getClass());
        String returnType = joinPoint.getSignature().getDeclaringType().getName();
        String methodName = joinPoint.getSignature().getName();
        String argsName = Arrays.toString(joinPoint.getArgs());
        System.err.printf("Warning :)): %s.%s.%s.%s: %s", className,
                returnType,
                methodName,
                argsName,
                e.getMessage());
    }
}
