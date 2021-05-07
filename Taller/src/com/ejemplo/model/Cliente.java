package com.ejemplo.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the clientes database table.
 * 
 */
@Entity
@Table(name="clientes")
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String dni;

	private String nombre;

	private String telefono;

	//bi-directional many-to-one association to Vehiculo
	@OneToMany(mappedBy="cliente")
	private List<Vehiculo> vehiculos;

	public Cliente() {
	}
	
	public void loadLazyVehiculos() {
		EntityManagerFactory factoria = Persistence.createEntityManagerFactory("Taller");
		EntityManager em = factoria.createEntityManager();
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Vehiculo> cq = cb.createQuery(Vehiculo.class);
		
		Root<Vehiculo> model = cq.from(Vehiculo.class);
		cq.where(cb.equal(model.get("cliente"), this));
		TypedQuery<Vehiculo> tq = em.createQuery(cq);
		
		this.vehiculos = new ArrayList<Vehiculo>();
		for(Vehiculo v : tq.getResultList()) {
			this.vehiculos.add(v);
		}
		
		
		
	}
	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Vehiculo> getVehiculos() {
		return this.vehiculos;
	}

	public void setVehiculos(List<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}

	public Vehiculo addVehiculo(Vehiculo vehiculo) {
		getVehiculos().add(vehiculo);
		vehiculo.setCliente(this);

		return vehiculo;
	}

	public Vehiculo removeVehiculo(Vehiculo vehiculo) {
		getVehiculos().remove(vehiculo);
		vehiculo.setCliente(null);

		return vehiculo;
	}
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", dni=" + dni + ", nombre=" + nombre + ", telefono=" + telefono + ", vehiculos="
				+ vehiculos + "]";
	}

}