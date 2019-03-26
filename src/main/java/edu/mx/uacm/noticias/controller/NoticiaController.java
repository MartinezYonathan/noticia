package edu.mx.uacm.noticias.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.mx.uacm.noticias.domain.Comentario;
import edu.mx.uacm.noticias.domain.Noticia;
import edu.mx.uacm.noticias.domain.Usuario;
import edu.mx.uacm.noticias.repository.NoticiaRepository;

@RequestMapping(value = "/api")
@RestController
public class NoticiaController {

	public static final Logger log = LogManager.getLogger(NoticiaController.class);

	@Autowired
	NoticiaRepository noticiaRepository;

	@GetMapping(value = "/noticia/agregar/{titulo}")
	public String agregarNoticia(@PathVariable String titulo) {
		log.debug("_______________________________________________________");
		log.debug("-CON----------------- Entrando al metodo agregarUsuario");

		Noticia noticia = new Noticia(titulo, new Date(), "Esta es una nota", "Este es un autor");
		Noticia noticiaRetorn = noticiaRepository.save(noticia);

		return "Nota  " + noticiaRetorn.getTitulo() + " agregado";
	}

	@GetMapping(value = "/noticia")
	public List<Noticia> allNoticias() {
		List<Noticia> noticias = (List<Noticia>) noticiaRepository.findAll();
		return noticias;
	}

	@GetMapping(value = "/noticia/{id}")
	public Usuario getNoticia(@PathVariable String id) {

		// Tarea
		// Usuario usuarioRetorn =
		// noticiaRepository.findById_usuario(Long.parseLong(id));

		return null;
	}

	/*--------------------------------------------------------------------------------------*/

	@GetMapping(value = "/noticia/coemtatio/{comentario}")
	public String agregarComentario(@PathVariable String comentario) {
		log.debug("_______________________________________________________");
		log.debug("-CON--------------Entrando al metodo agregar comentario");

		/*
		 * Este es el metodo para recueperar por medio del Id el metodo nativo de JPA,
		 * el usuarioController nosotros mismos usamos un Query nativa.
		 * 
		 * Tambien si checan todos los comentarios se los estamos guardando
		 * a la noticia con id 1 y si no agregamos una noticia no funciona
		 * 
		 * de tarea para que practiquen, igual desde la url enviar el id de noticas
		 * para que se le agregue la noticia dependiendo el 1
		 */
		Optional<Noticia> noticiaRetorn = noticiaRepository.findById(Long.parseLong("1"));
		if (noticiaRetorn == null) {
			return "Noticia no encontrada";
		}
		/*
		 * Aqui les estamos agregando el comentario a la noticia
		 * */
		noticiaRetorn.get().getComentario().add(new Comentario(new Date(), comentario));
		noticiaRepository.save(noticiaRetorn.get());

		return "Comentario agregado";
	}
}
