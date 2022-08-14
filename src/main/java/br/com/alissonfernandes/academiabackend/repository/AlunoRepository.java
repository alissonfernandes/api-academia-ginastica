package br.com.alissonfernandes.academiabackend.repository;

import br.com.alissonfernandes.academiabackend.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
