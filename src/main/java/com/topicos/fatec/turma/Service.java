package com.topicos.fatec.turma;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface Service {
  public List<Turma> buscaTurma(String nome);
  public ResponseEntity<Object> criaTurma(Turma turma);
  public ResponseEntity<Object> criaProfessor(Long id, Professor professor);
  public Professor buscaProfessor(String nome);
}
