package br.com.ada.locasp.demo.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Apartamento {
    @Id
    @GeneratedValue
    @NotBlank
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String numero;

    private String quarto;

    private String banheiro;

    @Enumerated(EnumType.STRING)
    private ApartamentoStatus status;

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Apartamento that = (Apartamento) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }
}
