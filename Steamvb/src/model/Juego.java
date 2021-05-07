package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the juegos database table.
 * 
 */
@Entity
@Table(name="juegos")
@NamedQuery(name="Juego.findAll", query="SELECT j FROM Juego j")
public class Juego implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String nombre;

	private float precio;

	//bi-directional many-to-one association to UsuariosJuego
	@OneToMany(mappedBy="juego")
	private List<UsuariosJuego> usuariosJuegos;

	public Juego() {
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

	public float getPrecio() {
		return this.precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public List<UsuariosJuego> getUsuariosJuegos() {
		return this.usuariosJuegos;
	}

	public void setUsuariosJuegos(List<UsuariosJuego> usuariosJuegos) {
		this.usuariosJuegos = usuariosJuegos;
	}

	public UsuariosJuego addUsuariosJuego(UsuariosJuego usuariosJuego) {
		getUsuariosJuegos().add(usuariosJuego);
		usuariosJuego.setJuego(this);

		return usuariosJuego;
	}

	public UsuariosJuego removeUsuariosJuego(UsuariosJuego usuariosJuego) {
		getUsuariosJuegos().remove(usuariosJuego);
		usuariosJuego.setJuego(null);

		return usuariosJuego;
	}

}