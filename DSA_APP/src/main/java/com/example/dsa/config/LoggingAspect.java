package com.example.dsa.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("within(@org.springframework.web.bind.annotation.RestController *)")
    public void logControllerRequest(JoinPoint joinPoint) {
        logger.info("[REQUEST] {}.{}({})", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
    }

    @Around("within(@org.springframework.stereotype.Service *)")
    public Object logServiceMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("[SERVICE] Entering {}.{}({})", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
        try {
            Object result = joinPoint.proceed();
            logger.info("[SERVICE] Exiting {}.{} with result: {}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), result);
            return result;
        } catch (Throwable ex) {
            logger.error("[SERVICE] Exception in {}.{}: {}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), ex.getMessage(), ex);
            throw ex;
        }
    }

    @AfterThrowing(pointcut = "within(@org.springframework.web.bind.annotation.RestController *)", throwing = "ex")
    public void logControllerException(JoinPoint joinPoint, Throwable ex) {
        logger.error("[EXCEPTION] in {}.{}: {}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), ex.getMessage(), ex);
    }
}
