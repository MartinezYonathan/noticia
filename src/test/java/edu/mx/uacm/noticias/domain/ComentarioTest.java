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
import edu.mx.uacm.noticias.repository.UsuarioRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ComentarioTest {

	public static final Logger log = LogManager.getLogger(ComentarioTest.class);

	@Autowired
	NoticiaRepository noticiaRepository;
	@Autowired
	UsuarioRepository usuarioRepository;

	@Test
	public void testAddComentario() {
		log.debug("=======================================================");
		log.debug("-DOM-T--------------- Entrando al metodo testAddNoticia");

		// Given
		Usuario usuario = new Usuario("yonatahan", "martinez", "barradas", "j-ma@hotmail.es", "123456", "yonas");
		Usuario usuarioReturn = usuarioRepository.save(usuario);
		Comentario comentario = new Comentario(new Date(), "Esto es un comentario", usuarioReturn);
		Noticia noticia = new Noticia();
		noticia.setAutor("yonathan");
		noticia.setNota("Esta es una noticia");
		noticia.setTitulo("Este es un titulo de mi noticia");
		noticia.setFecha(new Date());
		noticia.getComentario().add(comentario);

		// When
		Noticia noticiaRetorn = noticiaRepository.save(noticia);

		// Then
		Assert.assertThat(noticiaRetorn, is(notNullValue()));
		log.debug(noticiaRetorn.toString());
	}
}
