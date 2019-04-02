package edu.mx.uacm.noticias.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UsuarioControllerTest {

	public static final Logger log = LogManager.getLogger(UsuarioControllerTest.class);

	@Test
	public void testAddUsuario() {
		log.debug("=======================================================");
		log.debug("-CON-T--------------- Entrando al metodo testAddUsuario");

	}

}
