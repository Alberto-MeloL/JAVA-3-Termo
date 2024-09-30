package com.example;

import java.util.ArrayList;
import java.util.List;

public class Curso {
    private String nomeCurso;
    private List<Aluno> alunos;
    private Professor professor;

    public Curso(String nomeCurso){
        this.nomeCurso = nomeCurso;
        alunos = new ArrayList<>();
    }

    // adicionar Professor no curso
    public void addProf(Professor professor){
        this.professor = professor;
    }

    // adicionar Aluno no curso
    public void addAluno(Aluno aluno){
        alunos.add(aluno);
     }

    // lançar notas
    public void lancarNotas(String nomeAluno, double notaAluno){

    }

    public  void resultadoFinal(){
        for (Aluno aluno : alunos) {
            System.out.println(aluno.exibirInfo());
            aluno.avaliarDesempenho();
        }
    }
}
