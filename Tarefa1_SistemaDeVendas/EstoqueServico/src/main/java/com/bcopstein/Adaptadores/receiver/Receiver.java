package com.bcopstein.Adaptadores.receiver;

import org.springframework.stereotype.Component;

// TODO: ficar verificando quando recebeu novos produtos para botar no estoque
@Component
public class Receiver { 
  public void receiveMessage(String message) {
    //HistoryDTO hDto = HistoryDTO.fromJSon(message);
    System.out.println("History received: "+message);
  }
}
