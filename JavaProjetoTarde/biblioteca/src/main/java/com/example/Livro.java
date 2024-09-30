package com.example;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Livro {
    private int indiceLivro;  // Altere para um índice que corresponda ao array
    private int indiceDVD;    // Adicione um índice para DVDs
    private int indiceRevista; // Adicione um índice para revistas

    String[] livros = {
        "O Antigo Testamento", "A Bíblia", "Jesus: Uma Biografia",
        "O Nazareno", "A História de Jesus", "O Evangelho Segundo Jesus Cristo",
        "A Vida de Jesus", "O Messias", "Cristianismo Puro e Simples",
        "A História do Judaísmo"
    };

    String[] revistas = {
        "National Geographic", "Biblical Archaeology Review", "History Today",
        "Smithsonian Magazine", "TIME", "The Atlantic",
        "Christianity Today", "Judaica", "Religious Studies Review",
        "Archaeology Magazine"
    };

    String[] dvds = {
        "A Paixão de Cristo", "Jesus de Nazaré", "O Rei dos Reis",
        "A História do Cristianismo", "Os 10 Mandamentos",
        "O Príncipe do Egito", "A Bíblia", "Ressurreição",
        "The Gospel of John", "Paul, Apostle of Christ"
    };

    public String msgLocacaoLivro() {
        return "Livro alugado com sucesso: [Nome: ] " + livros[indiceLivro];
    }

    public String msgDevolucaoLivro() {
        return "Livro devolvido com sucesso: [Nome: ] " + livros[indiceLivro];
    }

    public String msgLocacaoDVD() {
        return "DVD alugado com sucesso: [Nome: ] " + dvds[indiceDVD];
    }

    public String msgDevolucaoDVD() {
        return "DVD devolvido com sucesso: [Nome: ] " + dvds[indiceDVD];
    }

    public String msgLocacaoRevista() {
        return "Revista alugada com sucesso: [Nome: ] " + revistas[indiceRevista];
    }

    public String msgDevolucaoRevista() {
        return "Revista devolvida com sucesso: [Nome: ] " + revistas[indiceRevista];
    }
}
