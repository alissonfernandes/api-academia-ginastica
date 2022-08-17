package br.com.alissonfernandes.academiabackend.controller;

import br.com.alissonfernandes.academiabackend.builder.AlunoDTOBuilder;
import br.com.alissonfernandes.academiabackend.dto.AlunoDTO;
import br.com.alissonfernandes.academiabackend.service.impl.AlunoServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import static org.hamcrest.core.Is.is;

import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import java.util.Collections;

import static org.mockito.Mockito.when;
@SpringBootTest
@AutoConfigureMockMvc
public class AlunoControllerTest {

    private static final String ALUNO_API_URL_PATH = "/api/v1/aluno";
    private static final String VALID_ID = "1";

    @Autowired
    private MockMvc mockMvc;

    @Mock
    AlunoServiceImpl alunoService;

    @InjectMocks
    AlunoController alunoController;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(alunoController)
                .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                .setViewResolvers((s, locale) -> new MappingJackson2JsonView())
                .build();
    }

    @Test
    void whenCreateMethodIsCalledThenAsAlunoIsCreated() throws Exception {
        AlunoDTO alunoDTO = AlunoDTOBuilder.builder().build().toAlunoDTO();

        when(alunoService.create(alunoDTO)).thenReturn(alunoDTO);

        mockMvc.perform(post(ALUNO_API_URL_PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(alunoDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.cpf", is(alunoDTO.getCpf())))
                .andExpect(jsonPath("$.nome", is(alunoDTO.getNome())))
                .andExpect(jsonPath("$.dataNascimento", is(alunoDTO.getDataNascimento())));
    }

    @Test
    void whenGetAlunoAllIsCalledThenListAlunoIsReturned() throws Exception {
        AlunoDTO alunoDTO = AlunoDTOBuilder.builder().build().toAlunoDTO();

        when(alunoService.getAll()).thenReturn(Collections.singletonList(alunoDTO));

        mockMvc.perform(get(ALUNO_API_URL_PATH)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isFound())
                .andExpect(jsonPath("$[0].cpf", is(alunoDTO.getCpf())))
                .andExpect(jsonPath("$[0].nome", is(alunoDTO.getNome())))
                .andExpect(jsonPath("$[0].dataNascimento", is(alunoDTO.getDataNascimento())));
    }

    @Test
    void whenGetAlunoIsCalledThenAlunoIsReturned() throws Exception {
        AlunoDTO alunoDTO = AlunoDTOBuilder.builder().build().toAlunoDTO();

        when(alunoService.get(alunoDTO.getId())).thenReturn(alunoDTO);

        mockMvc.perform(get(ALUNO_API_URL_PATH + "/" + VALID_ID).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isFound())
                .andExpect(jsonPath("$.cpf", is(alunoDTO.getCpf())))
                .andExpect(jsonPath("$.nome", is(alunoDTO.getNome())))
                .andExpect(jsonPath("$.dataNascimento", is(alunoDTO.getDataNascimento())));
    }

    @Test
    void whenDeleteIsCalledWithValidIdThenNotContentStatusIsReturned() throws Exception {
        AlunoDTO alunoDTO = AlunoDTOBuilder.builder().build().toAlunoDTO();

        doNothing().when(alunoService).delete(alunoDTO.getId());

        mockMvc.perform(delete(ALUNO_API_URL_PATH + "/" + VALID_ID).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

}
