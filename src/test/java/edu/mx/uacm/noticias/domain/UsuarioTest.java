package edu.mx.uacm.noticias.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.mx.uacm.noticias.repository.UsuarioRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsuarioTest {

	public static final Logger log = LogManager.getLogger(UsuarioTest.class);

	@Autowired
	UsuarioRepository usuarioRepository;

	@Test
	public void testAddUsuario() {
		log.debug("=======================================================");
		log.debug("-DOM-T--------------- Entrando al metodo testAddUsuario");

		// Given
		Usuario usuario = new Usuario("yonatahan", "martinez", "barradas", "j-ma@hotmail.es", "123456", "yonas");

		// When
		Usuario usuarioReturn = usuarioRepository.save(usuario);

		// Then
		Assert.assertThat(usuarioReturn, is(notNullValue()));

	}
}
