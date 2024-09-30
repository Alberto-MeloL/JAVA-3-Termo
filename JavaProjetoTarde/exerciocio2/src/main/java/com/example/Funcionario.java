package com.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Funcionario {

    // atributos
    // encapsulamento
    private String nome;
    private int idade;
    private double salario;

    // método
    @Override
    public String toString() {
        return "Nome " + nome + " Idade" + idade + " Salário " + salario;
    }

    // e para converter em String

    // construtor (instancia o objeto)
}

//