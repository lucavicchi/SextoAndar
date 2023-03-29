package br.com.ada.locasp.demo.exceptions;

public class CorretorNotFoundException extends RuntimeException {

    public CorretorNotFoundException(){
        super("Corretor não encontrado! Tente novamente.");
    }
}
