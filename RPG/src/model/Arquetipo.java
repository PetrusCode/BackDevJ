package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the arquetipo database table.
 * 
 */
@Entity
@NamedQuery(name="Arquetipo.findAll", query="SELECT a FROM Arquetipo a")
public class Arquetipo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String nombre;

	//bi-directional many-to-one association to Personaje
	@OneToMany(mappedBy="arquetipo")
	private List<Personaje> personajes;

	public Arquetipo() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Personaje> getPersonajes() {
		return this.personajes;
	}

	public void setPersonajes(List<Personaje> personajes) {
		this.personajes = personajes;
	}

	public Personaje addPersonaje(Personaje personaje) {
		getPersonajes().add(personaje);
		personaje.setArquetipo(this);

		return personaje;
	}

	public Personaje removePersonaje(Personaje personaje) {
		getPersonajes().remove(personaje);
		personaje.setArquetipo(null);

		return personaje;
	}

}