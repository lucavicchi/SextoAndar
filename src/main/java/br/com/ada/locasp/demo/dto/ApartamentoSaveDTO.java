package br.com.ada.locasp.demo.dto;

import br.com.ada.locasp.demo.domain.ApartamentoStatus;
import br.com.ada.locasp.demo.domain.Corretor;
import br.com.ada.locasp.demo.domain.Predio;
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

    @NotBlank
    private String banheiro;

    @NotBlank
    private String quarto;

    private Long predioId;

    private Long corretorId;
}
