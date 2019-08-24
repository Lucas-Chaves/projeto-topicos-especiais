package com.topicos.fatec.turma;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Id;
import java.util.List;

@RestController
public class TurmaService {

  @Autowired
  private RepositorioTurma repositorioTurma;

  @GetMapping("/turma")
  public List<Turma> getTurma(){
    return repositorioTurma.findAll();
  }

  @GetMapping("/turma/{id}")
  public List<Turma> buscaTurma(@PathVariable Long id){
    return repositorioTurma.buscaTurma(id);

  }

}
