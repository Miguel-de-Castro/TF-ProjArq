package com.bcopstein.Negocio.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ItemCarrinho {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer codCarrinho;

  @Column(name = "cod_produto")
  private Integer codigo;
  private Integer preco;
  private String descricao;
  private int quantidade;

  public ItemCarrinho(Integer codigo, String descricao, Integer preco, int quantidade) {
    this.codigo = codigo;
    this.descricao = descricao;
    this.preco = preco;
    this.quantidade = quantidade;
  }

  public ItemCarrinho() {

  }

 public Integer getCodProduto() {
    return codigo;
  }

  public void setCodProduto(Integer codProduto) {
    this.codigo = codProduto;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public Integer getPrecoProd() {
    return preco;
  }

  public void setPrecoProd(Integer precoProd) {
    this.preco = precoProd;
  }

  public int getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(int quantidade) {
    this.quantidade = quantidade;
  }

 

  @Override
  public String toString() {
    return "ItemCarrinho [codProduto=" + codigo + ", codigo=" + codCarrinho + ", precoProd=" + preco
        + ", quantidade=" + quantidade + "]";
  }
}
