package com.bcopstein.Aplicacao.casosDeUso;

import java.util.List;

import com.bcopstein.Negocio.servicos.NotaFiscalService;
import com.bcopstein.Aplicacao.dtos.NotaFiscalDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConsultaNotasFiscaisUC {
  
  @Autowired
  private NotaFiscalService nfService;

  public ConsultaNotasFiscaisUC(NotaFiscalService nfService) {
    this.nfService = nfService;
  }

  public List<NotaFiscalDTO> executar() {
    return nfService.todos();
  }
}
