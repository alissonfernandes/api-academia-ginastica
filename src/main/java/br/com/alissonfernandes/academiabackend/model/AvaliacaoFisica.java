package br.com.alissonfernandes.academiabackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_avalicoes_fisicas")
public class AvaliacaoFisica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Aluno aluno;

    @Column
    private LocalDate dataAvaliacao = LocalDate.now();

    @Column(nullable = false)
    private double peso;

    @Column(nullable = false)
    private double altura;

}
