package br.com.alissonfernandes.academiabackend.builder;

import br.com.alissonfernandes.academiabackend.dto.EnderecoDTO;
import lombok.Builder;

@Builder
public class EnderecoDTOBuilder {

    @Builder.Default
    private Long id = 1L;

    @Builder.Default
    private String rua = "Rua";

    @Builder.Default
    private String numero = "00";

    @Builder.Default
    private String bairro = "Bairro";

    @Builder.Default
    private String complemento = "Complemento";

    @Builder.Default
    private String cidade = "Cidade";

    @Builder.Default
    private String uf = "DF";

    public EnderecoDTO toEnderecoDTO() {
       return new EnderecoDTO(id, rua, numero, bairro, complemento, cidade, uf);
    }
}
