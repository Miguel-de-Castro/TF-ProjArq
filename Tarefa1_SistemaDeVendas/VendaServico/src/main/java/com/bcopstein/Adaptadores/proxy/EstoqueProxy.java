package com.bcopstein.Adaptadores.proxy;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import com.bcopstein.Negocio.entidades.Produto;

@FeignClient(name="estoque")
public interface EstoqueProxy{
    @GetMapping("/estoque/desfazerBaixaEstoque")
	public void baixaEstoque();

	@GetMapping("/estoque/desfazerBaixaEstoque")
	public void desfazerBaixaEstoque();

	@GetMapping("/estoque/produtos")
	public List<Produto> listaProdutos();
}