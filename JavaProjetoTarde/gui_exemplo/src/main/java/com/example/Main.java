package com.example;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        SwingUtilities.invokeLater(new Runnable() {
            public void run(){
                new MinhaJanela();
            }
        });
    }
}
