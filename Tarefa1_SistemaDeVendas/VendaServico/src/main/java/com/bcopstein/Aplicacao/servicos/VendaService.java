package com.bcopstein.Aplicacao.servicos;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalTime;
import java.util.List;

import com.bcopstein.Negocio.entidades.ItemCarrinho;
import com.bcopstein.Negocio.entidades.Venda;
import com.bcopstein.Negocio.repositorios.IVendaRepository;
import com.bcopstein.Negocio.servicos.ICalculoFrete;
import com.bcopstein.Negocio.servicos.ICalculoImposto;
import com.bcopstein.Negocio.servicos.IEstoqueProxy;
import com.bcopstein.Negocio.servicos.IRestricaoHorarioVenda;
import com.bcopstein.Negocio.servicos.IVendaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VendaService implements IVendaService{

  @Autowired
  private IVendaRepository vendaRepository;

  @Autowired
  private ICalculoImposto calculoImposto;

  @Autowired
  private ICalculoFrete calculoFrete;

  @Autowired
  private IEstoqueProxy proxy;

  public VendaService(IVendaRepository vendaRepository, ICalculoImposto calculoImposto, ICalculoFrete calculoFrete, IEstoqueProxy proxy) {
    this.vendaRepository = vendaRepository;
    this.calculoImposto = calculoImposto;
    this.calculoFrete = calculoFrete;
    this.proxy = proxy;
  }

  public Integer cadastraVenda(Venda novaVenda) {
    IRestricaoHorarioVenda restricaoVenda = RestricaoVendaFactory.getInstance(LocalTime.now());
    boolean vendaIsValida = restricaoVenda.vendaIsValida(novaVenda);

    if (!vendaIsValida) {
      return 1;
    }

    List<ItemCarrinho> produtos = novaVenda.getItensCarrinho();

    for (ItemCarrinho produto : produtos) {
      // TODO: podevender() ele vai ser chamado la do estoque
      boolean podeVender = proxy.podeVender(produto.getCodProduto(), produto.getQuantidade());

      // boolean podeVender = true;
      if (!podeVender) {
        return 2;
      }
    }

    for (ItemCarrinho produto : produtos) {
    //   // TODO: ItemEstoque ele vai ser chamado la do estoque
    //   ItemEstoque itemEstoque = servicoEstoque.getProduto(produto.getCodProduto());
    //   itemEstoque.setQuantidade(itemEstoque.getQuantidade() - produto.getQuantidade());
    //   servicoEstoque.atualizaProduto(itemEstoque);

      //TODO: fazer o rollback se falhar
      proxy.baixaEstoque(produto.getCodProduto(), produto.getQuantidade());
    }

    this.vendaRepository.cadastra(novaVenda); // TODO: alterar aqui chama o endpoint para adicionar no notafiscalservico
    //rabbitTemplate.convertAndSend("adiciona-nota-fiscal", "nota-fiscal.fila", msg);

    return 0;
  }

  public Integer[] consultaVenda(List<ItemCarrinho> itens, String endereco) {
    Integer subtotal = 0;
    Integer imposto = 0;
    Double frete = 0.0;

    for (ItemCarrinho prod : itens) {
      if (prod != null) {
        subtotal += (int) prod.getPrecoProd() * prod.getQuantidade();
      } else {
        throw new IllegalArgumentException("Codigo invalido");
      }
    }

    imposto = calculoImposto.calculaImposto(itens);

    if (endereco.equalsIgnoreCase("")){
        endereco = "portoalegre";
    }

    try {
      frete = calculoFrete.calculaFrete("portoalegre", endereco);
    } catch (URISyntaxException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    final Integer[] resp = new Integer[4];
    int freteInt = (int) Math.ceil(frete);

    resp[0] = subtotal;
    resp[1] = imposto;
    resp[2] = subtotal + imposto + freteInt;
    resp[3] = freteInt;
    

    return resp;
  }

  /* 
    TODO: MOVER PARA O SERVICO DE NOTA FISCAL
    public List<Venda> todos() {
      return vendaRepository.todos();
    }
  */
}
