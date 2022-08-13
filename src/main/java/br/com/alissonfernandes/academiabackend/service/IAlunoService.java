package br.com.alissonfernandes.academiabackend.service;

import br.com.alissonfernandes.academiabackend.dto.AlunoDTO;

import java.util.List;

public interface IAlunoService {

    AlunoDTO create(AlunoDTO alunoDTO);
    AlunoDTO get(Long id);
    List<AlunoDTO> getAll();
    AlunoDTO update(Long id, AlunoDTO alunoDTO);
    void delete(Long id);
}
