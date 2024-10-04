package com.example.View;

import javax.swing.*;
import com.example.Controller.TarefaController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TarefaView extends JFrame {
    private TarefaController tarefaController;
    private JTextField tituloField;
    private JButton adicionarButton;
    private JList<String> listaTarefas;
    private DefaultListModel<String> listModel;
    private JTextField concluirCancelarField;
    private JButton concluirButton;
    private JButton cancelarButton;

    public TarefaView(TarefaController tarefaController) {
        this.tarefaController = tarefaController;
        initialize();
    }

    private void initialize() {
        // Criação da janela
        setTitle("Gerenciar Tarefas");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(1, 2));

        // Painel esquerdo para lista de tarefas
        JPanel panelEsquerdo = new JPanel();
        panelEsquerdo.setLayout(new BorderLayout());

        listModel = new DefaultListModel<>();
        listaTarefas = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(listaTarefas);
        panelEsquerdo.add(scrollPane, BorderLayout.CENTER);

        // Campo e botão para concluir tarefa
        concluirCancelarField = new JTextField();
        concluirButton = new JButton("Concluir Tarefa");
        cancelarButton = new JButton("Cancelar Tarefa");

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String titulo = concluirCancelarField.getText();
                if (!titulo.isEmpty()) {
                    tarefaController.deletarTarefa(titulo);
                    JOptionPane.showInputDialog(TarefaView.this, "Tarefa deletada com sucesso.");
                    concluirCancelarField.setText("");
                }else{
                    JOptionPane.showMessageDialog(TarefaView.this, "O título não pode ser vazio.");  
                }
            }
        });
        concluirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String titulo = concluirCancelarField.getText();
                if (!titulo.isEmpty()) {
                    tarefaController.concluirTarefa(titulo);
                    JOptionPane.showMessageDialog(TarefaView.this, "Tarefa marcada como concluída.");
                    concluirCancelarField.setText("");
                } else {
                    JOptionPane.showMessageDialog(TarefaView.this, "O título não pode ser vazio.");
                }
            }
        });

        JPanel concluirPanel = new JPanel();
        concluirPanel.setLayout(new BorderLayout());
        concluirPanel.add(concluirCancelarField, BorderLayout.CENTER);
        concluirPanel.add(concluirButton, BorderLayout.EAST);
        concluirPanel.add(cancelarButton, BorderLayout.WEST);
        panelEsquerdo.add(concluirPanel, BorderLayout.SOUTH);

        // Painel direito para adicionar tarefas
        JPanel panelDireito = new JPanel();
        panelDireito.setLayout(new BorderLayout());

        tituloField = new JTextField();
        adicionarButton = new JButton("Adicionar Tarefa");
        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String titulo = tituloField.getText();
                if (!titulo.isEmpty()) {
                    tarefaController.criarTarefa(titulo);
                    listModel.addElement(titulo);
                    tituloField.setText("");
                } else {
                    JOptionPane.showMessageDialog(TarefaView.this, "O título não pode ser vazio.");
                }
            }
        });

        JPanel adicionarPanel = new JPanel();
        adicionarPanel.setLayout(new BorderLayout());
        adicionarPanel.add(tituloField, BorderLayout.CENTER);
        adicionarPanel.add(adicionarButton, BorderLayout.EAST);
        panelDireito.add(adicionarPanel, BorderLayout.NORTH);

        // Adiciona os painéis à janela
        add(panelEsquerdo);
        add(panelDireito);
        
        setVisible(true);
    }
}
