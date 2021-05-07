package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the personaje database table.
 * 
 */
@Entity
@NamedQuery(name="Personaje.findAll", query="SELECT p FROM Personaje p")
public class Personaje implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String descripcion;

	private String nombre;

	//bi-directional many-to-one association to Jugador
	@ManyToOne
	@JoinColumn(name="id_jugador")
	private Jugador jugador;

	//bi-directional many-to-one association to Juego
	@ManyToOne
	@JoinColumn(name="id_juego")
	private Juego juego;

	//bi-directional many-to-one association to Arquetipo
	@ManyToOne
	@JoinColumn(name="id_arquetipo")
	private Arquetipo arquetipo;

	public Personaje() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Jugador getJugador() {
		return this.jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public Juego getJuego() {
		return this.juego;
	}

	public void setJuego(Juego juego) {
		this.juego = juego;
	}

	public Arquetipo getArquetipo() {
		return this.arquetipo;
	}

	public void setArquetipo(Arquetipo arquetipo) {
		this.arquetipo = arquetipo;
	}

}