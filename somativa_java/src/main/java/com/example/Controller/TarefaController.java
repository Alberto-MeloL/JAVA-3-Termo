package com.example.Controller;

import java.sql.Connection;
import java.time.LocalDate;

import com.example.Connection.ConnectionFactory;
import com.example.Connection.TarefaDAO;
// import com.example.Model.Tarefa;

public class TarefaController {

    private TarefaDAO tarefaDAO;
    Connection connection;

    // exploique me esse trecho
    public TarefaController() {
        this.connection = ConnectionFactory.getConnection();
        this.tarefaDAO = new TarefaDAO(connection);
    }

    // método para criar tarefa
    public void criarTarefa(String titulo, String descricao, LocalDate dataVencimento, String prioridade,
            String status) {
        tarefaDAO.criarTarefa(titulo, descricao, dataVencimento, prioridade, status);
    }

    // método para listar tarefa
    public void listarTarefas() {
        tarefaDAO.listarTarefas();
    }

    // método para editar tarefa
    public void editarTarefa(String buscarTarefa, String titulo, String descricao, LocalDate dataVencimento,
            String prioridade) {
        tarefaDAO.editarTarefa(buscarTarefa, titulo, descricao, dataVencimento, prioridade);
    }

    // método para deletar tarefa
    public void deletarTarefa(String buscarTarefa) {
        tarefaDAO.deletarTarefa(buscarTarefa);
    }

    // método para marcar como concluída
    public void concluirTarefa(String buscarTarefa) {
        tarefaDAO.concluirTarefa(buscarTarefa);
    }

    public void closeConnection() {

        ConnectionFactory.closeConnection(connection);
    }

}