package br.com.ada.locasp.demo.mapper;

import br.com.ada.locasp.demo.domain.Predio;
import br.com.ada.locasp.demo.dto.PredioListDTO;
import jakarta.validation.Valid;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PredioMapper {

    Predio predioSaveDTOToPredio(@Valid PredioListDTO dto);

    PredioListDTO predioToPredioListDTO(Predio predio);
}
