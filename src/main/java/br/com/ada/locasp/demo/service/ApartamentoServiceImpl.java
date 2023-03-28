package br.com.ada.locasp.demo.service;

import br.com.ada.locasp.demo.domain.Apartamento;
import br.com.ada.locasp.demo.exceptions.ApartamentoNotFoundException;
import br.com.ada.locasp.demo.repository.ApartamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ApartamentoServiceImpl implements ApartamentoService {

    private final ApartamentoRepository repository;
    public List<Apartamento> list() {
        return (List<Apartamento>) repository.findAll();
    }

    @Override
    public Apartamento save(Apartamento apartamento) {
        return repository.save(apartamento);
    }

    @Override
    public Apartamento findById(Long id){
        return repository.findById(id).orElseThrow(ApartamentoNotFoundException::new);
    }

    @Override
    public Apartamento update(Long id, Apartamento apartamento){
        if (repository.existsById(id)) {
            apartamento.setId(id);
            return repository.save(apartamento);
        }
        throw new ApartamentoNotFoundException();
    }

    @Override
    public void delete(Long id){
        if (!repository.existsById(id)) {
            throw new ApartamentoNotFoundException();
        }
        repository.deleteById(id);
    }
}