package com.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        // SetExemplo set = new SetExemplo();
        // LIstExemplo listExemplo = new LIstExemplo();
        ArrayAsListExemplo lista = new ArrayAsListExemplo();
        lista.addNome("Alberto");
        lista.listar();

        // set.addNome("Alberto");
        // set.listarNomes();
        // listExemplo.addNome("Alberto");
        // listExemplo.addNome("Isabel");
        // listExemplo.addNome("Marina");
        // listExemplo.addNome("Maria");
        // listExemplo.addNome("Irineu");
        // listExemplo.listarNomes();
        // listExemplo.modificarNome("Maria", "Maria de Lourdes");
        // listExemplo.removerNomes("Irineu");
        // listExemplo.listarNomes();
        // }
    }
}