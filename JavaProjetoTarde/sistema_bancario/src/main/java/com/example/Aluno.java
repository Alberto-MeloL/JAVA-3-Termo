package com.example;

public class Aluno extends Pessoa implements Avaliavel{
    // atributos

    private String matricula;
    private double nota;

    public Aluno(String nome, String cpf, String matricula) {
        super(nome, cpf);
        this.matricula = matricula;
        this.nota = 0.0;
    }

    @Override
    public String exibirInfo() {
        return "Matricula" + matricula + " Nota: " + nota;
    }

    @Override
    public void avaliarDesempenho() {
if (nota >= 7) {
    System.out.println("Aluno aprovado.");

}else if (nota >=5 && nota < 7) {
    System.err.println("Aluno de recuperação.");
}else{
    System.out.println("Aluno reprovado.");
}

    }
}
