package com.topicos.fatec.turma;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RepositorioTurma extends JpaRepository<Turma,Long> {

  @Query("select u from Turma u where u.id = 1")
  public List<Turma> buscaTurma(Long id);

}
