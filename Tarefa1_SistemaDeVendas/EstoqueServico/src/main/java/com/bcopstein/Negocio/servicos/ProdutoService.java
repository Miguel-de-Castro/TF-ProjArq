package com.bcopstein.Negocio.servicos;

import java.util.List;

import com.bcopstein.Negocio.entidades.Produto;

import com.bcopstein.Negocio.repositorios.IProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProdutoService {

    @Autowired
    private IProdutoRepository repo;

    public ProdutoService(IProdutoRepository repo) {
        this.repo = repo;
    }

    public List<Produto> todos(){
        return repo.todos();
    }
    
    public void criar(int codigo, String nome, double preco){
        repo.criarProdutos(codigo, nome, preco);
    }
    
}
