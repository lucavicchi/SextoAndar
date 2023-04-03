package br.com.ada.locasp.demo.repository;

import br.com.ada.locasp.demo.domain.Apartamento;
import br.com.ada.locasp.demo.domain.Predio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PredioRepository extends CrudRepository<Predio, Long> {
}