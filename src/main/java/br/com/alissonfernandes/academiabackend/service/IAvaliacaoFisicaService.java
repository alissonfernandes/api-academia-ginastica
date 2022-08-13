package br.com.alissonfernandes.academiabackend.service;

import br.com.alissonfernandes.academiabackend.dto.AvaliacaoFisicaDTO;

import java.util.List;

public interface IAvaliacaoFisicaService {

    AvaliacaoFisicaDTO create(AvaliacaoFisicaDTO avaliacaoFisicaDTO);
    AvaliacaoFisicaDTO get(Long id);
    List<AvaliacaoFisicaDTO> getAll();
    AvaliacaoFisicaDTO update(Long id, AvaliacaoFisicaDTO avaliacaoFisicaDTO);
    void delete(Long id);
}
