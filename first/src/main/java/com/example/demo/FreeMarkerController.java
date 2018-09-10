package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class FreeMarkerController {

    @RequestMapping("/freemarker")
    public ModelAndView say(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message","你好啊");
        modelAndView.setViewName("helloWorld");

        return modelAndView;
    }

}
