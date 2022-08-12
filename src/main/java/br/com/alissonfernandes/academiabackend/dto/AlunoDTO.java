package br.com.alissonfernandes.academiabackend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AlunoDTO {

    private Long id;

    @NotEmpty
    private String cpf;

    @NotEmpty
    private String nome;

    @NotEmpty
    @Valid
    private EnderecoDTO endereco;

    @NotEmpty
    private LocalDate dataNascimento;

    private List<AvaliacaoFisicaDTO> avaliacoes;
}
