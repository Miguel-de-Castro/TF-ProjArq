package com.bcopstein.Aplicacao.casosDeUso;

import java.util.ArrayList;
import java.util.List;

import com.bcopstein.Negocio.servicos.NFService;
import com.bcopstein.Aplicacao.dtos.NotaFiscalDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CadastraNotaFiscalUC {
  private NFService nfService;

  @Autowired
  public CadastraNotaFiscalUC(NFService nfService) {
    this.nfService = nfService;
  }

  public Integer executar(NotaFiscalDTO dto) {
    return nfService.cadastraNF(dto);
  }
}
