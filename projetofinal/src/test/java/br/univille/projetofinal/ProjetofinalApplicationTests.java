package br.univille.projetofinal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import br.univille.projetofinal.controller.ClienteController;

@SpringBootTest
@AutoConfigureMockMvc
class ProjetofinalApplicationTests{

	@Autowired
	private ClienteController clienteController;
	@Autowired
	private MockMvc mockMvc;
}
