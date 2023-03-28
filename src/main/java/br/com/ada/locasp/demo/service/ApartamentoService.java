package br.com.ada.locasp.demo.service;

import br.com.ada.locasp.demo.domain.Apartamento;

import java.util.List;

public interface ApartamentoService {

    public List<Apartamento> list();
    Apartamento save (Apartamento apartamento);
    Apartamento findById(Long id);
    Apartamento update(Long id, Apartamento apartamento);
    void delete(Long id);
}
