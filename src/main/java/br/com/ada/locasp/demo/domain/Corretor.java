package br.com.ada.locasp.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity

public class Corretor {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    private String nome;
    @NotBlank
    private String creci;

    @OneToMany(mappedBy = "corretor")
    @JsonIgnoreProperties("corretor")
    private List<Apartamento> apartamentos;
}
