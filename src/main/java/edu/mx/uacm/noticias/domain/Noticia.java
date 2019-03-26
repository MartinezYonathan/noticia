/**
 * 
 */
package edu.mx.uacm.noticias.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author j-ma
 *
 */

@Entity
@Table(name = "noticia")
public class Noticia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(min = 3, max = 50)
	private String titulo;

	private Date fecha;

	@NotBlank
	@Size(min = 3, max = 50)
	private String nota;

	@NotBlank
	@Size(min = 3, max = 50)
	private String autor;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Comentario> comentario = new ArrayList<>();

	/**
	 * 
	 */
	public Noticia() {
		// TODO Auto-generated constructor stub
	}

	public Noticia(@NotBlank @Size(min = 3, max = 50) String titulo, Date fecha,
			@NotBlank @Size(min = 3, max = 50) String nota, @NotBlank @Size(min = 3, max = 50) String autor) {
		super();
		this.titulo = titulo;
		this.fecha = fecha;
		this.nota = nota;
		this.autor = autor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public List<Comentario> getComentario() {
		return comentario;
	}

	public void setComentario(List<Comentario> comentario) {
		this.comentario = comentario;
	}

}
