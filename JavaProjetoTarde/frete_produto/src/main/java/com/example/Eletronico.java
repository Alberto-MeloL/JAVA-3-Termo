package com.example;

public class Eletronico extends Produto implements Transportavel{
    private double volume;

    public Eletronico(String nome, double preco, double volume) {
        super(nome, preco);
        this.volume = volume;
    }

    // calcular peso
    // bolo da casa da tia
    @Override
    public double calcularPeso() {
        double peso = volume * 150;
        return peso;
    }

    // calcular frete

    @Override
    public double calcularFrete(){
        double valorFrete = calcularPeso() * 1;
        return valorFrete;
    }
}
