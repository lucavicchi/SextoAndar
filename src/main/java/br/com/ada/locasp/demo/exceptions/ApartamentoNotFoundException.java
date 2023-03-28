package br.com.ada.locasp.demo.exceptions;

import br.com.ada.locasp.demo.domain.Apartamento;

public class ApartamentoNotFoundException extends RuntimeException {
    public ApartamentoNotFoundException() {
        super("Apartamento não encontrado!");
    }
}
