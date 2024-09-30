package com.example;

public class AgendaTelefonica {
    int contador = 0;
    Contato[] contatos; // Altere o tipo de int[] para Contato[]

    // Construtor para inicializar o array de contatos
    public AgendaTelefonica(int capacidade) {
        contatos = new Contato[capacidade];
    }

    // Adicionar
    public void adicionarContato(Contato contato) throws AgendaCheiaException {
        if (contador >= contatos.length) {
            throw new AgendaCheiaException("Agenda cheia.");
        }
        contatos[contador] = contato; // Adiciona o contato corretamente
        contador++;
    }

    // Listar
    public void listarContatos() {
        if (contador == 0) {
            System.out.println("Agenda vazia.");
        } else {
            for (int i = 0; i < contador; i++) {
                System.out.println(contatos[i].toString()); // Chama o método toString()
            }
        }
    }

    // Buscar (pode ser implementado)
    // buscar por vários, talvez seja imprecisas
    public Contato buscarContato(String nome) throws ContatoNaoEncontradoException {

        for (int i = 0; i < contador; i++) {
            if (contatos[i].getNome().equalsIgnoreCase(nome)) {
                return contatos[i];
            }
        }
        throw new ContatoNaoEncontradoException("Contato não encontrado.");
    }

    // Remover (pode ser implementado)

    public void removerConta(String nome) throws ContatoNaoEncontradoException {
        boolean encontrado = false;
        for (int i = 0; i < contador; i++) {
            if (contatos[i].getNome().equalsIgnoreCase(nome)) {
                encontrado = true;
                contatos[i] = contatos[contador - 1];
                System.out.println(encontrado);
            }
        }

        if (!encontrado) {
            throw new ContatoNaoEncontradoException("Contato não encontrado.");
        }
    }
}
