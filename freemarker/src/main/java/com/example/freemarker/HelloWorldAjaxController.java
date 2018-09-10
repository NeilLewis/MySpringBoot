package com.example.freemarker;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ajax")
public class HelloWorldAjaxController {

    @RequestMapping("/say")
    public String say(){
        return "{'message1':'springboot1','message2':'springboot2'}";
    }
}
