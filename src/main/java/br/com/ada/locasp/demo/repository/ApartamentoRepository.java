package br.com.ada.locasp.demo.repository;

import br.com.ada.locasp.demo.domain.Apartamento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApartamentoRepository extends CrudRepository<Apartamento, Long> {
}