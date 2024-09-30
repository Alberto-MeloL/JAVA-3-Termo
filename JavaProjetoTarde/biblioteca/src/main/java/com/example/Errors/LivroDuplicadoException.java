package com.example.Errors;

// Em casos de livros já alugados ou devolvidos
public class LivroDuplicadoException extends Exception {
    public LivroDuplicadoException(String mensagem) {
        super(mensagem);
    }
}
