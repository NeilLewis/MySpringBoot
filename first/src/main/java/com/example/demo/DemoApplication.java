package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @RequestMapping("/say")
    public String Say(){
        return  "/login";
    }

    @RequestMapping(value = "/ajax", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,String> ajax(@RequestParam("cityName") String city){
        Map<String, String> map=new HashMap<String, String>();
        map.put("city", city);
        return map;
    }

}
