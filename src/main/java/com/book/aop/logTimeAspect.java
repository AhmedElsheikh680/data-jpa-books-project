package com.book.aop;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(1)
@Component
public class logTimeAspect {

    Logger logger = LoggerFactory.getLogger(logTimeAspect.class);


    @Pointcut(value = "execution(* com.book.repo..*(..))")
    public void forRepositoryLog() {}

    @Pointcut(value = "execution(* com.book.service..*(..))")
    public void forServiceLog() {}

    @Pointcut(value = "execution(* com.book.controller..*(..))")
    public void forControllerLog() {}

    @Pointcut(value = "forRepositoryLog() || forServiceLog() || forControllerLog()")
    public void forAllApp() {}

    @Before(value = "forAllApp()")
    public void beforeMethod(JoinPoint joinPoint){
       String methodName =  joinPoint.getSignature().toShortString();
       logger.info("===> Method Name ==> {} ", methodName);

       Object[] args = joinPoint.getArgs();
       for(Object arg: args){
           logger.info("===> argument => {} ", arg);
       }
    }

























}
