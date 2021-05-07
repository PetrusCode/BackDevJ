package com.servlet.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entidades.Usuario;

public class DAOdatos {

	public static final String TABLE_NOMBRE = "USUARIO";

	public ArrayList<Usuario> getAll() {
		ArrayList<Usuario> arrayUsuario = new ArrayList<>();

		try {
			PreparedStatement ja = SinglentonConnection.getinstance()
					.prepareStatement("select id, nombre from jugador");
			ResultSet res = ja.executeQuery();
			while (res.next()) {
				arrayUsuario.add(parseJugador(res));
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return arrayUsuario;
	}

	public boolean addUsuario(Usuario u) {

		try {

			PreparedStatement us = SinglentonConnection.getinstance()
					.prepareStatement(
							"insert into usuarios (nombre, apellidos, edad) values(?,?,?)");
			us.setLong(1, us.getResultSet());

		} catch (Exception e) {
			e.getMessage();
		}
	}

	public static Usuario parseJugador(ResultSet res) {
		int id;
		String nombre;
		String apellidos = "";
		int edad = 0;

		Usuario u = null;
		try {
			nombre = res.getString("nombre");
			id = res.getInt("id");
			u = new Usuario(id, edad, apellidos, nombre);

		} catch (SQLException e) {
			System.out.println("Intente de nuevo");
			e.printStackTrace();
		}
		return u;

	}

}
