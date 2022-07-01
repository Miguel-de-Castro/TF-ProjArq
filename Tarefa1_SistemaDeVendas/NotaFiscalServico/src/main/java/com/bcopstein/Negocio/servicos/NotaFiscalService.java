package com.bcopstein.Negocio.servicos;

import java.util.List;

import com.bcopstein.Negocio.repositorios.INotaFiscalRepository;
import com.bcopstein.Aplicacao.dtos.NotaFiscalDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotaFiscalService {
  private INotaFiscalRepository nfRepository;

  @Autowired
  public NotaFiscalService(INotaFiscalRepository nfRepository) {
    this.nfRepository = nfRepository;
  }

  public boolean cadastraNF(NotaFiscalDTO nf) {
    nfRepository.cadastra(nf);
    return true;
  }

  public List<NotaFiscalDTO> todos() {
    return nfRepository.todos();
  }
}
