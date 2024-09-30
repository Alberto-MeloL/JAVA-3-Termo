package com.example;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        AgendaTelefonica agenda = new AgendaTelefonica(5);
        int operador = 0;

        try {
            do {
                System.out.println("\n___Agenda Telefonica___");
                System.out.println("1- Adicionar contato");
                System.out.println("2- Listar contato");
                System.out.println("3- Buscar contato (nome)");
                System.out.println("4- Remover contato (nome)");
                System.out.println("5- Sair");

                operador = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma opção:"));

                switch (operador) {
                    case 1:
                        String nome = JOptionPane.showInputDialog("Digite o nome do contato:");
                        String telefone = JOptionPane.showInputDialog("Digite o telefone do contato:");
                        Contato contato = new Contato(nome, telefone);
                        agenda.adicionarContato(contato);
                        break;
                    case 2:
                        agenda.listarContatos();
                        break;
                    case 3:
                        String nomeContato = JOptionPane.showInputDialog("Informe o nome:");
                        System.out.println(agenda.buscarContato(nomeContato).toString());
                        break;
                    case 4:
String nomeRemover = JOptionPane.showInputDialog("Digite o nome a ser removido:");
agenda.removerConta(nomeRemover);
                    break;
                    case 5:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } while (operador != 5);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
