package com.bcopstein.Adaptadores.proxy;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.bcopstein.Negocio.servicos.IEstoqueProxy;

@FeignClient(name="estoque")
public interface EstoqueProxy{
     @GetMapping("/desfazerBaixaEstoque")
	public void baixaEstoque();

	@GetMapping("/desfazerBaixaEstoque")
	public void desfazerBaixaEstoque();

}
