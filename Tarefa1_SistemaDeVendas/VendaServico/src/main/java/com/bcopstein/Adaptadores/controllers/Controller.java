package com.bcopstein.Adaptadores.controllers;

import java.util.ArrayList;
import java.util.List;

import com.bcopstein.Aplicacao.dtos.ParamSubtotal_DTO;
import com.bcopstein.Adaptadores.proxy.EstoqueProxy;
import com.bcopstein.Aplicacao.casosDeUso.CadastraVendaUC;
// import com.bcopstein.Aplicacao.casosDeUso.CadastraProdutos;
// import com.bcopstein.Aplicacao.casosDeUso.ConsultaProdutosUC;
// import com.bcopstein.Aplicacao.casosDeUso.ConsultaVendasUC;
import com.bcopstein.Aplicacao.casosDeUso.ConsultaVendaUC;
import com.bcopstein.Negocio.entidades.ItemCarrinho;
import com.bcopstein.Negocio.entidades.Venda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vendas")
public class Controller {
  
  @Autowired
  private CadastraVendaUC cadastraVenda;
  
  @Autowired
  private ConsultaVendaUC consultaVenda;
  
  // @Autowired
  // private ConsultaVendasUC consultaVendas;

  // @Autowired
  // private ConsultaProdutosUC consultaProdutos;
  
  // @Autowired
  // private CadastraProdutos cadastraProdutos;
  
  @Autowired
	private EstoqueProxy proxy;

  public Controller(CadastraVendaUC cadastraVenda,
      ConsultaVendaUC consultaVenda){
    this.cadastraVenda = cadastraVenda;
    this.consultaVenda = consultaVenda;
  }

  // TODO: acredito que o front chame o endpoint lá do estoque direto que contem os produtos
  @GetMapping("/produtos")
  @CrossOrigin(origins = "*")
  public List<ItemCarrinho> listaProdutos() {
    List<ItemCarrinho> itensProxy = proxy.listaProdutos();
    List<ItemCarrinho> itens = new ArrayList<>();
    for (ItemCarrinho i : itensProxy) {
      itens.add(new ItemCarrinho(i.getCodigo(), i.getDescricao(), i.getPreco(), 2));
    }
    return itens;
  }

  @GetMapping("/autorizacao")
  @CrossOrigin(origins = "*")
  public boolean podeVender(@RequestParam final Integer codProd, @RequestParam final Integer qtdade) {
    return proxy.podeVender(codProd, qtdade);
  }

  @GetMapping("/baixaEstoque")
  @CrossOrigin(origins = "*")
  public void baixaEstoque(@RequestParam final Integer codProd, @RequestParam final Integer qtdade) {
    proxy.baixaEstoque(codProd, qtdade);
  }

  @GetMapping("/desfazerBaixaEstoque")
  @CrossOrigin(origins = "*")
  public void desfazerBaixaEstoque(@RequestParam final Integer codProd, @RequestParam final Integer qtdade) {
    proxy.desfazerBaixaEstoque(codProd, qtdade);
  }

  // TODO: manter endopoint pq é o que cadastra a venda e dentro dele é usado o servico do notafiscal
  @PostMapping("/confirmacao")
  @CrossOrigin(origins = "*")
  public Integer confirmaVenda(@RequestBody final ParamSubtotal_DTO dto) {
    return cadastraVenda.executar(dto);
  }

  @PostMapping("/subtotal")
  @CrossOrigin(origins = "*")
  public Integer[] calculaSubtotal(@RequestBody final ParamSubtotal_DTO dto) {
    return consultaVenda.executar(dto);
  }

  // TODO: vai chamar pelo proxy o endpoint com as vendas registradas na notafiscal
  @GetMapping("/historico")
  @CrossOrigin(origins = "*")
  public List<Venda> vendasEfetuadas() {
    return new ArrayList<>();
  }
}
