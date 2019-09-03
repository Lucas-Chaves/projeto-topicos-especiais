package com.topicos.fatec;

import com.topicos.fatec.turma.*;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureWebTestClient
public class FatecApplicationTests {
	@Autowired
	private RepositorioTurma repositorioTurma;

	@Autowired
	private ServicoTurma servicoTurma;

	@Test
	public void testeRepositorio() throws Exception {
		List<Professor> professores = new ArrayList<Professor>();
		Turma insereTurma = new Turma(12345678910L, "Paulo", "10:10", "10:50", "segundo", professores);
		Turma turmaSalva = repositorioTurma.save(insereTurma);

		Optional<Turma> encontraTurma = repositorioTurma.findById(turmaSalva.getId());

		assertNotNull(turmaSalva);
		assertEquals(turmaSalva.getId(), encontraTurma.get().getId());
	}

	@Test
	public void testeRepositorio2() throws Exception {
		List<Turma> turmas = repositorioTurma.findAll();

		assertNotNull(turmas);
		assertTrue(turmas.size() > 0);
	}

	@Test
	public void testeServico() throws Exception {
		List<Turma> turmas = repositorioTurma.findAll();

		Professor professor = new Professor(123456723232L, "julivan", "jesus", "1234565789", turmas.get(1), 25);
		ResponseEntity<Object> professorCriado = servicoTurma.criaProfessor(turmas.get(1).getId(), professor);
		assertEquals(professorCriado.getStatusCode(), HttpStatus.CREATED);
	}

	@Test
	public void testeServico2() throws Exception {
		List<Turma> turma = servicoTurma.buscaTurma("rodrigo");
		assertNotNull(turma);
		assertEquals(turma.get(0).getSemestre(), "quarto");
	}
}
