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

public class Corretor {
    @Id
    @GeneratedValue
    @NotBlank
    private Long id;

    @NotBlank
    private String nome;
    @NotBlank
    private String creci;

    //Lista apartamentos

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Corretor that = (Corretor) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }
}
