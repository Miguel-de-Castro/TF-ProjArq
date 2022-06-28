package com.bcopstein.Aplicacao.dtos;

import com.google.gson.Gson;

// this code use Gson: https://github.com/google/gson/blob/master/UserGuide.md

public class NFDTO {
    private Integer codVenda;
    private Integer subtotal;
    private Integer impostos;
    private Integer total;
    //botar essa lisatagem??
    //private List<ItemCarrinho> itensCarrinho;
    
    public NFDTO(Integer codVenda,Integer subtotal,Integer impostos,Integer total) {
        this.codVenda = codVenda;
        this.subtotal = subtotal;
        this.impostos = impostos;
        this.total = total;
    }

    public NFDTO(){

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

    @Override
    public String toString() {
        return "NFDTO [codVenda=" + codVenda + ", subtotal=" + subtotal + ", impostos=" + impostos + ", total =" + total + "]";
    }  
    
    public static NFDTO fromJSon(String json){
        Gson gson = new Gson();
        return gson.fromJson(json, NFDTO.class);
    }

    public String toJSon(){
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
