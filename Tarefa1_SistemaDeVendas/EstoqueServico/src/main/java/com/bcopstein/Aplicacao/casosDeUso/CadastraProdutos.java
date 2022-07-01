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

  public CadastraProdutos(ProdutoService servicoProduto, EstoqueService servicoEstoque, RabbitTemplate rabbitTemplate) {
    this.servicoProduto = servicoProduto;
    this.rabbitTemplate = rabbitTemplate;
    this.servicoEstoque = servicoEstoque;
  }

  public boolean executar() {
    String msg = "1;Produto 1;45.0";
    rabbitTemplate.convertAndSend("adiciona-estoque", "estoque.fila", msg);
    msg = "2;Produto 2;5.0";
    rabbitTemplate.convertAndSend("adiciona-estoque", "estoque.fila", msg);
    msg = "3;Produto 3;50.0";
    rabbitTemplate.convertAndSend("adiciona-estoque", "estoque.fila", msg);
    
    List<Produto> list = servicoProduto.todos();

    for (Produto produto : list) {
      servicoEstoque.atualizaProduto(new ItemEstoque(produto.getCodigo(),produto,10));
    }    
    return true;
  }
}
