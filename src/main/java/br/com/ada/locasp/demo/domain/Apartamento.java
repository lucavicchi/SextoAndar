package br.com.ada.locasp.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
public class Apartamento {

    private Long id;
    private String numero;
    private String quarto;
    private String banheiro;
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
