package com.bcopstein.Aplicacao.casosDeUso;

import com.bcopstein.Negocio.servicos.EstoqueService;
import com.bcopstein.Negocio.entidades.ItemEstoque;
import com.bcopstein.Negocio.entidades.Produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BaixaEstoqueUC {
  @Autowired
  private EstoqueService servicoEstoque;

  public BaixaEstoqueUC(EstoqueService servicoEstoque) {
    this.servicoEstoque = servicoEstoque;
  }

  public void executar(int codProduto, int quantidade) {
    ItemEstoque produto = servicoEstoque.getProduto(codProduto);
    produto.setQuantidade(produto.getQuantidade() - quantidade);
    servicoEstoque.atualizaProduto(produto);
    
  }
}
