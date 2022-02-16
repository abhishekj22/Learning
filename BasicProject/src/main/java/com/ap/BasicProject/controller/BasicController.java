package com.ap.BasicProject.controller;

import com.ap.BasicProject.configuration.PropertiesConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {

    @Value("${default.mymsg}")
    private String myMsg;

    @Autowired
    PropertiesConfiguration propertiesConfiguration;

    @GetMapping("/hello")
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping("/hello/{name}")
    public String helloWorldWithPath(@PathVariable String name){
        return "Hello " + name;
    }

    @GetMapping("/getMsg")
    public String getMyMsg(){
        return myMsg;
    }

    /* Hierarchical Properties, values fetched from properties file */
    @GetMapping("/getProp")
    public String getPersonDetails(){
        return "Person name is " + propertiesConfiguration.getName() + " and age is " +propertiesConfiguration.getAge();
    }
}
