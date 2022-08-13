package br.com.alissonfernandes.academiabackend.service;

import br.com.alissonfernandes.academiabackend.dto.MatriculaDTO;

import java.util.List;

public interface IMatriculaService {

    MatriculaDTO create(MatriculaDTO matriculaDTO);
    MatriculaDTO get(Long id);
    List<MatriculaDTO> getAll();
    void delete(Long id);
}
