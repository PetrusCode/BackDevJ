package com.ejemplo.negocio;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ejemplo.model.Cliente;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory factoria = Persistence
				.createEntityManagerFactory("Taller");
		EntityManager em = factoria.createEntityManager();

		Cliente c = em.find(Cliente.class, 16);
		System.out.println("------------------------------------------------");
		System.out.println(c);
		System.out.println("------------------Cargado-----------------------");
		c.loadLazyVehiculos();
		System.out.println(c);

		/*
		 * Cliente cl = new Cliente(); cl.setDni("44648513");
		 * cl.setNombre("Juanjo"); cl.setTelefono("956549");
		 * em.getTransaction().begin(); em.persist(cl);
		 * em.getTransaction().commit();
		 */
		/*
		 * CriteriaBuilder cb = em.getCriteriaBuilder(); CriteriaQuery<Cliente>
		 * cq = cb.createQuery(Cliente.class); TypedQuery<Cliente> allQuery =
		 * em.createQuery(cq); for(Cliente c : allQuery.getResultList()) {
		 * System.out.println(c); } em.find(arg0, arg1)
		 */
		/*
		 * 
		 * EntityManagerFactory factoria =
		 * Persistence.createEntityManagerFactory("Taller"); EntityManager em =
		 * factoria.createEntityManager();
		 */
		/*
		 * Root<Cliente> model = cq.from(Cliente.class);
		 * cq.where(cb.equal(model.get("id"), 1)); TypedQuery<Cliente> q =
		 * em.createQuery(cq);
		 * 
		 * System.out.println(q.getSingleResult());
		 * 
		 * 
		 * cq.where(cb.greaterThanOrEqualTo(model.get("id"), 1)); q =
		 * em.createQuery(cq);
		 * 
		 * System.out.println(q.getResultList());
		 * System.out.println("------------------------------");
		 * 
		 * Cliente client = em.find(Cliente.class, 1);
		 * System.out.println(client);
		 * 
		 * System.out.println("------------------------------");
		 * 
		 * em.getTransaction().begin(); client.setDni("YYYYYYYY");
		 * em.getTransaction().commit(); client = em.find(Cliente.class, 1);
		 * System.out.println(client);
		 * 
		 * 
		 * 
		 * Cliente juanjo = new Cliente(); juanjo.setDni("44648513");
		 * juanjo.setNombre("Juanjo"); juanjo.setTelefono("956549");
		 * em.getTransaction().begin(); em.persist(juanjo);
		 * System.out.println(juanjo); Empleado emp = em.find(Empleado.class,
		 * 1);
		 * 
		 * Empleado empleado = new Empleado(); empleado.setFechaContratacion(new
		 * Date()); empleado.setNombre("Empleado 1"); em.persist(empleado);
		 * Empleado emp1 = em.find(Empleado.class, 1); System.out.println(emp1);
		 * Vehiculo kawa = new Vehiculo(); kawa.setCliente(juanjo);
		 * kawa.setModelo("Kawasaky z900"); kawa.setEmpleado(emp1);
		 * System.out.println(kawa); em.persist(kawa);
		 * 
		 * em.getTransaction().commit();
		 * 
		 * Vehiculo kawaDB = em.find(Vehiculo.class, 1);
		 * System.out.println(kawaDB);
		 * 
		 * 
		 * em.close();
		 */

	}

}
