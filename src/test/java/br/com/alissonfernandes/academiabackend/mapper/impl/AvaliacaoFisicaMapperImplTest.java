package br.com.alissonfernandes.academiabackend.mapper.impl;


import br.com.alissonfernandes.academiabackend.builder.AvaliacaoFisicaDTOBuilder;
import br.com.alissonfernandes.academiabackend.dto.AvaliacaoFisicaDTO;
import br.com.alissonfernandes.academiabackend.mapper.AvaliacaoFisicaMapper;
import br.com.alissonfernandes.academiabackend.model.AvaliacaoFisica;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AvaliacaoFisicaMapperImplTest {

    private AvaliacaoFisicaMapper avaliacaoFisicaMapper = new AvaliacaoFisicaMapperImpl();

    @Test
    public void testModelToDTO() {
        AvaliacaoFisicaDTO avaliacaoFisicaDTO = AvaliacaoFisicaDTOBuilder.builder().build().toAvaliacaoFisicaDTO();
        AvaliacaoFisica avaliacaoFisica = avaliacaoFisicaMapper.toModel(avaliacaoFisicaDTO);

        assertEquals(avaliacaoFisicaDTO.getId(), avaliacaoFisica.getId());
        assertEquals(avaliacaoFisicaDTO.getPeso(), avaliacaoFisica.getPeso());
        assertEquals(avaliacaoFisicaDTO.getAltura(), avaliacaoFisica.getAltura());
        assertEquals(avaliacaoFisicaDTO.getDataAvaliacao(), DateTimeFormatter.ofPattern("dd-MM-yyyy").format(avaliacaoFisica.getDataAvaliacao()));
    }

    @Test
    public void testDTOToModel() {
        AvaliacaoFisicaDTO avaliacaoFisicaDTO = AvaliacaoFisicaDTOBuilder.builder().build().toAvaliacaoFisicaDTO();

        AvaliacaoFisica avaliacaoFisica = avaliacaoFisicaMapper.toModel(avaliacaoFisicaDTO);

        assertEquals(avaliacaoFisica.getId(), avaliacaoFisicaDTO.getId());
        assertEquals(avaliacaoFisica.getPeso(), avaliacaoFisicaDTO.getPeso());
        assertEquals(avaliacaoFisica.getAltura(), avaliacaoFisicaDTO.getAltura());
        assertEquals(avaliacaoFisica.getDataAvaliacao(), LocalDate.parse(avaliacaoFisicaDTO.getDataAvaliacao(), DateTimeFormatter.ofPattern("dd-MM-yyyy")));
    }
}
