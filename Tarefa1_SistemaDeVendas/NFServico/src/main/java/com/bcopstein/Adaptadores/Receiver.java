package com.bcopstein.Adaptadores;

import org.springframework.stereotype.Component;

import com.bcopstein.Aplicacao.dtos.NFDTO;

@Component
public class Receiver { 
  public void receiveMessage(String message) {
    NFDTO nfDto = NFDTO.fromJSon(message);
    //Recebe o objeto DTO para salvar a NF
  }
}
