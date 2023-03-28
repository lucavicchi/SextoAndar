package br.com.ada.locasp.demo.service;

import br.com.ada.locasp.demo.domain.Apartamento;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApartamentoServiceImpl implements ApartamentoService {

    private List<Apartamento> apartamentos = new ArrayList<>();

    public List<Apartamento> list(){
        return apartamentos;
    }

    @Override
    public Apartamento save(Apartamento apartamento) {
        apartamento.setId((long) apartamentos.size());
        apartamentos.add(apartamento);
        return apartamento;
    }

    @Override
    public Apartamento findById(Long id){
        return apartamentos.stream().filter(apartamento -> apartamento.getId() == id).findFirst().get();
    }

    @Override
    public Apartamento update(Long id, Apartamento apartamento){
        apartamento.setId(id);
        int index = apartamentos.indexOf(apartamento);
        apartamentos.set(index, apartamento);
        return apartamento;
    }

    @Override
    public void delete(Long id){
        apartamentos.removeIf(apartamento -> apartamento.getId() == id);
    }
}