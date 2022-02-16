package com.ap.BasicProject.controller;

import com.ap.BasicProject.configuration.PropertiesConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class BasicController {

    @Value("${default.mymsg}")
    private String myMsg;

    @Autowired
    PropertiesConfiguration propertiesConfiguration;

    @Autowired
    MessageSource messageSource;

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

    @GetMapping("/hello-i8n")
    public String helloWorldInternalization(@RequestHeader(name = "Accept-Language", required = false) Locale locale){
        return messageSource.getMessage("welcome.msg", null, "Default msg", locale);
    }

    @GetMapping("/hello-i8n-2")
    public String helloWorldInternalization2(){
        return messageSource.getMessage("welcome.msg", null, "Default msg", LocaleContextHolder.getLocale());
    }
}
