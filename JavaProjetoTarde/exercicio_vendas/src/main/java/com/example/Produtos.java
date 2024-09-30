package com.example;

import java.util.List;
import java.util.stream.Collectors;

public class Produtos {

    // método listar produtos de um cpf
    public List<Produtos> listarProdutos(String cpf) {
        List<Produtos> listaCpf = vendasCPF.getOrDefault(cpf, Collections.emptyList());
        return listaCpf;
    }


    // método para listar com filtro(stream)

    public List<Produtos> lisatProdutosFiltro(String cpf){
List<Produtos> listaCpfFiltro = vendasCPF.getOrDefault(
    cpf, Collections.emptyList()
);

if (listaCpfFiltro.isEmpty()) {
    throw new Exception("CPF não encontrado.");
}else{
    List<Produtos> resultado = listaCpfFiltro.stream().filter(p->p.getPreco()>=valorMinimo).collect(
        Collectors.toList()
    );
}
    }
}
