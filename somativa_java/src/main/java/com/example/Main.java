package com.example;

import com.example.Controller.TarefaController;
import com.example.View.TarefaView;

public class Main {
    public static void main(String[] args) {
        
        
        // Inicializa o controlador de tarefas
        TarefaController tarefaController = new TarefaController();

        // Inicializa a interface gráfica (View)
        TarefaView tarefaView = new TarefaView(tarefaController);

        // Adiciona um listener para fechar a aplicação corretamente
        tarefaView.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                tarefaController.closeConnection();
                System.exit(0);
            }
        });
    }
}
