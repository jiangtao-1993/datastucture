package com.example.demo;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/a")
public class AspectUseDemo {

    @RequestMapping("/b")
    @AspectAnno("remember something")
    @ResponseBody
    public String testMethod1(){
        System.out.println("方法一执行了");
        return "切面测试";
    }



}
