package com.bcopstein.Negocio.entidades;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Venda {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "cod_venda")
  private Integer codVenda;
  private Integer subtotal;
  private Integer impostos;
  private Integer total;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "cod_venda")
  private List<ItemCarrinho> itensCarrinho;

  public Venda(Integer codVenda, Integer subtotal, Integer impostos, Integer total, List<ItemCarrinho> itensCarrinho) {
    this.codVenda = codVenda;
    this.subtotal = subtotal;
    this.impostos = impostos;
    this.total = total;
    this.itensCarrinho = itensCarrinho;
  }

  public Venda() {

  }

  public Venda(Integer subtotal, Integer impostos, Integer total, List<ItemCarrinho> itensCarrinho) {
    this.subtotal = subtotal;
    this.impostos = impostos;
    this.total = total;
    this.itensCarrinho = itensCarrinho;
  }

  public Integer getCodVenda() {
    return codVenda;
  }

  public void setCodVenda(Integer codVenda) {
    this.codVenda = codVenda;
  }

  public Integer getSubtotal() {
    return subtotal;
  }

  public void setSubtotal(Integer subtotal) {
    this.subtotal = subtotal;
  }

  public Integer getImpostos() {
    return impostos;
  }

  public void setImpostos(Integer impostos) {
    this.impostos = impostos;
  }

  public Integer getTotal() {
    return total;
  }

  public void setTotal(Integer total) {
    this.total = total;
  }

  public List<ItemCarrinho> getItensCarrinho() {
    return itensCarrinho;
  }

  public void setItensCarrinho(List<ItemCarrinho> itensCarrinho) {
    this.itensCarrinho = itensCarrinho;
  }

}
