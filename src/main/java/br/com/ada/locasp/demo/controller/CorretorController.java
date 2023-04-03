package br.com.ada.locasp.demo.controller;

import br.com.ada.locasp.demo.domain.Corretor;
import br.com.ada.locasp.demo.dto.CorretorSaveDTO;
import br.com.ada.locasp.demo.service.CorretorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("corretor")
@RestController
public class CorretorController {

    private final CorretorService corretorService;

    @GetMapping
    public List<Corretor> list() {
        return corretorService.list();
    }

    @GetMapping("{id}")
    public Corretor getById(@PathVariable Long id) {
        return corretorService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Corretor save(@Valid @RequestBody CorretorSaveDTO dto) {
        Corretor corretor = Corretor.builder()
                .nome(dto.getNome())
                .creci(dto.getCreci())
                .build();
        return corretorService.save(corretor);
    }

    @PutMapping("{id}")
    public Corretor update(@PathVariable Long id, @RequestBody CorretorSaveDTO dto) {
        Corretor corretor = Corretor.builder()
                .nome(dto.getNome())
                .creci(dto.getCreci())
                .build();
        return corretorService.update(id, corretor);
    }

    @DeleteMapping("{id}")
    public void delete (@PathVariable Long id) {
        corretorService.delete(id);
    }
}
