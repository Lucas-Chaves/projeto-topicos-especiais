package com.topicos.fatec.turma;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
public class ServicoTurma  implements  Service {

  @Autowired
  private RepositorioTurma repositorioTurma;

  @Autowired
  private RepositorioProfessor repositorioProfessor;

  @GetMapping("/turma/{nome}")
  @Override
  public List<Turma> buscaTurma(@PathVariable String nome) {
    List<Turma> turma = repositorioTurma.buscaTurma(nome);

    if (turma.isEmpty()) throw new TurmaNotFoundException("nome-" + nome);

    return turma;
  }

  @PostMapping("/turma")
  @Override
  public ResponseEntity<Object> criaTurma(@Valid @RequestBody Turma turma) {
    Turma turmaSalva = repositorioTurma.save(turma);

    URI location = fromCurrentRequest().path("/{id}").buildAndExpand(turmaSalva.getId()).toUri();

    return ResponseEntity.created(location).build();
  }

  @PostMapping("/turma/{id}/professor")
  @Override
  public ResponseEntity<Object> criaProfessor(@PathVariable Long id, @Valid @RequestBody Professor professor) {
    Optional<Turma> optionalTurma = repositorioTurma.findById(id);

    if (!optionalTurma.isPresent()) throw new TurmaNotFoundException("id-" + id);

    Turma turma = optionalTurma.get();

    professor.setTurma(turma);

    repositorioProfessor.save(professor);

    URI location = fromCurrentRequest().path("{id}").buildAndExpand(professor.getId()).toUri();

    return ResponseEntity.created(location).build();
  }


  @GetMapping("/turma/{id}/professor/{nome}")
  @Override
  public Professor buscaProfessor(@PathVariable String nome) {
    List<Professor> professores = repositorioProfessor.buscaProfessor(nome);

    if (professores.isEmpty()) throw new ProfessorNotFoundException("nome-" + nome);

    return professores.get(0);
  }

}
