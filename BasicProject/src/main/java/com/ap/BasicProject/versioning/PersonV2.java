package com.ap.BasicProject.versioning;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonV2 {
    private Name name;

    PersonV2(String fname, String lname){
        this.name = new Name(fname, lname);
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Name {
        private String firstName;
        private String lastName;
    }
}
