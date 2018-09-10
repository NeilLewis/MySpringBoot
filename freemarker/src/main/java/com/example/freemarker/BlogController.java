package com.example.freemarker;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @RequestMapping("/{id}")
    public ModelAndView show(@PathVariable("id") int id){
        ModelAndView modelAndView =  new ModelAndView();
        modelAndView.addObject("id",id);
        modelAndView.setViewName("blog");
        return modelAndView;
    }

    @RequestMapping("/query")
    public ModelAndView query(@RequestParam(value = "q",required = false) String q){
        ModelAndView modelAndView =  new ModelAndView();
        modelAndView.addObject("q",q);
        modelAndView.setViewName("query");
        return modelAndView;
    }
}
