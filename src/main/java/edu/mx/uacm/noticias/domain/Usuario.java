/**
 * 
 */
package edu.mx.uacm.noticias.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author j-ma
 *
 */

@Entity
@Table(name = "Usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	//Estas anotaciones no son parte de hibernate sino que son validaciones
	//antes de la transaccion
	@NotBlank
	@Size(min = 3, max = 50)
	private String nombre;

	@NotBlank
	@Size(min = 3, max = 50)
	private String apellidoP;

	@NotBlank
	@Size(min = 3, max = 50)
	private String apellidoM;

	@NotBlank
	@Size(max = 50)
	@Email
	private String correo;

	@NotBlank
	@Size(min = 3, max = 50)
	private String pass;

	@NotBlank
	@Size(min = 3, max = 50)
	private String nickname;

	/**
	 * 
	 */
	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public Usuario(String nombre, String apellidoP, String apellidoM, String correo, String pass, String nickname) {
		super();
		this.nombre = nombre;
		this.apellidoP = apellidoP;
		this.apellidoM = apellidoM;
		this.correo = correo;
		this.pass = pass;
		this.nickname = nickname;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoP() {
		return apellidoP;
	}

	public void setApellidoP(String apellidoP) {
		this.apellidoP = apellidoP;
	}

	public String getApellidoM() {
		return apellidoM;
	}

	public void setApellidoM(String apellidoM) {
		this.apellidoM = apellidoM;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

}
