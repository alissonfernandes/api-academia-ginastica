package br.com.alissonfernandes.academiabackend.service.impl;

import br.com.alissonfernandes.academiabackend.dto.AvaliacaoFisicaDTO;
import br.com.alissonfernandes.academiabackend.mapper.AvaliacaoFisicaMapper;
import br.com.alissonfernandes.academiabackend.mapper.impl.AvaliacaoFisicaMapperImpl;
import br.com.alissonfernandes.academiabackend.model.AvaliacaoFisica;
import br.com.alissonfernandes.academiabackend.repository.AvaliacaoFisicaRepository;
import br.com.alissonfernandes.academiabackend.service.IAvaliacaoFisicaService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class AvaliacaoFisicaServiceImpl implements IAvaliacaoFisicaService {

    @Autowired
    AvaliacaoFisicaRepository avaliacaoFisicaRepository;

    private final AvaliacaoFisicaMapper avaliacaoFisicaMapper = new AvaliacaoFisicaMapperImpl();

    @Override
    public AvaliacaoFisicaDTO create(AvaliacaoFisicaDTO avaliacaoFisicaDTO) {
        AvaliacaoFisica avToSave = avaliacaoFisicaMapper.toModel(avaliacaoFisicaDTO);
        AvaliacaoFisica avSaved = avaliacaoFisicaRepository.save(avToSave);
        return avaliacaoFisicaMapper.toDTO(avSaved);
    }

    @Override
    public AvaliacaoFisicaDTO get(Long id) {
        AvaliacaoFisica avReturned = avaliacaoFisicaRepository.getReferenceById(id);
        return avaliacaoFisicaMapper.toDTO(avReturned);
    }

    @Override
    public List<AvaliacaoFisicaDTO> getAll() {
      List<AvaliacaoFisica> avAll = avaliacaoFisicaRepository.findAll();
      return avAll.stream()
              .map(av -> avaliacaoFisicaMapper.toDTO(av))
              .collect(Collectors.toList());
    }

    @Override
    public AvaliacaoFisicaDTO update(Long id, AvaliacaoFisicaDTO avaliacaoFisicaDTO) {
        AvaliacaoFisica avToSave = avaliacaoFisicaMapper.toModel(avaliacaoFisicaDTO);
        AvaliacaoFisica avSaved = avaliacaoFisicaRepository.save(avToSave);
        return avaliacaoFisicaMapper.toDTO(avSaved);
    }

    @Override
    public void delete(Long id) {
        avaliacaoFisicaRepository.deleteById(id);
    }
}
