package com.bcopstein.Negocio.servicos;

public interface IEstoqueProxy {
  void baixaEstoque(int codProd, int qtd);
  void desfazerBaixaEstoque(int codProd, int qtd);
}
