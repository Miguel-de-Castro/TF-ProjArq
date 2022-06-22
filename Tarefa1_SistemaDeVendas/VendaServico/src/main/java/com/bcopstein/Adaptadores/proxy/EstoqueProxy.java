package com.bcopstein.Adaptadores.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name="estoque")
public interface EstoqueProxy {
	// duas chamadas uma para ver se tem o produto lá e outra para retirar o produto lá do estoque


	@GetMapping("/autorizacao")
	@CrossOrigin(origins = "*")
	public boolean podeVender(@RequestParam final Integer codProd, @RequestParam final Integer qtdade) {
		return verificaEstoqueProduto.executar(codProd, qtdade);
	}

}