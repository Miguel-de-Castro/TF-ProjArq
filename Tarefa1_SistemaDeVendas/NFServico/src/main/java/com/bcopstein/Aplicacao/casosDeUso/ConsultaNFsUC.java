package com.bcopstein.Aplicacao.casosDeUso;

import java.util.List;

import com.bcopstein.Negocio.servicos.NFService;
import com.bcopstein.Aplicacao.dtos.NFDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConsultaNFsUC {
    private NFService nfService

  @Autowired
  public ConsultaNFsUC(NFService nfService) {
    this.nfService = nfService;
  }

  public List<NFDTO> executar() {
    return nfService.todos();
  }
}
