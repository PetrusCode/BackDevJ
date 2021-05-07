package com.ejemplo.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the usuarios_juegos database table.
 * 
 */
@Entity
@Table(name="usuarios_juegos")
@NamedQuery(name="UsuariosJuego.findAll", query="SELECT u FROM UsuariosJuego u")
public class UsuariosJuego implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UsuariosJuegoPK id;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_compra")
	private Date fechaCompra;

	private float precio;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;

	//bi-directional many-to-one association to Juego
	@ManyToOne
	@JoinColumn(name="id_juego")
	private Juego juego;

	public UsuariosJuego() {
	}

	public UsuariosJuegoPK getId() {
		return this.id;
	}

	public void setId(UsuariosJuegoPK id) {
		this.id = id;
	}

	public Date getFechaCompra() {
		return this.fechaCompra;
	}

	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public float getPrecio() {
		return this.precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Juego getJuego() {
		return this.juego;
	}

	public void setJuego(Juego juego) {
		this.juego = juego;
	}

}