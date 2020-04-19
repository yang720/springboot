package com.springbootDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ASUS
 */

@Controller
public class HelloController {

    @RequestMapping("/hello")
    @ResponseBody
    public String helloWorld() {
        return "hello world!";
    }
}
