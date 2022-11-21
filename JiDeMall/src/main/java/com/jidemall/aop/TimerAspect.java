package com.jidemall.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component //将当前类的对象使用及维护交给Spring容器维护
@Aspect //将当前类标记为切面类
public class TimerAspect {
    @Around("execution(* com.jidemall.service.impl.*.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable{
        long start=System.currentTimeMillis();
        Object result = pjp.proceed();
        long end=System.currentTimeMillis();
        System.out.println("耗时:"+(end-start));
        return result;
    }
}
