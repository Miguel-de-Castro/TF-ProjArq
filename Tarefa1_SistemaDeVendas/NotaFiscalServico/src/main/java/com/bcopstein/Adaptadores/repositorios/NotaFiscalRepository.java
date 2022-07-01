package com.bcopstein.Adaptadores.repositorios;

import com.bcopstein.Negocio.repositorios.INotaFiscalRepository;
import com.bcopstein.Aplicacao.dtos.NotaFiscalDTO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotaFiscalRepository implements INotaFiscalRepository {
    @Autowired
    private INotaFiscalCRUD nfCRUD;

    public NotaFiscalRepository(INotaFiscalCRUD nfCRUD) {
        this.nfCRUD = nfCRUD;
    }

    @Override
    public List<NotaFiscalDTO> todos() {
        return nfCRUD.findAll();
    }

    @Override
    public boolean cadastra(NotaFiscalDTO notaFiscal) {
        nfCRUD.save(notaFiscal);
        return true;
    }

}
