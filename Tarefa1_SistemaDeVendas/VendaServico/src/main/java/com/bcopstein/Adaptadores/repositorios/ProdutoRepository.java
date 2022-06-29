package com.bcopstein.Adaptadores.repositorios;

import java.util.List;

import com.bcopstein.Negocio.entidades.Produto;
import com.bcopstein.Negocio.repositorios.IProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProdutoRepository implements IProdutoRepository {
    
    private IProdutoCrud produtoCrud;

    @Autowired
    public ProdutoRepository(IProdutoCrud produtoCrud) {
      this.produtoCrud = produtoCrud;
    }
  
    @Override
    public List<Produto> todos() {
      return produtoCrud.findAll();
    }
}
