package com.ejemplo.negocio;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ejemplo.model.Juego;
import com.ejemplo.model.Usuario;
import com.ejemplo.model.UsuariosJuego;
import com.ejemplo.model.UsuariosJuegoPK;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Steam");
		EntityManager em = factory.createEntityManager();
		
		Usuario usuario1 = em.find(Usuario.class, 1);
		Juego juego1 = em.find(Juego.class, 1);

		System.out.println(usuario1);
		System.out.println(juego1);
		
		UsuariosJuego uj = new UsuariosJuego();
		
		uj.setUsuario(usuario1);
		uj.setJuego(juego1);
		uj.setPrecio(juego1.getPrecio());
		uj.setFechaCompra(new Date());
		UsuariosJuegoPK ujpk = new UsuariosJuegoPK();
		ujpk.setIdJuego(juego1.getId());
		ujpk.setIdUsuario(usuario1.getId());
		uj.setId(ujpk);
		em.getTransaction().begin();
		
		usuario1.addUsuariosJuego(uj);
		
		em.getTransaction().commit();
		em.close();
		
	}

}
