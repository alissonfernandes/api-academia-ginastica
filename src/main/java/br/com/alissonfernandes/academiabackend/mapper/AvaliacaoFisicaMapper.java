package br.com.alissonfernandes.academiabackend.mapper;

import br.com.alissonfernandes.academiabackend.dto.AvaliacaoFisicaDTO;
import br.com.alissonfernandes.academiabackend.model.AvaliacaoFisica;

public interface AvaliacaoFisicaMapper {

    AvaliacaoFisica toModel(AvaliacaoFisicaDTO avaliacaoFisicaDTO);
    AvaliacaoFisicaDTO toDTO(AvaliacaoFisica avaliacaoFisica);

}
