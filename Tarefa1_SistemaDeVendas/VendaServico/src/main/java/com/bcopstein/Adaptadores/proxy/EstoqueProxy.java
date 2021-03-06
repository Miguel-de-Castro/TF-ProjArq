package com.bcopstein.Adaptadores.proxy;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bcopstein.Negocio.entidades.ItemCarrinho;
import com.bcopstein.Negocio.servicos.IEstoqueProxy;

@FeignClient(name="estoque")
public interface EstoqueProxy extends IEstoqueProxy{
    @PostMapping("/estoque/baixaEstoque")
	public void baixaEstoque(@RequestParam final Integer codProd, @RequestParam final Integer qtdade);

	@PostMapping("/estoque/desfazerBaixaEstoque")
	public void desfazerBaixaEstoque(@RequestParam final Integer codProd, @RequestParam final Integer qtdade);

	@GetMapping("/estoque/produtos")
	public List<ItemCarrinho> listaProdutos();

	@GetMapping("/estoque/autorizacao")
	public boolean podeVender(@RequestParam final Integer codProd, @RequestParam final Integer qtdade);
}