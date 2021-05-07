package com.ejemplo.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the usuarios_juegos database table.
 * 
 */
@Embeddable
public class UsuariosJuegoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_usuario", insertable=false, updatable=false)
	private int idUsuario;

	@Column(name="id_juego", insertable=false, updatable=false)
	private int idJuego;

	public UsuariosJuegoPK() {
	}
	public int getIdUsuario() {
		return this.idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public int getIdJuego() {
		return this.idJuego;
	}
	public void setIdJuego(int idJuego) {
		this.idJuego = idJuego;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof UsuariosJuegoPK)) {
			return false;
		}
		UsuariosJuegoPK castOther = (UsuariosJuegoPK)other;
		return 
			(this.idUsuario == castOther.idUsuario)
			&& (this.idJuego == castOther.idJuego);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idUsuario;
		hash = hash * prime + this.idJuego;
		
		return hash;
	}
}