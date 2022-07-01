package com.bcopstein.Adaptadores.receiver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bcopstein.Aplicacao.dtos.NotaFiscalDTO;
import com.bcopstein.Negocio.servicos.NotaFiscalService;

@Component
public class Receiver { 

  @Autowired
  private NotaFiscalService notaFiscalService;
  
  public static int count = 0;
  
  public void receiveMessage(String message) {
    String[] messageVet = message.split(";");
    NotaFiscalDTO dto = new NotaFiscalDTO(count,Integer.parseInt(messageVet[0]),Integer.parseInt(messageVet[1]),Integer.parseInt(messageVet[2]));
    count++;
    notaFiscalService.cadastraNotaFiscal(dto);
    System.out.println("Nota Fiscal -> " + message);
  }
}
