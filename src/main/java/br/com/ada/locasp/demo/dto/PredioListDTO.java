package br.com.ada.locasp.demo.dto;

import br.com.ada.locasp.demo.domain.Endereco;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class PredioListDTO {

    private Long id;
    private Endereco endereco;
}
