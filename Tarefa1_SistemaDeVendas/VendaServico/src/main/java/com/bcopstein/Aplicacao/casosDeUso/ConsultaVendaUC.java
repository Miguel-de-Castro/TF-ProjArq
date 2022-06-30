package com.bcopstein.Aplicacao.casosDeUso;

import java.util.ArrayList;
import java.util.List;

import com.bcopstein.Negocio.servicos.IEstoqueProxy;
import com.bcopstein.Aplicacao.dtos.ParamSubtotal_DTO;
import com.bcopstein.Aplicacao.servicos.VendaService;
import com.bcopstein.Negocio.entidades.ItemCarrinho;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConsultaVendaUC {

  @Autowired
  private VendaService servicoVenda;

  @Autowired
  private IEstoqueProxy proxy;

  public ConsultaVendaUC(VendaService servicoVenda) {
    this.servicoVenda = servicoVenda;
  }

  public Integer[] executar(ParamSubtotal_DTO dto) {
    List<ItemCarrinho> itens = new ArrayList<>(0);
    List<ItemCarrinho> produtos = proxy.listaProdutos();
    

    for (ItemCarrinho item : dto.getItens() ) {
      ItemCarrinho novoProduto = produtos.stream().filter(p -> p.getCodigo() == item.getCodigo()).findFirst().orElse(null);
      itens.add(new ItemCarrinho(novoProduto.getCodigo(), novoProduto.getDescricao(), Double.valueOf(novoProduto.getPreco()).intValue(),
          item.getQuantidade()));
    }

    return servicoVenda.consultaVenda(itens,dto.getEndereco());
  }
}
