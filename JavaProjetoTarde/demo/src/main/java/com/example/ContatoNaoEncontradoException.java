package com.example;

public class ContatoNaoEncontradoException extends Exception{
    public ContatoNaoEncontradoException(String mensagem){
        super(mensagem);
    }
}
