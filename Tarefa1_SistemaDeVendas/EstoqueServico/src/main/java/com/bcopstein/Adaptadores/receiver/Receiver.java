package com.bcopstein.Adaptadores.receiver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bcopstein.Negocio.servicos.ProdutoService;

@Component
public class Receiver { 
  
  @Autowired
  private ProdutoService servicoProduto;
  
  public void receiveMessage(String message) {
    String[] messageVet = message.split(";");
    servicoProduto.criar(Integer.parseInt(messageVet[0]), messageVet[1], Double.parseDouble(messageVet[2]));
    //HistoryDTO hDto = HistoryDTO.fromJSon(message);
    System.out.println("Produto -> " + message);
  }
}
