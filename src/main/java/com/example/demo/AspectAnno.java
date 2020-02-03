package com.example.demo;



import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AspectAnno {
    String value() default "";// 记录用户做了什么
}
