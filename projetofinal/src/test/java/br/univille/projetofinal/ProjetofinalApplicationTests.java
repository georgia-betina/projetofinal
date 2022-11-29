package br.univille.projetofinal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import br.univille.projetofinal.api.ClienteControllerAPI;

@SpringBootTest
@AutoConfigureMockMvc
class ProjetofinalApplicationTests {

	@Autowired
	private ClienteControllerAPI clienteControllerAPI;
	@Test
	void contextLoads() {

	}

}
