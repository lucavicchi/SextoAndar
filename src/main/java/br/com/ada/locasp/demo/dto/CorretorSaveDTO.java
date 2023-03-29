package br.com.ada.locasp.demo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CorretorSaveDTO {
    @NotBlank(message = "Nome é um campo obrigatório!")
    private String nome;

    @NotBlank(message = "Creci é um campo obrigatório!")
    private String creci;

}
