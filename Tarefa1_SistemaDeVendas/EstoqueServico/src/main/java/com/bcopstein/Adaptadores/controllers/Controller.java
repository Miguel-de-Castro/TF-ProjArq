package com.bcopstein.Adaptadores.controllers;

import java.util.List;

import com.bcopstein.Aplicacao.casosDeUso.VerificaEstoqueProdutoUC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vendas")
public class Controller {
  @Autowired
  private VerificaEstoqueProdutoUC verificaEstoqueProduto;

  public Controller(){}
}
