package edu.mx.uacm.noticias.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.mx.uacm.noticias.domain.Comentario;
import edu.mx.uacm.noticias.domain.Noticia;
import edu.mx.uacm.noticias.domain.Usuario;
import edu.mx.uacm.noticias.repository.NoticiaRepository;
import edu.mx.uacm.noticias.repository.UsuarioRepository;
import edu.mx.uacm.noticias.request.NoticiaRequest;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/api")
@RestController
public class NoticiaController {

	public static final Logger log = LogManager.getLogger(NoticiaController.class);

	@Autowired
	NoticiaRepository noticiaRepository;
	@Autowired
	UsuarioRepository usuariorepository;

	@PostMapping(value = "/noticia")
	public Noticia addNoticia(@RequestBody Noticia noticia) throws ParseException {
		log.debug("_______________________________________________________");
		log.debug("-CON--------------------- Entrando al metodo addNoticia");

		// log.debug("entro con esto: " + noticiaRequest);

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		// Date date = formatter.parse(noticiaRequest.getFecha());

		Noticia noticiaRetorn = noticiaRepository.save(noticia);

		log.debug("Agregada" + noticiaRetorn.toString());
		return noticiaRetorn;

	}

	@PutMapping(value = "/noticia")
	public Noticia updateNoticia(@RequestBody Noticia noticia) {
		log.debug("_______________________________________________________");
		log.debug("-CON------------------ Entrando al metodo updateNoticia");

		Noticia noticiaRetorn = noticiaRepository.save(noticia);

		log.debug("Editada" + noticiaRetorn.toString());
		return noticiaRetorn;
	}

	@DeleteMapping(value = "/noticia/{id}")
	public String deleteNoticia(@PathVariable String id) {

		noticiaRepository.deleteById(Long.parseLong(id));

		return "Noticia borrado";
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
	public Noticia agregarComentario(@PathVariable String comentario) {
		log.debug("_______________________________________________________");
		log.debug("-CON--------------Entrando al metodo agregar comentario");

		Optional<Noticia> noticiaRetorn = noticiaRepository.findById(Long.parseLong("1"));
		Optional<Usuario> usuarioRetorn = usuariorepository.findById(Long.parseLong("1"));
		if (noticiaRetorn == null) {
			return null;
		}
		noticiaRetorn.get().getComentario().add(new Comentario(new Date(),"texto",usuarioRetorn.get()));

		return noticiaRepository.save(noticiaRetorn.get());
	}

	@PostMapping(value = "/noticia/comentario")
	public Noticia addcomentario(@RequestBody Comentario cometario) {
		log.debug("_______________________________________________________");
		log.debug("-CON---------------    Entrando al metodo addcomentario");

		Optional<Noticia> noticiaRetorn = noticiaRepository.findById(new Long(1));
		if (noticiaRetorn == null) {
			return null;
		}
		log.debug("-CON---------------    Entrando al metodo addcomentario");

		noticiaRetorn.get().getComentario()
				.add(new Comentario(cometario.getFecha(), cometario.getTexto(), cometario.getUsuario()));

		return noticiaRepository.save(noticiaRetorn.get());
	}
}
