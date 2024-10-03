package com.example.Model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Tarefa {

    private String titulo;
    private String descricao;
    private LocalDate dataVencimento;
    private String prioridade;
    private String status;

}
