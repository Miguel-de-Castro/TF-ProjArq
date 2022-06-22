package com.bcopstein.Adaptadores.controllers;

import java.util.List;

import com.bcopstein.Aplicacao.casosDeUso.CadastraProdutos;
import com.bcopstein.Aplicacao.casosDeUso.ConsultaProdutosUC;
import com.bcopstein.Aplicacao.casosDeUso.VerificaEstoqueProdutoUC;
import com.bcopstein.Negocio.entidades.Produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estoque")
public class Controller {

  @Autowired
  private VerificaEstoqueProdutoUC verificaEstoqueProduto;

  @Autowired
  private ConsultaProdutosUC consultaProdutos;

  @Autowired
  private CadastraProdutos cadastraProdutos;

  public Controller(VerificaEstoqueProdutoUC verificaEstoqueProdutoUC, 
        ConsultaProdutosUC consultaProdutos, CadastraProdutos cadastraProdutos) {
    this.verificaEstoqueProduto = verificaEstoqueProdutoUC;
    this.consultaProdutos = consultaProdutos;
    this.cadastraProdutos = cadastraProdutos;
  }

  @GetMapping("/produtos")
  @CrossOrigin(origins = "*")
  public List<Produto> listaProdutos() {
    return consultaProdutos.executar();
  }

  @GetMapping("/autorizacao")
  @CrossOrigin(origins = "*")
  public boolean podeVender(@RequestParam final Integer codProd, @RequestParam final Integer qtdade) {
    return verificaEstoqueProduto.executar(codProd, qtdade);
  }

  @PostMapping("/criarProdutos")
  @CrossOrigin(origins = "*")
  public void criarProdutos() {
    cadastraProdutos.executar();
  }

  @PostMapping("/")
}
