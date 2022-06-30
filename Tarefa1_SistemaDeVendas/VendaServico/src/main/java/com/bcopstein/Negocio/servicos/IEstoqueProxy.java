package com.bcopstein.Negocio.servicos;

import java.util.List;

import com.bcopstein.Negocio.entidades.ItemCarrinho;

public interface IEstoqueProxy {
  void baixaEstoque(Integer codProd, Integer qtdade);

	void desfazerBaixaEstoque(Integer codProd, Integer qtdade);

	List<ItemCarrinho> listaProdutos();

	boolean podeVender(Integer codProd, Integer qtdade);
}
