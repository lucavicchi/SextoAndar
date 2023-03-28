package br.com.ada.locasp.demo.dto;

import br.com.ada.locasp.demo.domain.ApartamentoStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ApartamentoSaveDTO {
    @NotBlank(message = "Número é um campo obrigatorio!")
    private String numero;

    @NotNull
    private ApartamentoStatus status;
}
