package br.com.ada.locasp.demo.controller;

import br.com.ada.locasp.demo.domain.Endereco;
import br.com.ada.locasp.demo.domain.Predio;
import br.com.ada.locasp.demo.dto.PredioListDTO;
import br.com.ada.locasp.demo.mapper.PredioMapper;
import br.com.ada.locasp.demo.service.PredioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("predio")
@RestController
public class PredioController {

    private final PredioService predioService;
    private final PredioMapper predioMapper;

    @GetMapping
    public List<Predio> list() {

        return predioService.list();
    }

    @GetMapping("{id}")
    public Predio getById(@PathVariable Long id) {
        return predioService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Predio save(@Valid @RequestBody PredioListDTO dto) {
        Predio predio = predioMapper.predioSaveDTOToPredio(dto);
        var endereco = new Endereco();
        predio.setEndereco(endereco);
        return predioService.save(predio);
    }

    @PutMapping("{id}")
    public Predio update(@PathVariable Long id, @RequestBody PredioListDTO dto) {
        Predio predio = Predio.builder()
                .numero(dto.getNumero())
                .build();
        return predioService.update(id, predio);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        predioService.delete(id);
    }
}
