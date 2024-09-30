package com.example;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello world!");

        FuncionarioController gerencia = new FuncionarioController();
        int operacao = 0;

        try {
            do {

                operacao = Integer.parseInt(JOptionPane.showInputDialog("\n"
                        + "---Gerenciamento de Funcionário--- \n"
                        + "1 - Cadastrar Funcionário \n"
                        + "2 - Listar Funcionário \n"
                        + "3 - Remover Funcionário \n"
                        + "4 - Calcular Média Salárial \n"
                        + "5 - Sair \n"));

            } while (operacao != 5);

        } catch (Exception e) {
            System.err.println(e);
            operacao = 0;
        }
        switch (operacao) {
            case 1:
                String nome = JOptionPane.showInputDialog("Digite o nome: ");
                int idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade: "));
                double salario = Double.parseDouble(JOptionPane.showInputDialog("Digite o salário: "));

                gerencia.addFuncionario(new Funcionario(nome, idade, salario));
                break;

            case 2:
                gerencia.listarFuncionario();
                break;

            case 3:

                String removerNome = JOptionPane.showInputDialog("Digite o nome: ");
                gerencia.removerFuncionario(removerNome);
                break;
            case 4:
                gerencia.mediaSalarial();
                break;

            case 5:
                System.out.println("Saindo...");
            default:
                System.out.println("Digite uma opção válida.");
                break;
        }
    }
}