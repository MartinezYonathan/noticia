/**
 * 
 */
package edu.mx.uacm.noticias.repository;

import org.springframework.data.repository.CrudRepository;

import edu.mx.uacm.noticias.domain.Noticia;

/**
 * @author j-ma
 *
 */
public interface NoticiaRepository extends CrudRepository<Noticia, Long> {

}
