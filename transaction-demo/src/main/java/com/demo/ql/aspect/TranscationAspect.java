package com.demo.ql.aspect;

import com.demo.ql.service.TranscationService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Aspect
@Component
public class TranscationAspect {

    @Pointcut("@annotation(com.demo.ql.annotation.Log)")
    public void log() {}

    @Resource
    private TranscationService transcationService;

    @Around("log()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        transcationService.insertT();
        Object proceed = point.proceed();
        return proceed;
    }
}
