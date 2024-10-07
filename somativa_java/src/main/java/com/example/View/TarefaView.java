package com.example.View;

import javax.swing.*;
import com.example.Controller.TarefaController;

import java.awt.*;

public class TarefaView extends JFrame {
    private TarefaController tarefaController;
    private JTextField concluirCancelarField;
    private JTextField tituloField;
    private DefaultListModel<String> listModel;
    private DefaultListModel<String> listModelStatusFinal;
    private JList<String> listaTarefasStatusFinal;
    private JList<String> listaTarefas;
    private JButton adicionarButton;
    private JButton editarButton;
    private JButton concluirButton;
    private JButton cancelarButton;
    private JButton limparHistoricoButton;

    public TarefaView(TarefaController tarefaController) {
        this.tarefaController = tarefaController;
        initialize();
        listarTarefas(); // Carregar as tarefas existentes na inicialização
        listarTarefasStatusFinal();
    }

    private void listarTarefas() {
        listModel.clear(); // Limpa a lista antes de adicionar
        for (String tarefa : tarefaController.obterTarefas()) {
            listModel.addElement(tarefa); // Adiciona cada tarefa ao modelo da lista
        }
    }

    private void listarTarefasStatusFinal() {
        listModelStatusFinal.clear();
        for (String tarefa : tarefaController.obterTarefasStatusFinal()) {
            listModelStatusFinal.addElement(tarefa);
        }
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
        listModelStatusFinal = new DefaultListModel<>();
        listaTarefas = new JList<>(listModel);
        listaTarefasStatusFinal = new JList<>(listModelStatusFinal);
        JScrollPane scrollPane = new JScrollPane(listaTarefas);
        JScrollPane scrollPaneStatusFinal = new JScrollPane(listaTarefasStatusFinal);
        panelEsquerdo.add(scrollPane, BorderLayout.CENTER);

        // Campo e botão para concluir tarefa
        concluirCancelarField = new JTextField();
        concluirButton = new JButton("Concluir Tarefa");
        cancelarButton = new JButton("Cancelar Tarefa");
        editarButton = new JButton("Editar Tarefa");
        limparHistoricoButton = new JButton("Limpar Histórico");

        cancelarButton.addActionListener(e -> {
            String titulo = concluirCancelarField.getText().trim();
            System.out.println(titulo);
            if (!titulo.isEmpty()) {
                boolean deletarTarefa = tarefaController.deletarTarefa(titulo);
                if (deletarTarefa) {
                    JOptionPane.showMessageDialog(TarefaView.this, "Tarefa deletada com sucesso.");
                    // Atualiza as listas
                    listarTarefas();
                    listarTarefasStatusFinal();
                    concluirCancelarField.setText("");
                } else {
                    JOptionPane.showMessageDialog(TarefaView.this, "Essa tarefa já foi cancelada ou ela não existe.");
                    concluirCancelarField.setText("");
                }
            } else {
                JOptionPane.showMessageDialog(TarefaView.this, "O título não pode ser vazio.");
            }
        });

        concluirButton.addActionListener(e -> {
            String titulo = concluirCancelarField.getText();
            if (!titulo.isEmpty()) {
                boolean concluirTarefa = tarefaController.concluirTarefa(titulo);
                if (concluirTarefa) {
                    JOptionPane.showMessageDialog(TarefaView.this, "Tarefa marcada como concluída.");
                    listarTarefas(); // Atualiza a lista
                    listarTarefasStatusFinal(); // Atualiza a lista de tarefas concluídas
                    concluirCancelarField.setText("");
                } else {
                    JOptionPane.showMessageDialog(TarefaView.this, "Essa tarefa não existe ou já foi concluída.");
                    concluirCancelarField.setText("");
                }
            } else {
                JOptionPane.showMessageDialog(TarefaView.this, "O título não pode ser vazio.");
            }
        });

        editarButton.addActionListener(e -> {
            String buscarTarefa = JOptionPane.showInputDialog(TarefaView.this, "Título da tarefa a buscar:");
            if (buscarTarefa != null && !buscarTarefa.trim().isEmpty()) {
                String tituloNovo = JOptionPane.showInputDialog(TarefaView.this, "Novo título:");
                if (tituloNovo != null && !tituloNovo.trim().isEmpty()) {
                    boolean tarefaEditada = tarefaController.editarTarefa(buscarTarefa.trim(), tituloNovo.trim());
                    if (tarefaEditada) {
                        JOptionPane.showMessageDialog(TarefaView.this, "Tarefa editada com sucesso.", 
                                                      "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                        listarTarefas(); // Atualiza a lista
                    } else {
                        JOptionPane.showMessageDialog(TarefaView.this, "Nenhuma tarefa encontrada com esse título.", 
                                                      "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(TarefaView.this, "O novo título não pode ser vazio.", 
                                                  "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(TarefaView.this, "O título da tarefa a buscar não pode ser vazio.", 
                                              "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });
        limparHistoricoButton.addActionListener(e ->{
            tarefaController.limparHistorico();
            listarTarefasStatusFinal();
        });
        tituloField = new JTextField();
        adicionarButton = new JButton("Adicionar Tarefa");
        JPanel concluirPanel = new JPanel();
        concluirPanel.setLayout(new BorderLayout());
        concluirPanel.add(concluirCancelarField, BorderLayout.CENTER);
        concluirPanel.add(adicionarButton, BorderLayout.PAGE_START);
        concluirPanel.add(concluirButton, BorderLayout.EAST);
        concluirPanel.add(cancelarButton, BorderLayout.WEST);
        concluirPanel.add(editarButton, BorderLayout.SOUTH);
        panelEsquerdo.add(concluirPanel, BorderLayout.SOUTH);

        // Painel direito para adicionar tarefas
        JPanel panelDireito = new JPanel();
        panelDireito.setLayout(new BorderLayout());

        adicionarButton.addActionListener(e -> {
            String titulo = concluirCancelarField.getText().trim();
            if (!titulo.isEmpty()) {
                boolean tarefaCriada = tarefaController.criarTarefa(titulo);
                if (tarefaCriada) {
                    concluirCancelarField.setText(""); // Limpa o campo de entrada
                    listarTarefas();
                    listarTarefasStatusFinal(); // Atualiza a lista de tarefas concluídas
                } else {
                    JOptionPane.showMessageDialog(TarefaView.this, "A tarefa com este título já existe.");
                    tituloField.setText("");
                }
            } else {
                JOptionPane.showMessageDialog(TarefaView.this, "O título não pode ser vazio.");
            }
        });

        JPanel adicionarPanel = new JPanel();
        adicionarPanel.setLayout(new BorderLayout());
        adicionarPanel.add(limparHistoricoButton, BorderLayout.SOUTH);
        panelDireito.add(adicionarPanel, BorderLayout.NORTH);
        panelDireito.add(scrollPaneStatusFinal, BorderLayout.CENTER);

        // Adiciona os painéis à janela
        add(panelEsquerdo);
        add(panelDireito);

        setVisible(true);
    }
}
