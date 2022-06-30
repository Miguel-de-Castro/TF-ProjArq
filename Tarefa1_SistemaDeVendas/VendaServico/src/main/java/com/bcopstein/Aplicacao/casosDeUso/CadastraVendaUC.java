package com.bcopstein.Aplicacao.casosDeUso;

import java.util.ArrayList;
import java.util.List;

import com.bcopstein.Negocio.entidades.ItemCarrinho;
import com.bcopstein.Negocio.entidades.Venda;
import com.bcopstein.Negocio.servicos.IEstoqueProxy;
import com.bcopstein.Aplicacao.dtos.*;
import com.bcopstein.Aplicacao.servicos.VendaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CadastraVendaUC {
  @Autowired
  private VendaService servicoVenda;
  
  @Autowired
  private IEstoqueProxy proxy;

  public CadastraVendaUC(VendaService servicoVenda, IEstoqueProxy proxy) {
    this.servicoVenda = servicoVenda;
    this.proxy = proxy;
  }

  public Integer executar(ParamSubtotal_DTO dto) {

    List<ItemCarrinho> itens = new ArrayList<>(0);
    // TODO: chamar o endpoint do estoque que retorna todos os produtos
    List<ItemCarrinho> produtos = proxy.listaProdutos();

    for (ItemCarrinho item : dto.getItens()) {
      ItemCarrinho novoProduto = produtos.stream().filter(p -> p.getCodigo() == item.getCodigo()).findFirst().orElse(null);
      itens.add(new ItemCarrinho(novoProduto.getCodigo(), novoProduto.getDescricao(), Double.valueOf(novoProduto.getPreco()).intValue(),
          item.getQuantidade()));
    }

    Integer[] valores = servicoVenda.consultaVenda(itens , dto.getEndereco());
    Venda novaVenda = new Venda(valores[0], valores[1], valores[2], itens);
    return servicoVenda.cadastraVenda(novaVenda);
  }
}
