package com.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contato {
    private String nome;
    private String telefone;

    @Override
    public String toString() {
        return "Nome " + nome + " - Telefone " + telefone;
    }
}
