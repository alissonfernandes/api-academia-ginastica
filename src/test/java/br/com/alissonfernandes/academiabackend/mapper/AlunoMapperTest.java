package br.com.alissonfernandes.academiabackend.mapper;

import br.com.alissonfernandes.academiabackend.builder.AlunoDTOBuilder;
import br.com.alissonfernandes.academiabackend.dto.AlunoDTO;
import br.com.alissonfernandes.academiabackend.model.Aluno;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class AlunoMapperTest {

    private AlunoMapper alunoMapper = Mappers.getMapper(AlunoMapper.class);

    @Test
    public void testModelToDTO(){
        AlunoDTO alunoDTO = AlunoDTOBuilder.builder().build().toAlunoDTO();
        Aluno alunoModel = alunoMapper.toModel(alunoDTO);

        assertEquals(alunoDTO.getNome(), alunoModel.getNome());
        assertEquals(alunoDTO.getCpf(), alunoModel.getCpf());
        assertEquals(alunoDTO.getDataNascimento(), alunoModel.getDataNascimento());
        assertEquals(alunoDTO.getId(), alunoModel.getId());

        assertEquals(alunoDTO.getEndereco().getCidade(), alunoModel.getEndereco().getCidade());
        assertEquals(alunoDTO.getEndereco().getUf(), alunoModel.getEndereco().getUf());
        assertEquals(alunoDTO.getEndereco().getBairro(), alunoModel.getEndereco().getBairro());
        assertEquals(alunoDTO.getEndereco().getRua(), alunoModel.getEndereco().getRua());
        assertEquals(alunoDTO.getEndereco().getNumero(), alunoModel.getEndereco().getNumero());
        assertEquals(alunoDTO.getEndereco().getComplemento(), alunoModel.getEndereco().getComplemento());
        assertEquals(alunoDTO.getEndereco().getId(), alunoModel.getEndereco().getId());
    }

    @Test
    public void testDTOToModel() {
        AlunoDTO alunoDTO = AlunoDTOBuilder.builder().build().toAlunoDTO();

        Aluno alunoModel = alunoMapper.toModel(alunoDTO);

        assertEquals(alunoModel.getNome(), alunoDTO.getNome());
        assertEquals(alunoModel.getCpf(), alunoDTO.getCpf());
        assertEquals(alunoModel.getDataNascimento(), alunoDTO.getDataNascimento());
        assertEquals(alunoModel.getId(), alunoDTO.getId());

        assertEquals(alunoModel.getEndereco().getId(), alunoDTO.getEndereco().getId());
        assertEquals(alunoModel.getEndereco().getCidade(), alunoDTO.getEndereco().getCidade());
        assertEquals(alunoModel.getEndereco().getUf(), alunoDTO.getEndereco().getUf());
        assertEquals(alunoModel.getEndereco().getBairro(), alunoDTO.getEndereco().getBairro());
        assertEquals(alunoModel.getEndereco().getRua(), alunoDTO.getEndereco().getRua());
        assertEquals(alunoModel.getEndereco().getNumero(), alunoDTO.getEndereco().getNumero());
        assertEquals(alunoModel.getEndereco().getComplemento(), alunoDTO.getEndereco().getComplemento());
    }

}
