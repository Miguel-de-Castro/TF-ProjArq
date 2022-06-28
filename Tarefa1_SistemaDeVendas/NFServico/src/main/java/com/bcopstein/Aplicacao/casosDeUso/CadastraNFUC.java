package main.java.com.bcopstein.Aplicacao.casosDeUso;

import java.util.ArrayList;
import java.util.List;

import com.bcopstein.Negocio.servicos.NFService;
import com.bcopstein.Aplicacao.dtos.NFDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CadastraNFUC {
  private NFService nfService

  @Autowired
  public CadastraNFUC(NFService nfService) {
    this.nfService = nfService;
  }

  public Integer executar(NFDTO dto) {
    return nfService.cadastraNF(dto);
  }
}
