package com.bcopstein.Aplicacao.casosDeUso;

import com.bcopstein.Negocio.servicos.EstoqueService;
import com.bcopstein.Negocio.entidades.ItemEstoque;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConsultaProdutoUC {
  @Autowired
  private EstoqueService servicoEstoque;

  public ConsultaProdutoUC(EstoqueService servicoEstoque) {
    this.servicoEstoque = servicoEstoque;
  }

  public ItemEstoque executar(int codProduto) {
    return servicoEstoque.getProduto(codProduto);
  }
}
