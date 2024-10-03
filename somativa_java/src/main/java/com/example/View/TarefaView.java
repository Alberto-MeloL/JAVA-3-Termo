package com.example.View;

import javax.swing.*;
import com.example.Controller.TarefaController;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class TarefaView extends JFrame {
    private TarefaController tarefaController;
    private JTextField tituloField;
    private JButton adicionarButton;
    private JList<String> listaTarefas;
    private DefaultListModel<String> listModel;
    private JTextField concluirField;
    private JButton concluirButton;

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
        concluirField = new JTextField();
        concluirButton = new JButton("Concluir Tarefa");
        concluirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String titulo = concluirField.getText();
                if (!titulo.isEmpty()) {
                    tarefaController.concluirTarefa(titulo);
                    JOptionPane.showMessageDialog(TarefaView.this, "Tarefa marcada como concluída.");
                    concluirField.setText("");
                } else {
                    JOptionPane.showMessageDialog(TarefaView.this, "O título não pode ser vazio.");
                }
            }
        });

        JPanel concluirPanel = new JPanel();
        concluirPanel.setLayout(new BorderLayout());
        concluirPanel.add(concluirField, BorderLayout.CENTER);
        concluirPanel.add(concluirButton, BorderLayout.EAST);
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
                    tarefaController.criarTarefa(titulo, "Descrição", LocalDate.now(), "Baixa", "Pendente");
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
