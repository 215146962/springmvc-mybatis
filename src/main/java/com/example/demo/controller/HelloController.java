package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //���ע��
public class HelloController {
    
    @RequestMapping("/helloworld")
    public String say(){
        System.out.println("HelloWorld!");
        return "hello";
    }

}