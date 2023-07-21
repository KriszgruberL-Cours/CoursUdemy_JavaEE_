package com.example.coursudemy_javaee_.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class SommeEtProduit {

    private Somme somme;
    private Produit produit;
}
