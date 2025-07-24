package com.springboot21.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OtherController {
    @RequestMapping("/other-page")
    public String otherPage(){
        return "other-page.html";
    }
}
