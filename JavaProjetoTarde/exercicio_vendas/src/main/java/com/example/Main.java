package com.example;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Vendas vendas = new Vendas();
String operacao;
do {
    operacao = JOptionPane.showInputDialog(
        "---Gerenciamento de Vendas---\n"
        +"1 - Cadastrar Vendas\n"
        +"2 - Listar Vendas por CPF\n"
        +"3 - Listar Vendas por CPF e Valor Mínimo\n"
        +"4 - Sair"
    );

    switch (operacao) {
        case "1":
            String cpfVenda = JOptionPane.showInputDialog("Informe o CPF do Cliente");
            String nomeProduto = JOptionPane.showInputDialog("Informe o nome do Produto");

            double precoProduto = Double.parseDouble(JOptionPane.showInputDialog("Informe o Valor do Produto"));

            Produtos produtos = new Produtos(nomeProduto, precoProduto);
    vendas.cadastroVenda(cpfVenda, produtos);
    JOptionPane.showMessageDialog(null, produtos, nomeProduto, 0);
            break;
    
        default:
            break;
    }
} while (operacao!="4");
    }
}