package com.example;

import java.util.HashSet;
import java.util.Set;

public class SetExemplo {
    private Set<String> nomes;

    public SetExemplo() {
        nomes = new HashSet<>();
    }

    // hashCode o que e
    public void addNome(String nome) {
        nomes.add(nome);
        System.out.println(nomes.hashCode());
    }

    public void listarNomes() {
        System.out.println(nomes);
    }

    public void removerNomes(String nome) {
        // try_catch pois vai buscar esse nome, caso não encontre, trata o erro e não
        // trava o programa
        try {

            nomes.remove(nome);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    // não existe modificar em uma lista não ordenada

}
// bolsa de valor acoes