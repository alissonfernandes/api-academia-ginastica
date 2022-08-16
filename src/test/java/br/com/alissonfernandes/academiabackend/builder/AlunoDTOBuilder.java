package br.com.alissonfernandes.academiabackend.builder;

import br.com.alissonfernandes.academiabackend.dto.AlunoDTO;
import br.com.alissonfernandes.academiabackend.dto.EnderecoDTO;
import lombok.Builder;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Builder
public class AlunoDTOBuilder {

    @Builder.Default
    private Long id = 1L;

    @Builder.Default
    private String cpf = "12345678900";

    @Builder.Default
    private String nome = "Nome";

    @Builder.Default
    private EnderecoDTO endereco = EnderecoDTO.builder().build();

    @Builder.Default
    private String dataNascimento = DateTimeFormatter.ofPattern("dd-MM-yyyy").format(LocalDate.now());

    public AlunoDTO toAlunoDTO() {

        AlunoDTO alunoDTO = new AlunoDTO();
        alunoDTO.setId(id);
        alunoDTO.setCpf(cpf);
        alunoDTO.setNome(nome);
        alunoDTO.setEndereco(endereco);
        alunoDTO.setDataNascimento(dataNascimento);

       return alunoDTO;
    }
}
