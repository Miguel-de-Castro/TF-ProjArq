package com.bcopstein.Aplicacao.casosDeUso;

import java.util.ArrayList;
import java.util.List;

import com.bcopstein.Negocio.servicos.NotaFiscalService;
import com.bcopstein.Aplicacao.dtos.NotaFiscalDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CadastraNotaFiscalUC {
  private NotaFiscalService nfService;

  @Autowired
  public CadastraNotaFiscalUC(NotaFiscalService nfService) {
    this.nfService = nfService;
  }

  public boolean executar(NotaFiscalDTO dto) {
    return nfService.cadastraNotaFiscal(dto);
  }
}
