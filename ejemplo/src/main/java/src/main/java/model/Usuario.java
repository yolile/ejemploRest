/**
 * 
 */
package src.main.java.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Yohanna Lisnichuk
 *
 */
@Entity
@XmlRootElement
@Table(name = "usuario")
public class Usuario {
	@Id
	@SequenceGenerator(name = "SEQ2", sequenceName = "usuario_id_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ2")
	private Long id;

	@NotNull
	@Size(min = 1, max = 25)
	@Pattern(regexp = "[^0-9]*", message = "No puede tener numeros")
	private String nombre;

	@NotNull
	@NotEmpty
	@Email
	private String email;

	@NotNull
	@Size(min = 10, max = 12)
	@Digits(fraction = 0, integer = 12)
	private String telefono;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}
