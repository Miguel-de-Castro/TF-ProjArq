package com.bcopstein.Aplicacao.casosDeUso;
import java.util.List;

import com.bcopstein.Negocio.entidades.ItemEstoque;
import com.bcopstein.Negocio.entidades.Produto;
import com.bcopstein.Negocio.servicos.ProdutoService;
import com.bcopstein.Negocio.servicos.EstoqueService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

@Component
public class CadastraProdutos {

  @Autowired
  private ProdutoService servicoProduto;

  @Autowired
  private EstoqueService servicoEstoque;

  @Autowired
  private RabbitTemplate rabbitTemplate;

  public CadastraProdutos(ProdutoService servicoProduto, EstoqueService servicoEstoque) {
    this.servicoProduto = servicoProduto;
    this.servicoEstoque = servicoEstoque;
  }

  public boolean executar() {
    servicoProduto.criar();
    List<Produto> list = servicoProduto.todos();

    for (Produto produto : list) {
      servicoEstoque.atualizaProduto(new ItemEstoque(produto.getCodigo(),produto,10));
    }

    String msg = "teste - aqui seria enviado os novos produtos para cadastrar";
    rabbitTemplate.convertAndSend("adiciona-estoque", "estoque.fila", msg);
    
    return true;
  }
}
