package com.example.freemarker;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/freemarker")
public class HelloWorldFreemarkerController {

    @RequestMapping("/say")
    public ModelAndView say(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message","springboot你好");
        modelAndView.setViewName("helloWorld");

        return modelAndView;
    }
}
