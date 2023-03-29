package br.com.ada.locasp.demo.repository;

import br.com.ada.locasp.demo.domain.Corretor;
import org.springframework.data.repository.CrudRepository;

public interface CorretorRepository extends CrudRepository <Corretor, Long> {
}
