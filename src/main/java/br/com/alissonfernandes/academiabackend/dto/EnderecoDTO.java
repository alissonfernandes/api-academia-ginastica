package br.com.alissonfernandes.academiabackend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDTO {

    private Long id;

    @NotEmpty
    private String rua;

    @NotEmpty
    private String numero;

    @NotEmpty
    private String bairro;

    private String complemento;

    @NotEmpty
    private String cidade;

    @NotEmpty
    private String uf;
}
