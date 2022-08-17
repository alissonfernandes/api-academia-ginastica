package br.com.alissonfernandes.academiabackend.mapper;

import br.com.alissonfernandes.academiabackend.dto.AvaliacaoFisicaDTO;
import br.com.alissonfernandes.academiabackend.model.AvaliacaoFisica;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AvaliacaoFisicaMapper {

    AvaliacaoFisicaMapper INSTANCE = Mappers.getMapper(AvaliacaoFisicaMapper.class);

    @Mapping(target = "dataAvaliacao", source = "dataAvaliacao", dateFormat = "dd-MM-yyyy")
    AvaliacaoFisica toModel(AvaliacaoFisicaDTO avaliacaoFisicaDTO);

    @Mapping(target = "dataAvaliacao", source = "dataAvaliacao", dateFormat = "dd-MM-yyyy")
    AvaliacaoFisicaDTO toDTO(AvaliacaoFisica avaliacaoFisica);
}
