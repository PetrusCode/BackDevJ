package com.ejemplo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Persistence;
import javax.persistence.Table;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;


/**
 * The persistent class for the vehiculos database table.
 * 
 */
@Entity
@Table(name="vehiculos")
@NamedQuery(name="Vehiculo.findAll", query="SELECT v FROM Vehiculo v")
public class Vehiculo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String modelo;

	//bi-directional many-to-one association to Factura
	@OneToMany(mappedBy="vehiculo")
	private List<Factura> facturas;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="idCliente")
	private Cliente cliente;

	//bi-directional many-to-one association to Empleado
	@ManyToOne
	@JoinColumn(name="idMecanico")
	private Empleado empleado;

	public Vehiculo() {
	}

	
	/*Get*/
	public static ArrayList<Vehiculo> getAllVehiculos(){
		EntityManagerFactory factoria = Persistence.createEntityManagerFactory("Taller");
		EntityManager em = factoria.createEntityManager();
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
	    CriteriaQuery<Vehiculo> cq = cb.createQuery(Vehiculo.class);
	    TypedQuery<Vehiculo> allQuery = em.createQuery(cq);
	   ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
	   for(Vehiculo v : allQuery.getResultList()) {
		   vehiculos.add(v);
	   }
		em.close();
		return vehiculos;
	}
	public static Vehiculo getVehiculosById(int id){
		EntityManagerFactory factoria = Persistence.createEntityManagerFactory("Taller");
		EntityManager em = factoria.createEntityManager();
		Vehiculo v = em.find(Vehiculo.class, id);
		em.close();
		return v;
	}
	public void insertVehiculo() {
		EntityManagerFactory factoria = Persistence.createEntityManagerFactory("Taller");
		EntityManager em = factoria.createEntityManager();
		em.getTransaction().begin();
		
		em.persist(this);
		
		em.getTransaction().commit();
		em.close();
	}
	public void updateVehiculo(Vehiculo infoUpdate) {
		EntityManagerFactory factoria = Persistence.createEntityManagerFactory("Taller");
		EntityManager em = factoria.createEntityManager();
		em.getTransaction().begin();
			if(infoUpdate.getModelo() != null &&  !infoUpdate.getModelo().equals(this.modelo)) {
				this.setModelo(infoUpdate.getModelo());
			}
			if(infoUpdate.getCliente() != null &&  infoUpdate.getCliente().getId() != this.getCliente().getId()) {
				this.setCliente(infoUpdate.getCliente());
			}
			if(infoUpdate.getEmpleado() == null || this.empleado == null ||  infoUpdate.getEmpleado().getId() !=this.empleado.getId() ) {
				this.setEmpleado(infoUpdate.getEmpleado());
			}
		em.getTransaction().commit();
		em.close();
	}
	public void removeVehiculo() {
		EntityManagerFactory factoria = Persistence.createEntityManagerFactory("Taller");
		EntityManager em = factoria.createEntityManager();
		em.getTransaction().begin();
		
		em.remove(this);
		
		em.getTransaction().commit();
		em.close();
	}
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModelo() {
		return this.modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public List<Factura> getFacturas() {
		return this.facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

	public Factura addFactura(Factura factura) {
		getFacturas().add(factura);
		factura.setVehiculo(this);

		return factura;
	}

	public Factura removeFactura(Factura factura) {
		getFacturas().remove(factura);
		factura.setVehiculo(null);

		return factura;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	@Override
	public String toString() {
		return "Vehiculo [id=" + id + ", modelo=" + modelo + ", facturas=" + facturas + ", cliente=" + cliente.getNombre()
				+ ", empleado=" + empleado + "]";
	}

}