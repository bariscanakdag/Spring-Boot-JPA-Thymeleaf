package com.baris.springboot.thymeleafdemo.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller

public class Controller {

    @GetMapping("/hello")
    public String getHello(Model theModel) {
        theModel.addAttribute("theDate", new java.util.Date());

        return "helloworld";
    }
}
