/**
 * 
 */
package edu.mx.uacm.noticias.controller;

import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.mx.uacm.noticias.domain.Noticia;
import edu.mx.uacm.noticias.domain.Usuario;
import edu.mx.uacm.noticias.repository.UsuarioRepository;

/**
 * @author j-ma
 *
 */
@RequestMapping(value = "/api")
@RestController
public class UsuarioController {

	public static final Logger log = LogManager.getLogger(UsuarioController.class);

	@Autowired
	UsuarioRepository usuarioRepository;

	@GetMapping(value = "/usuario")
	public List<Usuario> getAllUsuarios() {
		log.debug("_______________________________________________________");
		log.debug("-CON----------------- Entrando al metodo agregarUsuario");

		return (List<Usuario>) usuarioRepository.findAll();
	}

	@GetMapping(value = "/usuario/{id}")
	public Usuario getUsuario(@PathVariable String id) {

		Usuario usuarioRetorn = usuarioRepository.findById_usuario(Long.parseLong(id));
		return usuarioRetorn;
	}

	@PostMapping("/usuario")
	public String addUsuario(@Valid @RequestBody Usuario usuario) {

		Usuario usuarioRetorn = usuarioRepository.save(usuario);
		return "agregado " + usuarioRetorn.getNombre();
	}

	@PutMapping("/usuario")
	public String updateTutorado(@Valid @RequestBody Usuario usuario) {
		Usuario usuarioRetorn = usuarioRepository.save(usuario);
		return "editado " + usuarioRetorn.getNombre();
	}

	@DeleteMapping("/usuario/{id}")
	public String deleteTutorado(@PathVariable String id) {
		usuarioRepository.deleteById(Long.parseLong(id));
		return "borrado";
	}
}
