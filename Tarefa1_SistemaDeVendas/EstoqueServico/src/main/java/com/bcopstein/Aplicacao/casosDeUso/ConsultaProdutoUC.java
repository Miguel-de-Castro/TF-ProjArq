package com.bcopstein.Aplicacao.casosDeUso;

import java.util.List;

import com.bcopstein.Negocio.servicos.EstoqueService;
import com.bcopstein.Negocio.servicos.ProdutoService;
import com.bcopstein.Negocio.entidades.ItemEstoque;
import com.bcopstein.Negocio.entidades.Produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConsultaProdutoUC {
  private EstoqueService servicoEstoque;

  @Autowired
  public ConsultaProdutoUC(EstoqueService servicoEstoque) {
    this.servicoEstoque = servicoEstoque;
  }

  public ItemEstoque executar(int codProduto) {
    return servicoEstoque.getProduto(codProduto);
  }
}
