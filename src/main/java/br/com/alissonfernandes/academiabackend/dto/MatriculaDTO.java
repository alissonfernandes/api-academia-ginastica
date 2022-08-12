package br.com.alissonfernandes.academiabackend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MatriculaDTO {

    private Long id;

    @NotEmpty
    @Valid
    private AlunoDTO aluno;

    private LocalDateTime dataMatricula;
}
