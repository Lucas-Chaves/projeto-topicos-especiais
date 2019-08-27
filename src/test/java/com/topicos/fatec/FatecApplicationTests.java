package com.topicos.fatec;

import com.topicos.fatec.turma.RepositorioProfessor;
import com.topicos.fatec.turma.RepositorioTurma;
import com.topicos.fatec.turma.Turma;
import com.topicos.fatec.turma.TurmaNotFoundException;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureWebTestClient
public class FatecApplicationTests {
  @Autowired
	private WebTestClient webClient;

	@Test
	public void contextLoads() throws Exception {
		this.webClient.get().uri("/turma/paulo").exchange().expectStatus().isOk().expectBody(TurmaNotFoundException.class);
	}

}
