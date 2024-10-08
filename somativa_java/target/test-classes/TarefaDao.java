package com.example.Connection;
import com.example.Model.StatusTarefa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TarefaDAO {

    @Mock
    private Connection mockConnection;

    @Mock
    private PreparedStatement mockCheckStatement;

    @Mock
    private ResultSet mockResultSet;

    @InjectMocks
    private TarefaDAO tarefaDAO;

    @BeforeEach
    public void setUp() throws SQLException {
        MockitoAnnotations.openMocks(this);
        tarefaDAO = new TarefaDAO(mockConnection);
    }

    // Testes para criarTarefa
    @Test
    public void testCriarTarefa_TarefaJaExiste() throws SQLException {
        String titulo = "Tarefa Existente";

        when(mockConnection.prepareStatement("SELECT COUNT(*) FROM tarefa WHERE titulo = ?")).thenReturn(mockCheckStatement);
        when(mockCheckStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true);
        when(mockResultSet.getInt(1)).thenReturn(1);

        boolean resultado = tarefaDAO.criarTarefa(titulo);

        assertFalse(resultado, "Deve retornar false quando a tarefa já existe");

        verify(mockCheckStatement).setString(1, titulo);
        verify(mockCheckStatement).executeQuery();
        verify(mockCheckStatement).close();
    }

    @Test
    public void testCriarTarefa_Sucesso() throws SQLException {
        String titulo = "Nova Tarefa";

        when(mockConnection.prepareStatement("SELECT COUNT(*) FROM tarefa WHERE titulo = ?")).thenReturn(mockCheckStatement);
        when(mockCheckStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true);
        when(mockResultSet.getInt(1)).thenReturn(0);

        PreparedStatement mockInsertStatement = mock(PreparedStatement.class);
        when(mockConnection.prepareStatement("INSERT INTO tarefa (titulo, status) VALUES (?, ?)")).thenReturn(mockInsertStatement);
        when(mockInsertStatement.executeUpdate()).thenReturn(1);

        boolean resultado = tarefaDAO.criarTarefa(titulo);

        assertTrue(resultado, "Deve retornar true quando a tarefa é criada com sucesso");

        verify(mockCheckStatement).setString(1, titulo);
        verify(mockCheckStatement).executeQuery();
        verify(mockCheckStatement).close();

        verify(mockInsertStatement).setString(1, titulo);
        verify(mockInsertStatement).setObject(2, StatusTarefa.PENDENTE.name(), java.sql.Types.OTHER);
        verify(mockInsertStatement).executeUpdate();
        verify(mockInsertStatement).close();
    }

    @Test
    public void testCriarTarefa_ErroBancoDados() throws SQLException {
        String titulo = "Tarefa com Erro";

        when(mockConnection.prepareStatement("SELECT COUNT(*) FROM tarefa WHERE titulo = ?")).thenReturn(mockCheckStatement);
        when(mockCheckStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true);
        when(mockResultSet.getInt(1)).thenReturn(0);

        PreparedStatement mockInsertStatement = mock(PreparedStatement.class);
        when(mockConnection.prepareStatement("INSERT INTO tarefa (titulo, status) VALUES (?, ?)")).thenReturn(mockInsertStatement);
        when(mockInsertStatement.executeUpdate()).thenThrow(new SQLException("Erro na inserção"));

        boolean resultado = tarefaDAO.criarTarefa(titulo);

        assertFalse(resultado, "Deve retornar false quando ocorre um erro no banco de dados");

        verify(mockCheckStatement).setString(1, titulo);
        verify(mockCheckStatement).executeQuery();
        verify(mockCheckStatement).close();

        verify(mockInsertStatement).setString(1, titulo);
        verify(mockInsertStatement).setObject(2, StatusTarefa.PENDENTE.name(), java.sql.Types.OTHER);
        verify(mockInsertStatement).executeUpdate();
        verify(mockInsertStatement).close();
    }

    // Testes para editarTarefa
    @Test
    public void testEditarTarefa_Sucesso() throws SQLException {
        String buscarTarefa = "Tarefa Antiga";
        String tituloNovo = "Tarefa Nova";

        PreparedStatement mockUpdateStatement = mock(PreparedStatement.class);
        when(mockConnection.prepareStatement("UPDATE tarefa SET titulo = ? WHERE titulo = ?")).thenReturn(mockUpdateStatement);
        when(mockUpdateStatement.executeUpdate()).thenReturn(1);

        boolean resultado = tarefaDAO.editarTarefa(buscarTarefa, tituloNovo);

        assertTrue(resultado, "Deve retornar true quando a tarefa é editada com sucesso");

        verify(mockUpdateStatement).setString(1, tituloNovo);
        verify(mockUpdateStatement).setString(2, buscarTarefa);
        verify(mockUpdateStatement).executeUpdate();
        verify(mockUpdateStatement).close();
    }

    @Test
    public void testEditarTarefa_TarefaNaoEncontrada() throws SQLException {
        String buscarTarefa = "Tarefa Inexistente";
        String tituloNovo = "Tarefa Nova";

        PreparedStatement mockUpdateStatement = mock(PreparedStatement.class);
        when(mockConnection.prepareStatement("UPDATE tarefa SET titulo = ? WHERE titulo = ?")).thenReturn(mockUpdateStatement);
        when(mockUpdateStatement.executeUpdate()).thenReturn(0);

        boolean resultado = tarefaDAO.editarTarefa(buscarTarefa, tituloNovo);

        assertFalse(resultado, "Deve retornar false quando a tarefa não é encontrada");

        verify(mockUpdateStatement).setString(1, tituloNovo);
        verify(mockUpdateStatement).setString(2, buscarTarefa);
        verify(mockUpdateStatement).executeUpdate();
        verify(mockUpdateStatement).close();
    }

    // Testes para deletarTarefa
    @Test
    public void testDeletarTarefa_Sucesso() throws SQLException {
        String titulo = "Tarefa a Deletar";

        PreparedStatement mockCheckDeleteStatement = mock(PreparedStatement.class);
        ResultSet mockCheckResultSet = mock(ResultSet.class);
        when(mockConnection.prepareStatement("SELECT COUNT(*) FROM tarefa WHERE titulo = ?")).thenReturn(mockCheckDeleteStatement);
        when(mockCheckDeleteStatement.executeQuery()).thenReturn(mockCheckResultSet);
        when(mockCheckResultSet.next()).thenReturn(true);
        when(mockCheckResultSet.getInt(1)).thenReturn(1);

        PreparedStatement mockDeleteStatement = mock(PreparedStatement.class);
        when(mockConnection.prepareStatement("DELETE FROM tarefa WHERE titulo = ?")).thenReturn(mockDeleteStatement);
        when(mockDeleteStatement.executeUpdate()).thenReturn(1);

        PreparedStatement mockInsertStatusStatement = mock(PreparedStatement.class);
        when(mockConnection.prepareStatement("INSERT INTO status_final (nome_tarefa, status) VALUES (?, ?)")).thenReturn(mockInsertStatusStatement);
        when(mockInsertStatusStatement.executeUpdate()).thenReturn(1);

        doNothing().when(mockConnection).setAutoCommit(false);
        doNothing().when(mockConnection).commit();
        doNothing().when(mockConnection).setAutoCommit(true);

        boolean resultado = tarefaDAO.deletarTarefa(titulo);

        assertTrue(resultado, "Deve retornar true quando a tarefa é deletada com sucesso");

        verify(mockCheckDeleteStatement).setString(1, titulo);
        verify(mockCheckDeleteStatement).executeQuery();
        verify(mockCheckDeleteStatement).close();

        verify(mockConnection).setAutoCommit(false);

        verify(mockDeleteStatement).setString(1, titulo);
        verify(mockDeleteStatement).executeUpdate();
        verify(mockDeleteStatement).close();

        verify(mockInsertStatusStatement).setString(1, titulo);
        verify(mockInsertStatusStatement).setObject(2, StatusTarefa.CANCELADO.name(), java.sql.Types.OTHER);
        verify(mockInsertStatusStatement).executeUpdate();
        verify(mockInsertStatusStatement).close();

        verify(mockConnection).commit();
        verify(mockConnection).setAutoCommit(true);
    }

    @Test
    public void testDeletarTarefa_TarefaNaoExiste() throws SQLException {
        String titulo = "Tarefa Inexistente";

        PreparedStatement mockCheckDeleteStatement = mock(PreparedStatement.class);
        ResultSet mockCheckResultSet = mock(ResultSet.class);
        when(mockConnection.prepareStatement("SELECT COUNT(*) FROM tarefa WHERE titulo = ?")).thenReturn(mockCheckDeleteStatement);
        when(mockCheckDeleteStatement.executeQuery()).thenReturn(mockCheckResultSet);
        when(mockCheckResultSet.next()).thenReturn(true);
        when(mockCheckResultSet.getInt(1)).thenReturn(0);

        boolean resultado = tarefaDAO.deletarTarefa(titulo);

        assertFalse(resultado, "Deve retornar false quando a tarefa não existe");

        verify(mockCheckDeleteStatement).setString(1, titulo);
        verify(mockCheckDeleteStatement).executeQuery();
        verify(mockCheckDeleteStatement).close();

        verify(mockConnection, never()).setAutoCommit(false);
        verify(mockConnection, never()).commit();
        verify(mockConnection, never()).setAutoCommit(true);
    }

    // Testes para concluirTarefa
    @Test
    public void testConcluirTarefa_Sucesso() throws SQLException {
        String titulo = "Tarefa a Concluir";

        // Mock para verificar a existência da tarefa
        PreparedStatement mockCheckQueryStatement = mock(PreparedStatement.class);
        ResultSet mockCheckResultSet = mock(ResultSet.class);
        when(mockConnection.prepareStatement("SELECT COUNT(*) FROM tarefa WHERE titulo = ?")).thenReturn(mockCheckQueryStatement);
        when(mockCheckQueryStatement.executeQuery()).thenReturn(mockCheckResultSet);
        when(mockCheckResultSet.next()).thenReturn(true);
        when(mockCheckResultSet.getInt(1)).thenReturn(1);

        // Mock para atualizar o status da tarefa
        PreparedStatement mockUpdateStatement = mock(PreparedStatement.class);
        when(mockConnection.prepareStatement("UPDATE tarefa SET status = ? WHERE titulo = ?")).thenReturn(mockUpdateStatement);
        when(mockUpdateStatement.executeUpdate()).thenReturn(1);

        // Mock para inserir no status_final
        PreparedStatement mockInsertStatusStatement = mock(PreparedStatement.class);
        when(mockConnection.prepareStatement("INSERT INTO status_final (nome_tarefa, status) VALUES (?, ?)")).thenReturn(mockInsertStatusStatement);
        when(mockInsertStatusStatement.executeUpdate()).thenReturn(1);

        // Mock para deletar a tarefa
        PreparedStatement mockDeleteStatement = mock(PreparedStatement.class);
        when(mockConnection.prepareStatement("DELETE FROM tarefa WHERE titulo = ?")).thenReturn(mockDeleteStatement);
        when(mockDeleteStatement.executeUpdate()).thenReturn(1);

        // Simular transações
        doNothing().when(mockConnection).setAutoCommit(false);
        doNothing().when(mockConnection).commit();
        doNothing().when(mockConnection).setAutoCommit(true);

        boolean resultado = tarefaDAO.concluirTarefa(titulo);

        assertTrue(resultado, "Deve retornar true quando a tarefa é concluída com sucesso");

        // Verificações
        verify(mockCheckQueryStatement).setString(1, titulo);
        verify(mockCheckQueryStatement).executeQuery();
        verify(mockCheckQueryStatement).close();

        verify(mockConnection).setAutoCommit(false);

        verify(mockUpdateStatement).setObject(1, StatusTarefa.CONCLUÍDO.name(), java.sql.Types.OTHER);
        verify(mockUpdateStatement).setString(2, titulo);
        verify(mockUpdateStatement).executeUpdate();
        verify(mockUpdateStatement).close();

        verify(mockInsertStatusStatement).setString(1, titulo);
        verify(mockInsertStatusStatement).setObject(2, StatusTarefa.CONCLUÍDO.name(), java.sql.Types.OTHER);
        verify(mockInsertStatusStatement).executeUpdate();
        verify(mockInsertStatusStatement).close();

        verify(mockDeleteStatement).setString(1, titulo);
        verify(mockDeleteStatement).executeUpdate();
        verify(mockDeleteStatement).close();

        verify(mockConnection).commit();
        verify(mockConnection).setAutoCommit(true);
    }

    @Test
    public void testConcluirTarefa_TarefaNaoExiste() throws SQLException {
        String titulo = "Tarefa Inexistente";

        PreparedStatement mockCheckQueryStatement = mock(PreparedStatement.class);
        ResultSet mockCheckResultSet = mock(ResultSet.class);
        when(mockConnection.prepareStatement("SELECT COUNT(*) FROM tarefa WHERE titulo = ?")).thenReturn(mockCheckQueryStatement);
        when(mockCheckQueryStatement.executeQuery()).thenReturn(mockCheckResultSet);
        when(mockCheckResultSet.next()).thenReturn(true);
        when(mockCheckResultSet.getInt(1)).thenReturn(0);

        boolean resultado = tarefaDAO.concluirTarefa(titulo);

        assertFalse(resultado, "Deve retornar false quando a tarefa não existe ou já foi concluída");

        verify(mockCheckQueryStatement).setString(1, titulo);
        verify(mockCheckQueryStatement).executeQuery();
        verify(mockCheckQueryStatement).close();

        verify(mockConnection, never()).setAutoCommit(false);
        verify(mockConnection, never()).commit();
        verify(mockConnection, never()).setAutoCommit(true);
    }

    // Você pode adicionar mais testes para outros métodos conforme necessário
}
