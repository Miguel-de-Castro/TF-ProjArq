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

 public Integer getCodigo() {
    return codigo;
  }

  public void setCodigo(Integer codigo) {
    this.codigo = codigo;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public Integer getPreco() {
    return preco;
  }

  public void setPrecoProd(Integer preco) {
    this.preco = preco;
  }

  public int getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(int quantidade) {
    this.quantidade = quantidade;
  }

 

  @Override
  public String toString() {
    return "ItemCarrinho [codigo=" + codigo + ", codigo=" + codCarrinho + ", preco=" + preco
        + ", quantidade=" + quantidade + "]";
  }
}
