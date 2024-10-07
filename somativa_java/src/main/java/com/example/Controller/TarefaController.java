package com.example.Controller;

import java.sql.Connection;

import java.util.List;

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
    public boolean criarTarefa(String titulo) {
        return tarefaDAO.criarTarefa(titulo);
    }

    // método para listar tarefa
    public List<String> obterTarefas() {
        return tarefaDAO.listarTarefas();
    }

    // método para listar tarefas em status final
    public List<String> obterTarefasStatusFinal() {
        return tarefaDAO.listarTarefasStatusFinal();
    }

    // método para editar tarefa
    public boolean editarTarefa(String buscarTarefa, String titulo) {
        return tarefaDAO.editarTarefa(buscarTarefa, titulo);
    }

    // método para deletar tarefa
    public boolean deletarTarefa(String buscarTarefa) {
        return tarefaDAO.deletarTarefa(buscarTarefa);
    }

    // método para marcar como concluída
    public boolean concluirTarefa(String buscarTarefa) {
        return tarefaDAO.concluirTarefa(buscarTarefa);
    }

    // método para limpar o histórico
    public void limparHistorico(){
        tarefaDAO.limparHistorico();
    }

    public void closeConnection() {

        ConnectionFactory.closeConnection(connection);
    }

}
