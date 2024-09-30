package com.example;

import java.util.HashMap;
import java.util.Map;

public class MapExemplo {
    private Map<String, Integer> nomesIdades;


    public MapExemplo() {
nomesIdades = new HashMap<>();
    }

    public void addNomeIdade(String nome, int idade){
        nomesIdades.put(nome, idade);
        System.out.println(nomesIdades.get(nome));
    }
}
