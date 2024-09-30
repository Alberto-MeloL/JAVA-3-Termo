package com.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
// classe objeto construtor
public class Funcionario {
    public String nome;
    public int idade;
    public double salario;

    @Override
    public String toString() {
        return "Nome " + nome + " Idade " + idade + " Salário " + salario;
    }
}
