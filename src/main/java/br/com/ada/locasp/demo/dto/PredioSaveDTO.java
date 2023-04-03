package br.com.ada.locasp.demo.dto;

import br.com.ada.locasp.demo.domain.ApartamentoStatus;
import br.com.ada.locasp.demo.domain.Endereco;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PredioSaveDTO {

    @NotBlank(message = "Número é um campo obrigatorio!")
    private String numero;

    @NotBlank
    @Pattern(regexp = "[\\d]{5}-[\\d]{3}", message = "CEP invalido")
    private String cep;

    @NotBlank
    private Endereco endereco;
}
