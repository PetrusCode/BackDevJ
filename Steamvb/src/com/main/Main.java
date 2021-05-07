package com.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory factoria = Persistence.createEntityManagerFactory("Steamvb");
		EntityManager in = factoria.createEntityManager();
		 
		
		
		Usuario cliente = new Usuario();
		 cliente.insertCliente();
		 System.out.println(cliente);
		
		
		
		/*Usuario usuario1 = in.find(Usuario.class, 1);
		Juego juego1 = new Juego();*/
		
		
	}

}
