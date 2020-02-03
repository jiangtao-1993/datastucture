package com.example.demo;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class MyAspect {
    @Pointcut("@annotation(AspectAnno)")
    public void pointcut(){

    }

    @Around(value ="pointcut()" )
    public Object aroundAdvice(ProceedingJoinPoint point){
        Object result=null;
        try {
            //获取自定义注解上的value信息
            MethodSignature methodSignature = (MethodSignature) point.getSignature();
            Method method = methodSignature.getMethod();
            AspectAnno annotation = method.getAnnotation(AspectAnno.class);
            String value = annotation.value();
            System.out.println("注解上写的是:"+value);

            result = point.proceed(); //方法执行

            System.out.println("after");

        } catch (Throwable throwable) {
            System.out.println("after throwing");
        }finally{
            System.out.println("outPut finally");
        }
        return result;
    }

}
