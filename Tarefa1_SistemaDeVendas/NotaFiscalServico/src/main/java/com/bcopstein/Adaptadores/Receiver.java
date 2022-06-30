package com.bcopstein.Adaptadores;

import org.springframework.stereotype.Component;

import com.bcopstein.Aplicacao.dtos.NotaFiscalDTO;

@Component
public class Receiver { 
  public void receiveMessage(String message) {
    NotaFiscalDTO nfDto = NotaFiscalDTO.fromJSon(message);
    //Recebe o objeto DTO para salvar a NF
  }
}
