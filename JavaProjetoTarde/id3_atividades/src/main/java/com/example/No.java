package com.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Classe que representa o nó de uma árvore de decisão
class No {
    String atributo;
    Map<String, No> filhos;
    String classe;

    // Construtor para nós de decisão
    public No(String atributo) {
        this.atributo = atributo;
        this.filhos = new HashMap<>();
    }

    // Construtor para nós folha (classe terminal)
    public No(String atributo, String classe) {
        this.atributo = atributo;
        this.classe = classe;
    }

    // Função para adicionar um filho à árvore
    public void adicionarFilho(String valor, No no) {
        filhos.put(valor, no);
    }

    // Função para prever a classe de acordo com os sintomas fornecidos
    public String prever(Map<String, String> sintomas) {
        if (classe != null) {
            return classe; // Se for um nó folha, retorna a classe
        }
        String valorSintoma = sintomas.get(atributo);
        No proximoNo = filhos.get(valorSintoma);
        if (proximoNo != null) {
            return proximoNo.prever(sintomas);
        }
        return "Indeterminado"; // Caso não seja possível prever
    }
}
