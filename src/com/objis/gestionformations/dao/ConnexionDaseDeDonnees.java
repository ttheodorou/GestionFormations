package com.objis.gestionformations.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnexionDaseDeDonnees {

	static String url = "jdbc:mysql://localhost:3306/tutofrontend?useSSL=false";
	static String login = "root";
	static String passwd = "";
	static Connection cn = null;
	static Statement st = null;

	public Statement creationConnexionBD() {

		try {
			// Etape 1 : Chargement du driver
			Class.forName("com.mysql.jdbc.Driver");
			// Etape 2 : r�cup�ration de la connexion
			cn = DriverManager.getConnection(url, login, passwd);
			// Etape 3 : Cr�ation d'un statement
			st = cn.createStatement();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return st;
	}
	
	
	public void finConnexionBD(){
		
			{
				 try {
				 // Etape 5 : lib�rer ressources de la m�moire
				 cn.close();
				 st.close();
				 } catch (SQLException e) {
				 e.printStackTrace();
				 }
			} 
	}

}
