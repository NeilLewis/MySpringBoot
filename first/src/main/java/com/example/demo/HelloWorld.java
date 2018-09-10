package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HelloWorld {
    @Value("${helloWorld}")
    private String helloWorld;

    @Value("${mysql.jdbcName}")
    private String jdbcName;

    @RequestMapping("/hello")
    public String hello() {
        return "Spring Boot　" + helloWorld + "  " + jdbcName;
    }

    @Resource
    private MysqlProperites mysqlProperites;

    @RequestMapping("/getMysql")
    public String getMysql() {
        return mysqlProperites.getJdbcName() + "<br>"
                + mysqlProperites.getDbUrl() + "<br>"
                + mysqlProperites.getPassword() + "<br>"
                + mysqlProperites.getUserName();
    }
}
