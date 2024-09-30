package br.com.alberto;

import java.util.Scanner;

public class AprovacaoAlunos {

    // atributos
    // ver doferenças
    double[] notas = new double[4];
    double mediaNotas = 0;
    boolean bonus = true;

    Scanner sc = new Scanner(System.in);

    public void resolucao() {
        System.out.println("Hello World!");
    }

    public void calculoNotas() {

        for (int i = 0; i < notas.length; i++) {
            System.out.println("Digite a nota " + i + ":");
            notas[i] = sc.nextDouble();
            // somar as notas no variavel média
            mediaNotas += notas[i];

            // inválida o bonus
            if (notas[i] < 7) {
                bonus = false;
            }

            mediaNotas /= notas.length;

            // aplicar o bonus

            if (bonus) {
                mediaNotas = (mediaNotas * 1.1 > 10 ? mediaNotas = 10 : mediaNotas * 1.1);
            }

            if (mediaNotas >= 7) {
                System.out.println("Aprovado.");
            } else if (mediaNotas >= 5 && mediaNotas < 7) {
                System.out.println("Recuperação.");
            } else {
                System.out.println("Reprovado.");
            }
        }
    }
}
