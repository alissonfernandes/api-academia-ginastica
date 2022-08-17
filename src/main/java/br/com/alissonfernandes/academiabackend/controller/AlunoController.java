package br.com.alissonfernandes.academiabackend.controller;

import br.com.alissonfernandes.academiabackend.dto.AlunoDTO;
import br.com.alissonfernandes.academiabackend.service.impl.AlunoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/aluno")
public class AlunoController {

    @Autowired
    private AlunoServiceImpl alunoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AlunoDTO create(@RequestBody AlunoDTO alunoDTO) {
        return alunoService.create(alunoDTO);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public List<AlunoDTO> getAll() {
        return alunoService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public AlunoDTO get(@PathVariable Long id) {
        return alunoService.get(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AlunoDTO update(@PathVariable Long id, @RequestBody AlunoDTO alunoDTO) {
        return alunoService.update(id, alunoDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        alunoService.delete(id);
    }

}
