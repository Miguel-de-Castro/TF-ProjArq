package com.bcopstein.Negocio.servicos;

import java.util.List;

import com.bcopstein.Negocio.repositorios.INotaFiscalRepository;
import com.bcopstein.Aplicacao.dtos.NotaFiscalDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotaFiscalService {
  @Autowired
  private INotaFiscalRepository nfRepository;

  public NotaFiscalService(INotaFiscalRepository nfRepository) {
    this.nfRepository = nfRepository;
  }

  public boolean cadastraNotaFiscal(NotaFiscalDTO nf) {
    nfRepository.cadastra(nf);
    return true;
  }

  public List<NotaFiscalDTO> todos() {
    return nfRepository.todos();
  }
}
