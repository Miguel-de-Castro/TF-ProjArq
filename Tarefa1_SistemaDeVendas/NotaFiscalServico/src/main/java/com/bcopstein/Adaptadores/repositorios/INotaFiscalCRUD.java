package com.bcopstein.Adaptadores.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bcopstein.Aplicacao.dtos.NotaFiscalDTO;

public interface INotaFiscalCRUD extends CrudRepository<NotaFiscalDTO, Integer> {
    public List<NotaFiscalDTO> findAll();
}
