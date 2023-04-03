package br.com.ada.locasp.demo.config;

import br.com.ada.locasp.demo.dto.ErrorDTO;
import br.com.ada.locasp.demo.exceptions.ApartamentoNotFoundException;
import br.com.ada.locasp.demo.exceptions.CorretorNotFoundException;
import br.com.ada.locasp.demo.exceptions.PredioNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

public class HandlerException {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({ApartamentoNotFoundException.class, PredioNotFoundException.class, CorretorNotFoundException.class})
    public ErrorDTO handlerApartamentoNotFound(ApartamentoNotFoundException ex) {
        return ErrorDTO.builder().message(ex.getMessage()).build();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(CorretorNotFoundException.class)
    public ErrorDTO handlerCorretorNotFound(CorretorNotFoundException ex) {
        return ErrorDTO.builder().message(ex.getMessage()).build();
    }
}