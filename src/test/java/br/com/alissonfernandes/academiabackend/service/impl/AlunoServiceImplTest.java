package br.com.alissonfernandes.academiabackend.service.impl;

import br.com.alissonfernandes.academiabackend.builder.AlunoDTOBuilder;
import br.com.alissonfernandes.academiabackend.dto.AlunoDTO;
import br.com.alissonfernandes.academiabackend.mapper.AlunoMapper;
import br.com.alissonfernandes.academiabackend.model.Aluno;
import br.com.alissonfernandes.academiabackend.repository.AlunoRepository;
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
public class AlunoServiceImplTest {

    @Mock
    private AlunoRepository alunoRepository;

    @InjectMocks
    private AlunoServiceImpl alunoService;

    AlunoMapper alunoMapper = AlunoMapper.INSTANCE;

    @Test
    void alunoCreate() {
        AlunoDTO alunoDTO = AlunoDTOBuilder.builder().build().toAlunoDTO();
        Aluno alunoModel = alunoMapper.toModel(alunoDTO);

        when(alunoRepository.save(alunoModel)).thenReturn(alunoModel);

        AlunoDTO createdAlunoDTO = alunoService.create(alunoDTO);
        assertThat(createdAlunoDTO.getCpf(), is(equalTo(alunoDTO.getCpf())));
        assertThat(createdAlunoDTO.getNome(), is(equalTo(alunoDTO.getNome())));
        assertThat(createdAlunoDTO.getDataNascimento(), is(equalTo(alunoDTO.getDataNascimento())));
        assertThat(createdAlunoDTO.getId(), is(equalTo(alunoDTO.getId())));
        assertThat(createdAlunoDTO.getEndereco().getCidade(), equalTo(alunoDTO.getEndereco().getCidade()));
        assertThat(createdAlunoDTO.getEndereco().getUf(), equalTo(alunoDTO.getEndereco().getUf()));
        assertThat(createdAlunoDTO.getEndereco().getBairro(), equalTo(alunoDTO.getEndereco().getBairro()));
        assertThat(createdAlunoDTO.getEndereco().getRua(), equalTo(alunoDTO.getEndereco().getRua()));
        assertThat(createdAlunoDTO.getEndereco().getNumero(), equalTo(alunoDTO.getEndereco().getNumero()));
        assertThat(createdAlunoDTO.getEndereco().getComplemento(), equalTo(alunoDTO.getEndereco().getComplemento()));
    }

    @Test
    void alunoGetAll() {
      AlunoDTO alunoDTO = AlunoDTOBuilder.builder().build().toAlunoDTO();
      Aluno aluno = alunoMapper.toModel(alunoDTO);

      when(alunoRepository.findAll()).thenReturn(Collections.singletonList(aluno));

      List<AlunoDTO> alunoDTOList = alunoService.getAll();
      assertThat(alunoDTOList, is(not(empty())));
      assertThat(alunoDTOList.get(0), is(equalTo(alunoDTO)));
    }





}
