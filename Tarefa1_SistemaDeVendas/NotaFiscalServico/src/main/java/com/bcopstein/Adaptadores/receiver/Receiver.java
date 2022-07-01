package com.bcopstein.Adaptadores.receiver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bcopstein.Aplicacao.dtos.NotaFiscalDTO;
import com.bcopstein.Negocio.servicos.NotaFiscalService;

@Component
public class Receiver { 

  @Autowired
  private NotaFiscalService notaFiscalService;

  public void receiveMessage(String message) {
    String[] messageVet = message.split(";");
    NotaFiscalDTO dto = new NotaFiscalDTO(Integer.parseInt(messageVet[0]),Integer.parseInt(messageVet[1]),Integer.parseInt(messageVet[2]),Integer.parseInt(messageVet[3]));
    notaFiscalService.cadastraNF(dto);
    System.out.println("Nota Fiscal ->" + message);
  }
}
