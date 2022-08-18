package br.com.alissonfernandes.academiabackend.builder;

import br.com.alissonfernandes.academiabackend.dto.AlunoDTO;
import br.com.alissonfernandes.academiabackend.dto.AvaliacaoFisicaDTO;
import lombok.Builder;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Builder
public class AvaliacaoFisicaDTOBuilder {

    @Builder.Default
    private Long id = 1L;

    @Builder.Default
    private AlunoDTO aluno = AlunoDTOBuilder.builder().build().toAlunoDTO();

    @Builder.Default
    private String dataAvaliacao = DateTimeFormatter.ofPattern("dd-MM-yyyy").format(LocalDate.now());

    @Builder.Default
    private double peso = 1.0f;

    @Builder.Default
    private double altura = 2.0f;

    public AvaliacaoFisicaDTO toAvaliacaoFisicaDTO() {
        return new AvaliacaoFisicaDTO(id, aluno, dataAvaliacao, peso, altura);
    }
}
