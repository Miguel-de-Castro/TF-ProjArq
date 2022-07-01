package com.bcopstein.Negocio.repositorios;

import java.util.List;

import com.bcopstein.Aplicacao.dtos.NotaFiscalDTO;

public interface INotaFiscalRepository {
    List<NotaFiscalDTO> todos();

    boolean cadastra(NotaFiscalDTO NFDTO);
}
