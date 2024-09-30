package com.example;

public class Livro extends Produto implements Transportavel{

    @Override
    public double calcularFrete() {
return 2;

    }

    @Override
    public double calcularPeso() {
        return 0.5;
    }
    
}

// um array em jav o tamanho a é fixo

