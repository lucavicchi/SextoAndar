package br.com.ada.locasp.demo.mapper;

import br.com.ada.locasp.demo.domain.Apartamento;
import br.com.ada.locasp.demo.dto.ApartamentoSaveDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ApartamentoMapper {

    Apartamento apartamentoSaveDTOToApartamento(ApartamentoSaveDTO dto);
}
