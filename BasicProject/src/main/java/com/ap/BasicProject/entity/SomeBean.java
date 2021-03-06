package com.ap.BasicProject.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@JsonIgnoreProperties(value = {"firstField", "secondField"})
@JsonFilter("someBeanFilter")
public class SomeBean {
    private String firstField;
    private String secondField;

    //@JsonIgnore
    private String thirdField;
}
