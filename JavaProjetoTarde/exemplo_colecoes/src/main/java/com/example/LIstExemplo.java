package com.example;

import java.util.ArrayList;
import java.util.List;

public class LIstExemplo {
    private List<String> nomes;

    public LIstExemplo() {
        nomes = new ArrayList<>();
    }

    public void addNome(String nome) {
        nomes.add(nome);
        System.out.println(nomes.lastIndexOf(nome));
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

    // aqui como diferenciar o nome antigo do novo, ao ser enviado
    public void modificarNome(String nomeAntigo, String nomeNovo){
try {
   int index = nomes.indexOf(nomeAntigo);
   if (index != -1) {
    nomes.set(index, nomeNovo);
    System.out.println("Nome alterado.");
   }
} catch (Exception e) {
e.printStackTrace();
}
    }
}
