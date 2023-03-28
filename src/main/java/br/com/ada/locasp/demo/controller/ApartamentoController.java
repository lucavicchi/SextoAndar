package br.com.ada.locasp.demo.controller;

import br.com.ada.locasp.demo.domain.Apartamento;
import br.com.ada.locasp.demo.dto.ApartamentoSaveDTO;
import br.com.ada.locasp.demo.service.ApartamentoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("apartamento")
@RestController
public class ApartamentoController {

    private final ApartamentoService apartamentoService;

    @GetMapping
    public List<Apartamento> list() {
        return apartamentoService.list();
    }

    @GetMapping("{id}")
    public Apartamento getById(@PathVariable Long id) {
        return apartamentoService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Apartamento save(@Valid @RequestBody ApartamentoSaveDTO dto) {
        Apartamento apartamento = Apartamento.builder()
                .numero(dto.getNumero())
                .status(dto.getStatus())
                .build();
        return apartamentoService.save(apartamento);
    }
        //TODO entender erros e corrigir
        @PutMapping("{id}")
        public Apartamento update(@PathVariable Long id, @RequestBody ApartamentoSaveDTO dto){
            Apartamento apartamento = Apartamento.builder()
                    .numero(dto.getNumero())
                    .status(dto.getStatus())
                    .build();
            return apartamentoService.update(id, apartamento);
        }

        //TODO entender erros e corrigir
        @DeleteMapping("{id}")
        public void delete(@PathVariable Long id){
            apartamentoService.delete(id);
        }
    }
}