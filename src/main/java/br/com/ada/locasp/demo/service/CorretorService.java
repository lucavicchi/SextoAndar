package br.com.ada.locasp.demo.service;

import br.com.ada.locasp.demo.domain.Corretor;

import java.util.List;

public interface CorretorService {
    public List<Corretor> list();
    Corretor save (Corretor corretor);
    Corretor findById(Long id);
    Corretor update(Long id, Corretor corretor);
    void delete(Long id);
}
