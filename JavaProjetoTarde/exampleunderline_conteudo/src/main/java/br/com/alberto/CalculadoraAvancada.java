package br.com.alberto;

import java.util.Scanner;

public class CalculadoraAvancada {

    double a, b, resultado;
    int escolha;

    Scanner sc = new Scanner(System.in);

    // criar métodos 

    public double somar(double a, double b ){
       resultado = a+b;
        return resultado;
    }
    public double subtrair(double a, double b){
       resultado = a-b;
        return resultado;
    }
    public double dividir(double a, double b){
        resultado = a/b;
        return resultado;
    }
    public double multiplicar(double a, double b){
        return resultado;
    }
    public double raiz(double a){
        return Math.sqrt(a);
    }
}
