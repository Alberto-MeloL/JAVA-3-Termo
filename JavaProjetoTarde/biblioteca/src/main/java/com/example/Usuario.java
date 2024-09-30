package com.example;

import java.util.ArrayList;
import java.util.List;

import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

public class Usuario {
    private String nomeUsuario;
    private List<Livro> livrosAlugados;

    // Construtor
    public Usuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
        this.livrosAlugados = new ArrayList<>();
    }

    // Método para alugar um livro
    public void alugarLivro(Livro livro) {

        if (livrosAlugados.contains(livro)) {
            return
        }
        livrosAlugados.add(livro);
    }

    // Método para devolver um livro
    public void devolverLivro(Livro livro) {
        livrosAlugados.remove(livro);
    }
}
