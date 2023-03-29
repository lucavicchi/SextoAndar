package br.com.ada.locasp.demo.service;

import br.com.ada.locasp.demo.domain.Corretor;
import br.com.ada.locasp.demo.exceptions.CorretorNotFoundException;
import br.com.ada.locasp.demo.repository.CorretorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class CorretorServiceImpl implements CorretorService {

    private final CorretorRepository repository;

    @Override
    public List<Corretor> list() {
        return (List<Corretor>) repository.findAll();
    }

    @Override
    public Corretor save(Corretor corretor) {
        return repository.save(corretor);
    }

    @Override
    public Corretor findById(Long id) {
        return repository.findById(id).orElseThrow(CorretorNotFoundException::new);
    }

    @Override
    public Corretor update(Long id, Corretor corretor) {
        if(repository.existsById(id)){
            corretor.setId(id);
            return repository.save(corretor);
        }
        throw new CorretorNotFoundException();
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)){
            throw new CorretorNotFoundException();
        }
        repository.deleteById(id);
    }
}
