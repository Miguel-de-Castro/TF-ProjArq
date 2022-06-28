package com.bcopstein.Negocio.servicos;

import java.util.List;

import com.bcopstein.Negocio.repositorios.INFRepository;
import com.bcopstein.Aplicacao.dtos.NFDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NFService {
  private INFRepository nfRepository;

  @Autowired
  public NFService(INFRepository nfRepository) {
    this.nfRepository = nfRepository;
  }

  public Integer cadastraNF(NFDTO nf) {
    
    nfRepository.cadastra(nf);

    return 0;
  }
  public List<NFDTO> todos() {
    return nfRepository.todos();
  }
}
