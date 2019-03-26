package edu.mx.uacm.noticias.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

import java.io.IOException;
import java.util.Date;

import org.aspectj.lang.annotation.Before;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import edu.mx.uacm.noticias.repository.NoticiaRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NoticiaTest {

	@Autowired
	NoticiaRepository noticiaRepository;

	@Test
	public void addNoticia() {

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

	}
}
