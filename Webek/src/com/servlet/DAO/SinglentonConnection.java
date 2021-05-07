package com.servlet.DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class SinglentonConnection {
private static Connection con = null;
	
	public static Connection getinstance() {
		if(con==null) {
			String usuario ="pedro";
			String pw = "123";
			
			try {
			Class.forName("org.mariadb.jdbc.Driver");
			String dbSchema= "opiniones";
			String url = "jdbc:mariadb://localhost:3306/" + dbSchema;
			con = DriverManager.getConnection(url, usuario, pw);
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	return con;
}

}