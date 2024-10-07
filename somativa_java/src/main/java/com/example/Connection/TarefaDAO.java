package com.example.Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import java.util.List;
import java.util.ArrayList;

import com.example.Model.StatusTarefa;

public class TarefaDAO {
    Connection connection;

    public TarefaDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean criarTarefa(String titulo) {
        String checkQuery = "SELECT COUNT(*) FROM tarefa WHERE titulo = ?";
        try (PreparedStatement checkStatement = connection.prepareStatement(checkQuery)) {
            checkStatement.setString(1, titulo);
            ResultSet resultSet = checkStatement.executeQuery();
    
            if (resultSet.next()) {
                if (resultSet.getInt(1) > 0) {
                    System.err.println("Essa tarefa já existe.");
                    return false; // Sai do método caso já exista
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Sai do método em caso de erro
        }
    
        String query = "INSERT INTO tarefa (titulo, status) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, titulo);
            preparedStatement.setObject(2, StatusTarefa.PENDENTE.name(), java.sql.Types.OTHER);
    
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Tarefa criada com sucesso.");
                return true;
            } else {
                System.err.println("Erro ao criar tarefa.");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    

    // método para listar as tarefas
    public List<String> listarTarefas() {
        List<String> tarefas = new ArrayList<>();
        String query = "SELECT * FROM tarefa";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String titulo = resultSet.getString("titulo");
                tarefas.add(titulo); // Adiciona o título à lista
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Erro ao listar tarefas.");
        }
        return tarefas; // Retorna a lista de tarefas
    }

    // método para editar tarefa
    public void editarTarefa(String buscarTarefa, String titulo) {
        String query = "UPDATE tarefa SET titulo WHERE titulo = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query.toString())) {

            if (titulo != null && !titulo.isEmpty())
                preparedStatement.setString(2, titulo);

            preparedStatement.setString(1, buscarTarefa);

            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Tarefa atualizada com sucesso.");
            } else {
                System.out.println("Nenhuma tarefa encontrada com esse titulo.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Erro ao editar tarefa.");
        }
    }

    // método para deletar tarefa
    public void deletarTarefa(String buscarTarefa) {
        String queryDelete = "DELETE FROM tarefa WHERE titulo = ?";
        String queryInsertStatus = "INSERT INTO status_final (nome_tarefa, status) VALUES (?, ?)";

        try {
            // Inicia uma transação
            connection.setAutoCommit(false);

            // Preparar o statement para deletar a tarefa
            try (PreparedStatement preparedStatementDelete = connection.prepareStatement(queryDelete)) {
                if (buscarTarefa != null && !buscarTarefa.isEmpty()) {
                    preparedStatementDelete.setString(1, buscarTarefa);

                    int rowsAffected = preparedStatementDelete.executeUpdate();
                    if (rowsAffected > 0) {
                        System.out.println("Tarefa deletada com sucesso.");

                        // Agora insere o registro na tabela de status final
                        try (PreparedStatement preparedStatementInsert = connection
                                .prepareStatement(queryInsertStatus)) {
                            preparedStatementInsert.setString(1, buscarTarefa);
                            preparedStatementInsert.setObject(2, StatusTarefa.CANCELADO.name(), java.sql.Types.OTHER); // Status,
                                                                                                                       // pode

                            preparedStatementInsert.executeUpdate();
                        }

                        // Confirma a transação
                        connection.commit();
                    } else {
                        System.err.println("Erro ao deletar tarefa.");
                    }
                } else {
                    System.err.println("O título não pode ser vazio ou nulo.");
                }
            } catch (SQLException e) {
                // Reverte a transação em caso de erro
                connection.rollback();
                e.printStackTrace();
                System.err.println("Erro ao deletar tarefa.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                // Restaura o modo de autocommit
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // método status final
    // método para marcar como concluida
    public void concluirTarefa(String buscarTarefa) {
        String query = "UPDATE tarefa SET status = ? WHERE titulo = ?";
        String queryDelete = "DELETE FROM tarefa WHERE titulo = ?";
        String queryInsertStatus = "INSERT INTO status_final (nome_tarefa, status) VALUES (?, ?)";

        try {
            // inicia a transação
            connection.setAutoCommit(false);

            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                if (buscarTarefa != null && !buscarTarefa.isEmpty()) {
                    preparedStatement.setObject(1, StatusTarefa.CONCLUÍDO.name(), java.sql.Types.OTHER);
                    preparedStatement.setString(2, buscarTarefa);
                    int rowsAffected = preparedStatement.executeUpdate(); // o que isso me retorna

                    if (rowsAffected > 0) {
                        System.out.println("Tarefa marcada como concluida.");
                        // Agora insere o registro na tabela de status final
                        try (PreparedStatement preparedStatementInsert = connection
                                .prepareStatement(queryInsertStatus)) {
                            preparedStatementInsert.setString(1, buscarTarefa);
                            preparedStatementInsert.setObject(2, StatusTarefa.CONCLUÍDO.name(), java.sql.Types.OTHER); // Status,

                            int rowInserted = preparedStatementInsert.executeUpdate();

                            if (rowInserted > 0) {
                                try (PreparedStatement preparedStatementDelete = connection
                                        .prepareStatement(queryDelete)) {
                                    preparedStatementDelete.setString(1, buscarTarefa);
                                    preparedStatementDelete.executeUpdate();
                                }
                            }
                        }

                        // Confirma a transação
                        connection.commit();

                    } else {
                        System.err.println("Erro ao marcar tarefa como concluida.");
                    }
                } else {
                    System.err.println("O titulo não pode ser vazio ou nulo.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println("Erro ao marcar tarefa como concluida.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
