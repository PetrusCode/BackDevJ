package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the jugador database table.
 * 
 */
@Entity
@NamedQuery(name="Jugador.findAll", query="SELECT j FROM Jugador j")
public class Jugador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String nombre;

	//bi-directional many-to-one association to Personaje
	@OneToMany(mappedBy="jugador")
	private List<Personaje> personajes;

	public Jugador() {
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
		personaje.setJugador(this);

		return personaje;
	}

	public Personaje removePersonaje(Personaje personaje) {
		getPersonajes().remove(personaje);
		personaje.setJugador(null);

		return personaje;
	}

}