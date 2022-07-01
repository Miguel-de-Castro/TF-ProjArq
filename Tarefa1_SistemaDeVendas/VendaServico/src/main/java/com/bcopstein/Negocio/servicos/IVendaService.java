package com.bcopstein.Negocio.servicos;

import com.bcopstein.Negocio.entidades.Venda;
import java.util.List;
import com.bcopstein.Negocio.entidades.ItemCarrinho;

public interface IVendaService {
    public Integer cadastraVenda(Venda novaVenda);
    public Integer[] consultaVenda(List<ItemCarrinho> itens, String endereco);
}
