package com.example.coursudemy_javaee_.entities;

import lombok.*;

import java.util.HashSet;


public class Catalogue {

    public static HashSet<Work> listOfWork = new HashSet<Work>();

    public static HashSet<Work> getListOfWork() {
        return listOfWork;
    }

    public static void setListOfWork(HashSet<Work> listOfWork) {
        Catalogue.listOfWork = listOfWork;
    }
}
