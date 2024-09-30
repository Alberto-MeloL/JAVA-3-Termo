package com.example;

public class DiagnosticoSaudeID3 {

    // Função para construir a árvore de decisão
    public static No construirArvore() {
        // Criação da árvore de decisão com base em sintomas
        No raiz = new No("Febre");

        // Nó com valor "Sim" para o sintoma Febre
        No febreSim = new No("Tosse");
        febreSim.adicionarFilho("Sim", new No("Tosse", "Gripe"));
        febreSim.adicionarFilho("Não", new No("Tosse", "Resfriado"));
        
        // Nó com valor "Não" para o sintoma Febre
        No febreNao = new No("Dor de Garganta");
        febreNao.adicionarFilho("Sim", new No("Dor de Garganta", "Resfriado"));
        febreNao.adicionarFilho("Não", new No("Dor de Garganta", "Nenhuma"));

        // Adiciona os nós filhos à raiz
        raiz.adicionarFilho("Sim", febreSim);
        raiz.adicionarFilho("Não", febreNao);

        return raiz;
    }
}