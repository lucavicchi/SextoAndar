package br.com.ada.locasp.demo.exceptions;

public class PredioNotFoundException extends RuntimeException {
    public PredioNotFoundException() {
        super("Prédio não encontrado!");
    }
}
