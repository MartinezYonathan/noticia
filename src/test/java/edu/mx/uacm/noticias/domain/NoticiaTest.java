package edu.mx.uacm.noticias.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.mx.uacm.noticias.repository.NoticiaRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NoticiaTest {

	public static final Logger log = LogManager.getLogger(NoticiaTest.class);

	@Autowired
	NoticiaRepository noticiaRepository;

	@Test
	public void testAddNoticia() {
		log.debug("=======================================================");
		log.debug("-DOM-T--------------- Entrando al metodo testAddNoticia");

		// Given
		Noticia noticia = new Noticia();
		noticia.setAutor("yonathan");
		noticia.setNota("Esta es una noticia");
		noticia.setTitulo("Este es un titulo de mi noticia");
		noticia.setFecha(new Date());

		// When
		Noticia noticiaRetorn = noticiaRepository.save(noticia);

		// Then
		Assert.assertThat(noticiaRetorn, is(notNullValue()));
		log.debug("Noticia retornada: " + noticiaRetorn.toString());

	}
}
