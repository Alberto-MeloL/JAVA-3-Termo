package com.example.Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.time.LocalDate;

import com.example.Model.StatusTarefa;

public class TarefaDAO {
    Connection connection;

    public TarefaDAO(Connection connection) {
        this.connection = connection;
    }

    // método para adicionar novas tarefas
    public void criarTarefa(String titulo, String descricao, LocalDate dataVendimento, String prioridade,
            String status) {

        String query = "INSERT INTO tarefa (titulo, descricao, data_vencimento, prioridade, status)" +
                "VALUES (?,?,?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, titulo);
            preparedStatement.setString(2, descricao);
            preparedStatement.setDate(3, java.sql.Date.valueOf(dataVendimento));
            preparedStatement.setString(4, prioridade);
            preparedStatement.setString(5, StatusTarefa.PENDENTE.name());

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
                int id = resultSet.getInt("id");
                String titulo = resultSet.getString("titulo");

                System.out.println("ID " + id + " Titulo " + titulo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Erro ao listar tarefas.");
        }
    }

    // método para listar uma tarefa específica
    public void listarTarefa(String buscarTarefa) {
        String query = "SELECT * FROM tarefa WHERE titulo = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String titulo = resultSet.getString("titulo");

                System.out.println("ID " + id + " Titulo " + titulo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Erro ao listar tarefa.");
        }
    }

    // método para editar tarefa
    public void editarTarefa(String buscarTarefa, String titulo, String descricao, LocalDate dataVencimento,
            String prioridade) {
        StringBuilder query = new StringBuilder("UPDATE tarefa SET ");
        boolean first = true;

        // campos a serem atualizados
        if (titulo != null && !titulo.isEmpty()) {
            query.append("titulo = ?");
            first = false;
        }

        if (descricao != null && !descricao.isEmpty()) {
            if (!first)
                query.append(", ");
            query.append("descricao = ?");
            first = false;
        }

        if (dataVencimento != null) {
            if (!first)
                query.append(", ");
            query.append("data_venciamento = ?");
            first = false;
        }

        if (prioridade != null && !prioridade.isEmpty()) {
            if (first)
                query.append(", ");
            query.append("prioridade = ?");
        }
        query.append("WHERE titulo = ?");

        try (PreparedStatement preparedStatement = connection.prepareStatement(query.toString())) {

            if (titulo != null && !titulo.isEmpty())
                preparedStatement.setString(2, titulo);
            if (descricao != null && !descricao.isEmpty())
                preparedStatement.setString(3, descricao);
            if (dataVencimento != null)
                preparedStatement.setDate(4, java.sql.Date.valueOf(dataVencimento));
            if (prioridade != null && !prioridade.isEmpty())
                preparedStatement.setString(5, prioridade);

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
        String query = "DELETE FROM tarefa WHERE titulo = ?";
        String queryCancelar = "INSERT INTO status_final (nome_tarefa, data_final, status) VALUES(?,?,?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery()) {

            if (buscarTarefa != null && !buscarTarefa.isEmpty()) {
                // testar com executeUpdate()
                // eu preciso definir o parâmetro mesmo tendo apenas um
                preparedStatement.setString(1, buscarTarefa);

                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Tarefa deletada com sucesso.");

                    listarTarefa(buscarTarefa);

                    while (resultSet.next()) {
                        
                    }
                } else {
                    System.err.println("Erro ao delatr tarefa.");
                }
            } else {
                System.err.println("O titulo não pode ser vazio ou nulo.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Erro ao deletar tarefa.");
        }
    }
// método status final
    // método para marcar como concluida
    public void concluirTarefa(String buscarTarefa) {
        String query = "UPDATE tarefa SET status = ? WHERE titulo = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            if (buscarTarefa != null && !buscarTarefa.isEmpty()) {
                preparedStatement.setString(1, StatusTarefa.CONCLUIDO.name());
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


// // método para deletar tarefa
// public void deletarTarefa(String buscarTarefa) {
//     String queryDelete = "DELETE FROM tarefa WHERE titulo = ?";
//     String queryInsertStatus = "INSERT INTO status_final (nome_tarefa, data_final, status) VALUES (?, ?, ?)";

//     try {
//         // Inicia uma transação
//         connection.setAutoCommit(false);

//         // Preparar o statement para deletar a tarefa
//         try (PreparedStatement preparedStatementDelete = connection.prepareStatement(queryDelete)) {
//             if (buscarTarefa != null && !buscarTarefa.isEmpty()) {
//                 preparedStatementDelete.setString(1, buscarTarefa);

//                 int rowsAffected = preparedStatementDelete.executeUpdate();
//                 if (rowsAffected > 0) {
//                     System.out.println("Tarefa deletada com sucesso.");

//                     // Agora insere o registro na tabela de status final
//                     try (PreparedStatement preparedStatementInsert = connection.prepareStatement(queryInsertStatus)) {
//                         preparedStatementInsert.setString(1, buscarTarefa);
//                         preparedStatementInsert.setDate(2, java.sql.Date.valueOf(LocalDate.now())); // Data atual
//                         preparedStatementInsert.setString(3, "Deletada"); // Status, pode ser um valor do enum

//                         preparedStatementInsert.executeUpdate();
//                     }

//                     // Confirma a transação
//                     connection.commit();
//                 } else {
//                     System.err.println("Erro ao deletar tarefa.");
//                 }
//             } else {
//                 System.err.println("O título não pode ser vazio ou nulo.");
//             }
//         } catch (SQLException e) {
//             // Reverte a transação em caso de erro
//             connection.rollback();
//             e.printStackTrace();
//             System.err.println("Erro ao deletar tarefa.");
//         }
//     } catch (SQLException e) {
//         e.printStackTrace();
//     } finally {
//         try {
//             // Restaura o modo de autocommit
//             connection.setAutoCommit(true);
//         } catch (SQLException e) {
//             e.printStackTrace();
//         }
//     }
// }
