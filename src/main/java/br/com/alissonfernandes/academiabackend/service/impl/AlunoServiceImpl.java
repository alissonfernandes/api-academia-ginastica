package br.com.alissonfernandes.academiabackend.service.impl;

import br.com.alissonfernandes.academiabackend.dto.AlunoDTO;
import br.com.alissonfernandes.academiabackend.mapper.AlunoMapper;
import br.com.alissonfernandes.academiabackend.model.Aluno;
import br.com.alissonfernandes.academiabackend.repository.AlunoRepository;
import br.com.alissonfernandes.academiabackend.service.IAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlunoServiceImpl implements IAlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    private final AlunoMapper alunoMapper = AlunoMapper.INSTANCE;

    @Override
    public AlunoDTO create(AlunoDTO alunoDTO) {
        Aluno alunoToSave = alunoMapper.toModel(alunoDTO);
        Aluno alunoSaved = alunoRepository.save(alunoToSave);
        return alunoMapper.toDTO(alunoSaved);
    }

    @Override
    public AlunoDTO get(Long id) {
        Aluno aluno = alunoRepository.getReferenceById(id);
        return alunoMapper.toDTO(aluno);
    }

    @Override
    public List<AlunoDTO> getAll() {
        List<Aluno> alunoAll = alunoRepository.findAll();
        return alunoAll.stream()
                .map(aluno -> alunoMapper.toDTO(aluno))
                .collect(Collectors.toList());
    }

    @Override
    public AlunoDTO update(Long id, AlunoDTO alunoDTO) {
        Aluno alunoToSave = alunoMapper.toModel(alunoDTO);
        Aluno alunoSaved = alunoRepository.save(alunoToSave);
        return alunoMapper.toDTO(alunoSaved);
    }

    @Override
    public void delete(Long id) {
        alunoRepository.deleteById(id);
    }
}
