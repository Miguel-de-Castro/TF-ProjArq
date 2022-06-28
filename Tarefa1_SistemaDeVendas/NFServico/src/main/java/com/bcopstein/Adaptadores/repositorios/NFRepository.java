package com.bcopstein.Adaptadores.repositorios;

import com.bcopstein.Negocio.repositorios.INFRepository;
import com.bcopstein.Aplicacao.dtos.NFDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NFRepository implements INFRepository {
    INFCRUD nfCRUD;

    @Autowired
    public NFRepository(INFCRUD nfCRUD) {
        this.nfCRUD = nfCRUD;
    }

    @Override
    public List<Venda> todos() {
        return nfCRUD.findAll();
    }

    @Override
    public boolean cadastra(NFDTO nf) {
        nfCRUD.save(nf);
        return true;
    }

}
