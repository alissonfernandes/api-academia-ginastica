package br.com.alissonfernandes.academiabackend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
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
    @NotBlank(message = "Preencha o campo corretamente")
    @Size(min = 3, max = 50, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres")
    private String nome;

    @NotEmpty
    @Valid
    private EnderecoDTO endereco;

    @NotEmpty
    @NotBlank(message = "Preencha o campo corretamente")
    private String dataNascimento;

    private List<AvaliacaoFisicaDTO> avaliacoes;
}
