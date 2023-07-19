package com.example.coursudemy_javaee_.entities;

import lombok.*;

@Getter @Setter @Builder @AllArgsConstructor @NoArgsConstructor
public class Person {

    private String lastname;
    private String firstname;

    public String getFullName(){
        return firstname+" "+lastname;
    }
}
