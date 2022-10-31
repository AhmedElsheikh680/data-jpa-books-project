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
@Order(0)
@Component
public class MeaurmentAspect {

    Logger logger = LoggerFactory.getLogger(MeaurmentAspect.class);

    @Around(value="execution(* com.book.service..*(..))")
    public Object logTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        StringBuilder stringBuilder = new StringBuilder("KPI:");
        stringBuilder.append("[").append(proceedingJoinPoint.getKind()).append("]\tfor: ").append(proceedingJoinPoint.getSignature())
                .append("\twithArgs: ").append("(").append(StringUtils.join(proceedingJoinPoint.getArgs(), "")).append(")");
        stringBuilder.append("\ttook: ");
        Object returnValue = proceedingJoinPoint.proceed();

        logger.info(stringBuilder.append(System.currentTimeMillis() - startTime).append(" ms.").toString());
        return returnValue;
    }


    }
