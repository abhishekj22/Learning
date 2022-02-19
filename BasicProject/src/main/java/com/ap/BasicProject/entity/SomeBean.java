package com.ap.BasicProject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SomeBean {
    private String firstField;
    private String secondField;

    @JsonIgnore
    private String thirdField;
}
