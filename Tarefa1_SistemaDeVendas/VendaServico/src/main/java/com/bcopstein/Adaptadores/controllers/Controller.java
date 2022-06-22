package com.bcopstein.Adaptadores.controllers;

import java.util.List;

import com.bcopstein.Aplicacao.dtos.ParamSubtotal_DTO;
import com.bcopstein.Aplicacao.casosDeUso.CadastraProdutos;
import com.bcopstein.Aplicacao.casosDeUso.CadastraVendaUC;
import com.bcopstein.Aplicacao.casosDeUso.ConsultaProdutosUC;
import com.bcopstein.Aplicacao.casosDeUso.ConsultaVendaUC;
import com.bcopstein.Aplicacao.casosDeUso.ConsultaVendasUC;
import com.bcopstein.Aplicacao.casosDeUso.VerificaEstoqueProdutoUC;
import com.bcopstein.Negocio.entidades.Produto;
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
@RequestMapping("/venda")
public class Controller {
  private CadastraVendaUC cadastraVenda;
  private ConsultaVendasUC consultaVendas;

  @Autowired
  public Controller(CadastraVendaUC cadastraVenda, ConsultaVendasUC consultaVendas) {
    this.cadastraVenda = cadastraVenda;
    this.consultaVendas = consultaVendas;
  }

  // verificar sobre o CLEAN
  @PostMapping("/confirmacao")
  @CrossOrigin(origins = "*")
  public Integer confirmaVenda(@RequestBody final ParamSubtotal_DTO dto) {
    // chama verifica se pode chamando o autorizacao do estoque
    int vendeu = cadastraVenda.executar(dto);
    if(vendeu == 0){
      // chama o endpoint de tirar do estoque
    }
    return vendeu;
  }

  @GetMapping("/historico")
  @CrossOrigin(origins = "*")
  public List<Venda> vendasEfetuadas() {
    return consultaVendas.executar();
  }
}