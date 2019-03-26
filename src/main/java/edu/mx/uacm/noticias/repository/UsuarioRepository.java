package edu.mx.uacm.noticias.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.mx.uacm.noticias.domain.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

	@Query(value = "select * from usuario where id" + "=:id", nativeQuery = true)
	Usuario findById_usuario(@Param("id") Long id);
	
	@Query(value = "select * from usuario where nombre" + "=:nombre", nativeQuery = true)
	Usuario byName_usuario(@Param("nombre") String nombre);
}
