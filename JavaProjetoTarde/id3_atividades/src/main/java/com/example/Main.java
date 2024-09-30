package com.example;
import com.example.DiagnosticoSaudeID3  ;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");


            // Constrói a árvore de decisão
            No arvore = construirArvore();
    
            // Coleta sintomas do usuário
            Scanner scanner = new Scanner(System.in);
            Map<String, String> sintomas = new HashMap<>();
    
            System.out.println("Você tem febre? (Sim/Não): ");
            sintomas.put("Febre", scanner.nextLine());
    
            System.out.println("Você tem tosse? (Sim/Não): ");
            sintomas.put("Tosse", scanner.nextLine());
    
            System.out.println("Você tem dor de garganta? (Sim/Não): ");
            sintomas.put("Dor de Garganta", scanner.nextLine());
    
            // Previsão de doença com base nos sintomas
            String previsao = arvore.prever(sintomas);
            System.out.println("Possível doença: " + previsao);
    
            scanner.close();
        }
    }
    
