package com.bcopstein.Adaptadores.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.bcopstein.Aplicacao.dtos.NotaFiscalDTO;
import com.bcopstein.Aplicacao.casosDeUso.*;

import java.util.*;
@RestController
public class Controller {
	
	@Autowired
	private CadastraNotaFiscalUC cadastraNotaFiscalUC;
	
	@Autowired
	private ConsultaNotasFiscaisUC consultaNotasFiscaisUC;

	@PostMapping("/criarProdutos")
  	@CrossOrigin(origins = "*")
  	public boolean criarProdutos(@RequestBody final NotaFiscalDTO dto) {
		return cadastraNotaFiscalUC.executar(dto);
  	}

	@GetMapping("/historico")
	@CrossOrigin(origins = "*")
	public List<NotaFiscalDTO> findAll() {
		return consultaNotasFiscaisUC.executar();
	}
}
