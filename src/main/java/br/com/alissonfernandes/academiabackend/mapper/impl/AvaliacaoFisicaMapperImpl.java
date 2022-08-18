package br.com.alissonfernandes.academiabackend.mapper.impl;

import br.com.alissonfernandes.academiabackend.dto.AvaliacaoFisicaDTO;
import br.com.alissonfernandes.academiabackend.mapper.AlunoMapper;
import br.com.alissonfernandes.academiabackend.mapper.AvaliacaoFisicaMapper;
import br.com.alissonfernandes.academiabackend.model.AvaliacaoFisica;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AvaliacaoFisicaMapperImpl implements AvaliacaoFisicaMapper {

    private final AlunoMapper alunoMapper = AlunoMapper.INSTANCE;

    @Override
    public AvaliacaoFisica toModel(AvaliacaoFisicaDTO avaliacaoFisicaDTO) {

        if (avaliacaoFisicaDTO == null) return null;

        AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();

        if (avaliacaoFisicaDTO.getDataAvaliacao() != null) avaliacaoFisica.setDataAvaliacao(LocalDate.parse(avaliacaoFisicaDTO.getDataAvaliacao(), DateTimeFormatter.ofPattern("dd-MM-yyyy")));

        avaliacaoFisica.setId(avaliacaoFisicaDTO.getId());
        avaliacaoFisica.setAltura(avaliacaoFisicaDTO.getAltura());
        avaliacaoFisica.setPeso(avaliacaoFisicaDTO.getPeso());
        avaliacaoFisica.setAluno(alunoMapper.toModel(avaliacaoFisicaDTO.getAluno()));
        return avaliacaoFisica;
    }

    @Override
    public AvaliacaoFisicaDTO toDTO(AvaliacaoFisica avaliacaoFisica) {

        if (avaliacaoFisica == null) return null;

        AvaliacaoFisicaDTO avaliacaoFisicaDTO = new AvaliacaoFisicaDTO();

        if (avaliacaoFisica.getDataAvaliacao() != null) avaliacaoFisicaDTO.setDataAvaliacao(DateTimeFormatter.ofPattern("dd-MM-yyyy").format(avaliacaoFisica.getDataAvaliacao()));

        avaliacaoFisicaDTO.setId(avaliacaoFisica.getId());
        avaliacaoFisicaDTO.setAltura(avaliacaoFisica.getAltura());
        avaliacaoFisicaDTO.setPeso(avaliacaoFisica.getPeso());
        avaliacaoFisicaDTO.setAluno(alunoMapper.toDTO(avaliacaoFisica.getAluno()));

        return avaliacaoFisicaDTO;
    }
}
