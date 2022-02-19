package com.ap.BasicProject.controller;

import com.ap.BasicProject.entity.SomeBean;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilterController {

    @GetMapping("/normal-filter")
    public SomeBean getNormalSomeBean(){
        return new SomeBean("value1", "value2", "value3");
    }

    @GetMapping("/normal-filters")
    public List<SomeBean> getNormalListSomeBean(){
        return Arrays.asList(new SomeBean("value10", "value20", "value30"),
                new SomeBean("value11", "value21", "value31"));
    }
}
