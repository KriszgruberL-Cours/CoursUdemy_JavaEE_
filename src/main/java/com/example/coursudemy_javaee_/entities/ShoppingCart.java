package com.example.coursudemy_javaee_.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class ShoppingCart {

    private Set<Work> items = new HashSet<>();
}
