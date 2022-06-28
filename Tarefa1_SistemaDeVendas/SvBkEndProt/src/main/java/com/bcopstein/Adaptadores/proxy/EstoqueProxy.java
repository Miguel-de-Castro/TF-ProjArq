package com.bcopstein.Adaptadores.proxy;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import com.bcopstein.Negocio.entidades.Produto;

@FeignClient(name="estoque")
public interface EstoqueProxy{
    @GetMapping("/desfazerBaixaEstoque")
	public void baixaEstoque();

	@GetMapping("/desfazerBaixaEstoque")
	public void desfazerBaixaEstoque();

	@GetMapping("/produtos")
	public List<Produto> listaProdutos();
}