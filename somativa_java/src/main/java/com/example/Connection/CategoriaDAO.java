package com.example.Connection;

import com.example.Model.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {
    private Connection connection;

    public CategoriaDAO(Connection connection) {
        this.connection = connection;
    }

    // Método para adicionar uma nova categoria
    public void adicionarCategoria(Categoria categoria) {
        String query = "INSERT INTO categoria (nome) VALUES (?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, categoria.getNome());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para buscar categorias
    public List<Categoria> buscarCategorias(String nomeFiltro) {
        List<Categoria> categorias = new ArrayList<>();
        String query = "SELECT * FROM categoria WHERE id = ? AND categotia = ?";
        
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, "%" + nomeFiltro + "%"); // Busca parcial
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String categoriaNome = resultSet.getString("nome");
                categorias.add(new Categoria(categoriaNome));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return categorias;
    }
}
