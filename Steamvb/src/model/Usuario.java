package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Persistence;
import javax.persistence.Table;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

/**
 * The persistent class for the usuarios database table.
 * 
 */
@Entity
@Table(name = "usuarios")
@NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private boolean baneado;

	private String correo;

	private String nombre;

	// bi-directional many-to-many association to Usuario
	@ManyToMany
	@JoinTable(name = "usuarios_amigos", joinColumns = {
			@JoinColumn(name = "id_usuario") }, inverseJoinColumns = {
					@JoinColumn(name = "id_amigo") })
	private List<Usuario> usuarios1;

	// bi-directional many-to-many association to Usuario
	@ManyToMany(mappedBy = "usuarios1")
	private List<Usuario> usuarios2;

	// bi-directional many-to-one association to UsuariosJuego
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.PERSIST)
	private List<UsuariosJuego> usuariosJuegos;

	public Usuario() {
	}

	public void insertCliente() {
		EntityManagerFactory factoria = Persistence
				.createEntityManagerFactory("Steamvb");
		EntityManager in = factoria.createEntityManager();

		Usuario usu1 = in.find(Usuario.class, 4);
		Usuario usu2 = in.find(Usuario.class, 6);
		in.getTransaction().begin();

		in.getTransaction().commit();

		Usuario usu = new Usuario();

		usu.setNombre("Pedrd2");
		usu.setCorreo("huihifuge322");
		usu.setBaneado(true);
		in.getTransaction().begin();
		// usu.setUsuarios1();
		in.persist(usu);
		in.getTransaction().commit();

		Juego game = new Juego();
		game.setNombre("TheWitcher5");
		game.setPrecio(123);
		game.setUsuariosJuegos(getUsuariosJuegos());
		game.setId(243561233);
		in.getTransaction().begin();
		in.persist(game);
		in.getTransaction().commit();

		Date fecha = new Date();

		UsuariosJuego juegos1 = new UsuariosJuego();
		juegos1.setJuego(game);
		juegos1.setPrecio(game.getPrecio());
		juegos1.setFechaCompra(fecha);
		juegos1.setUsuario(usu2);
		in.getTransaction().begin();
		in.persist(juegos1);
		in.getTransaction().commit();

		UsuariosJuego juegos = in.find(UsuariosJuego.class, 1);
		UsuariosJuego juegosa = in.find(UsuariosJuego.class, 2);
		in.getTransaction().begin();
		juegos.getJuego().addUsuariosJuego(juegosa);

		in.getTransaction().commit();

		CriteriaBuilder cri = in.getCriteriaBuilder();
		CriteriaQuery<Usuario> cq = cri.createQuery(Usuario.class);
		TypedQuery<Usuario> allQuery = in.createQuery(cq);
		for (Usuario c : allQuery.getResultList()) {
			System.out.println(c);

		}

		Usuario usuu = in.find(Usuario.class, 1);
		System.out.println(usuu);

		System.out.println("------------------------------");

		in.getTransaction().begin();
		usuu.setCorreo("YYYYYYYY");
		in.getTransaction().commit();
		usuu = in.find(Usuario.class, 1);
		System.out.println(usuu);

	}

	public void insertAmigo() {
		EntityManagerFactory factoria = Persistence
				.createEntityManagerFactory("Steamvb");
		EntityManager in1 = factoria.createEntityManager();

	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCorreo() {
		return this.correo;
	}

	public boolean getBaneado() {
		return this.baneado;
	}

	public void setBaneado(boolean baneado) {
		this.baneado = baneado;
		if (baneado = true) {
			baneado = true;
		} else {
			baneado = false;
		}
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

	public List<Usuario> getUsuarios1() {
		return this.usuarios1;
	}

	public void setUsuarios1(List<Usuario> usuarios1) {
		this.usuarios1 = usuarios1;
	}

	public List<Usuario> getUsuarios2() {
		return this.usuarios2;
	}

	public void setUsuarios2(List<Usuario> usuarios2) {
		this.usuarios2 = usuarios2;
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