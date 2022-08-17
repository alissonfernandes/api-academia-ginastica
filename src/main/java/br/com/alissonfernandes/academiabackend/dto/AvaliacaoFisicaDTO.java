package br.com.alissonfernandes.academiabackend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AvaliacaoFisicaDTO {

    private Long id;

    private AlunoDTO aluno;

    private LocalDate dataAvaliacao = LocalDate.now();

    @NotEmpty
    private double peso;

    @NotEmpty
    private double altura;
}
