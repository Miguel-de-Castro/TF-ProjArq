package com.bcopstein.Negocio.repositorios;

import java.util.List;

import com.bcopstein.Aplicacao.dtos.NFDTO;

public interface INFRepository {
    List<NFDTO> todos();

    boolean cadastra(NFDTO NFDTO);
}
