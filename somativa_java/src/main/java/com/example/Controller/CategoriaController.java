package com.example.Controller;

import com.example.Connection.CategoriaDAO;
import com.example.Model.Categoria;
import com.example.Connection.ConnectionFactory;

import java.sql.Connection;
import java.util.List;

public class CategoriaController {
    public void adicionarCategoria(String nome) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
            Categoria novaCategoria = new Categoria(nome);
            categoriaDAO.adicionarCategoria(novaCategoria);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Categoria> buscarCategorias(String nomeFiltro) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
            return categoriaDAO.buscarCategorias(nomeFiltro);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
