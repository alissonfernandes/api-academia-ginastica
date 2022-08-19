package br.com.alissonfernandes.academiabackend.controller;

import br.com.alissonfernandes.academiabackend.dto.AvaliacaoFisicaDTO;
import br.com.alissonfernandes.academiabackend.service.impl.AvaliacaoFisicaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/avaliacoesfisicas")
public class AvaliacaoFisicaController {

    @Autowired
    private AvaliacaoFisicaServiceImpl avaliacaoFisicaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AvaliacaoFisicaDTO create(@RequestBody AvaliacaoFisicaDTO avDTO) {
        return  avaliacaoFisicaService.create(avDTO);
    }
}
