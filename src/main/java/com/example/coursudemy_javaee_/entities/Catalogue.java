package com.example.coursudemy_javaee_.entities;

import lombok.*;

import java.util.HashSet;

@Getter
@Setter

public class Catalogue {

    public static HashSet<Work> listOfWork = new HashSet<Work>();
}
