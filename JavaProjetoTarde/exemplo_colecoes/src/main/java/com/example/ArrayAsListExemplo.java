package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayAsListExemplo {
    private String[] nomes = { "Maria", "Alberto", "Isabel" };
    private List<String> nomesList;

    public ArrayAsListExemplo() {
        nomesList = new ArrayList<>(Arrays.asList(nomes));

    }

    public void addNome(String nome){
       nomesList.add(nome);
    }

    public void listar(){
        System.out.println(nomesList);
    }
}
