package br.com.ada.locasp.demo.service;

import br.com.ada.locasp.demo.domain.Predio;

import java.util.List;

public interface PredioService {
    public List<Predio> list();
    Predio save (Predio predio);
    Predio findById(Long id);
    Predio update(Long id, Predio predio);
    void delete(Long id);
}
