package com.topicos.fatec.turma;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RepositorioProfessor extends JpaRepository<Professor, Long> {

    @Query("select p from Professor p where p.nome like %?1%")
    public List<Professor> buscaProfessor(String nome);
}
