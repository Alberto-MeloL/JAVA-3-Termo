package com.example;

import java.util.List;
import java.util.ArrayList;

public class FuncionarioController {
    // atributos
    private List<Funcionario> funcionario;

    // list é interface não deixa instanciar nada
    public FuncionarioController() {
        funcionario = new ArrayList<>();
    }

    // métodos

    // adicionar funcionario
    // vai aceitar um objeto de Funcionario como parametro
    public void addFuncionario(Funcionario funcionario) {
        this.funcionario.add(funcionario);
    }

    // listar
    // como não temos um tamanho específico para a listar é melhor usar o foreach

    public void listarFuncionario() {

        if (this.funcionario.size() == 0) {
            System.out.println("Lista vazia");
        }
        for (Funcionario f : funcionario) {
            System.out.println(f.toString());
        }
    }

    // remover
    public void removerFuncionario(String nome) throws Exception {

        try {

            boolean encontrado = false;
            for (Funcionario f : funcionario) {
                if (f.getNome().equalsIgnoreCase(nome)) {
                    this.funcionario.remove(f);
                    encontrado = true;
                }
            }

            if (!encontrado) {
                throw new Exception("Erro");
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    // média salarial
    // retorno do tipo double
    public double mediaSalarial(){
        double media = 0;

        if (this.funcionario.size() == 0) {
            return media;
        }else{
            for (Funcionario f : funcionario) {
                media += f.getSalario();
            }
            return media / this.funcionario.size();
        }
    }
}
