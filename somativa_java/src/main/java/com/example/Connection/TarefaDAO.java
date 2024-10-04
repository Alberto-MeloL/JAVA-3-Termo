package com.example.Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import com.example.Model.StatusTarefa;

public class TarefaDAO {
    Connection connection;

    public TarefaDAO(Connection connection) {
        this.connection = connection;
    }

    // método para adicionar novas tarefas
    public void criarTarefa(String titulo) {

        String query = "INSERT INTO tarefa (titulo, status) VALUES (?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, titulo);
            preparedStatement.setObject(2, StatusTarefa.PENDENTE.name(), java.sql.Types.OTHER);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Tarefa criada com sucesso.");
            } else {
                System.err.println("Erro ao criar tarefa.");
            }
            System.err.println("Erro ao criar tarefa.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // método para listar as tarefas
    public void listarTarefas() {
        String query = "SELECT * FROM tarefa";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String titulo = resultSet.getString("titulo");
                String status = resultSet.getObject("status", String.class);
                System.out.println("Titulo " + titulo + " Status " + status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Erro ao listar tarefas.");
        }
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
                    try (PreparedStatement preparedStatementInsert = connection.prepareStatement(queryInsertStatus)) {
                        preparedStatementInsert.setString(1, buscarTarefa);
                        preparedStatementInsert.setObject(2, StatusTarefa.CANCELADO.name(), java.sql.Types.OTHER ); // Status, pode ser um valor do enum

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

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            if (buscarTarefa != null && !buscarTarefa.isEmpty()) {
                preparedStatement.setString(1, StatusTarefa.CONCLUÍDO.name());
                preparedStatement.setString(1, buscarTarefa);
                int rowsAffected = preparedStatement.executeUpdate(); // o que isso me retorna

                if (rowsAffected > 0) {
                    System.out.println("Tarefa marcada como concluida.");
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
    }

}


