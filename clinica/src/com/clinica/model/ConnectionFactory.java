package com.clinica.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/clinica?useSSL=false", "root", "eloah1106");
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		return null;
	}
}
