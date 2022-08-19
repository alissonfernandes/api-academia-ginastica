package br.com.alissonfernandes.academiabackend.service.impl;

import br.com.alissonfernandes.academiabackend.builder.AvaliacaoFisicaDTOBuilder;
import br.com.alissonfernandes.academiabackend.dto.AvaliacaoFisicaDTO;
import br.com.alissonfernandes.academiabackend.mapper.AvaliacaoFisicaMapper;
import br.com.alissonfernandes.academiabackend.mapper.impl.AvaliacaoFisicaMapperImpl;
import br.com.alissonfernandes.academiabackend.model.AvaliacaoFisica;
import br.com.alissonfernandes.academiabackend.repository.AvaliacaoFisicaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.empty;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AvaliacaoFisicaImplTest {

    @Mock
    private AvaliacaoFisicaRepository avaliacaoFisicaRepository;

    @InjectMocks
    private AvaliacaoFisicaServiceImpl avaliacaoFisicaService;

    AvaliacaoFisicaMapper avaliacaoFisicaMapper = new AvaliacaoFisicaMapperImpl();

    @Test
    void avaliacaoCreate() {
        AvaliacaoFisicaDTO avDTO = AvaliacaoFisicaDTOBuilder.builder().build().toAvaliacaoFisicaDTO();
        AvaliacaoFisica avModel = avaliacaoFisicaMapper.toModel(avDTO);

        when(avaliacaoFisicaRepository.save(avModel)).thenReturn(avModel);

        AvaliacaoFisicaDTO createdAvDTO = avaliacaoFisicaService.create(avDTO);
        assertThat(createdAvDTO.getId(), is(equalTo(avDTO.getId())));
        assertThat(createdAvDTO.getAltura(), is(equalTo(avDTO.getAltura())));

    }

    @Test
    void avaliacaoAll() {
        AvaliacaoFisicaDTO avDTO = AvaliacaoFisicaDTOBuilder.builder().build().toAvaliacaoFisicaDTO();
        AvaliacaoFisica avModel = avaliacaoFisicaMapper.toModel(avDTO);

        when(avaliacaoFisicaRepository.findAll()).thenReturn(Collections.singletonList(avModel));

        List<AvaliacaoFisicaDTO> avDTOList = avaliacaoFisicaService.getAll();
        assertThat(avDTOList, is(not(empty())));
        assertThat(avDTOList.get(0), is(equalTo(avDTO)));
    }
}
