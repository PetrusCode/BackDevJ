package com.ejemplo.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usuarios database table.
 * 
 */
@Entity
@Table(name="usuarios")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private boolean baneado;

	private String correo;

	private String nombre;

	//uni-directional many-to-many association to Usuario
	@ManyToMany
	@JoinTable(
		name="usuarios_amigos"
		, joinColumns={
			@JoinColumn(name="id_usuario")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_amigo")
			}
		)
	private List<Usuario> usuarios;

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", baneado=" + baneado + ", correo=" + correo + ", nombre=" + nombre
				+ ", usuarios=" + usuarios + ", usuariosJuegos=" + usuariosJuegos + "]";
	}

	//bi-directional many-to-one association to UsuariosJuego
	@OneToMany(mappedBy="usuario", cascade = CascadeType.PERSIST)
	private List<UsuariosJuego> usuariosJuegos;

	public Usuario() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean getBaneado() {
		return this.baneado;
	}

	public void setBaneado(boolean baneado) {
		this.baneado = baneado;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<UsuariosJuego> getUsuariosJuegos() {
		return this.usuariosJuegos;
	}

	public void setUsuariosJuegos(List<UsuariosJuego> usuariosJuegos) {
		this.usuariosJuegos = usuariosJuegos;
	}

	public UsuariosJuego addUsuariosJuego(UsuariosJuego usuariosJuego) {
		getUsuariosJuegos().add(usuariosJuego);
		usuariosJuego.setUsuario(this);

		return usuariosJuego;
	}

	public UsuariosJuego removeUsuariosJuego(UsuariosJuego usuariosJuego) {
		getUsuariosJuegos().remove(usuariosJuego);
		usuariosJuego.setUsuario(null);

		return usuariosJuego;
	}

}