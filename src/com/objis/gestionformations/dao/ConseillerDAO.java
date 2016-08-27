package com.objis.gestionformations.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.objis.gestionformations.domaine.Conseiller;

public class ConseillerDAO {
	ConnexionDaseDeDonnees connexion = new ConnexionDaseDeDonnees();

	public Conseiller lireUnConseiller(String identifiant, String motDePasse) {
		ResultSet rs = null;

		String sql = "SELECT * FROM Conseiller where  identifiant = '" + identifiant + "' AND motDePasse = '"
				+ motDePasse + "'";

		Conseiller conseiller = new Conseiller();

		try {
			rs = connexion.creationConnexionBD().executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			while (rs.next()) {

				String idAsString = rs.getString("id");
				int id = Integer.parseInt(idAsString);
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				identifiant = rs.getString("identifiant");
				motDePasse = rs.getString("motDePasse");
				conseiller.setId(id);
				conseiller.setPrenom(prenom);
				conseiller.setNom(nom);
				conseiller.setIdentifiant(identifiant);
				conseiller.setMotDePasse(motDePasse);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			connexion.finConnexionBD();
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return conseiller;

	}

	public Conseiller lireUnConseillerDansUneBase(int id) {

		ArrayList<Conseiller> listeDesConseillers = lireTousLesConseillersDansUneBaseEtAjouterAUneListe();

		int index = 0;

		boolean isPresent = false;

		for (Conseiller conseiller : listeDesConseillers) {

			if (id == conseiller.getId()) {
				index = id - 1;
				isPresent = true;
				break;
			}
		}

		if (!isPresent) {
			System.out.println("Ce Conseiller n'exite pas !");
			return null;
		} else {

			System.out.println(listeDesConseillers.get(index));
			return listeDesConseillers.get(index);
		}

	}

	public ArrayList<Conseiller> lireTousLesConseillersDansUneBaseEtAjouterAUneListe() {

		// Info d'accès à la base de données
		String url = "jdbc:mysql://localhost:3306/tutofrontend?useSSL=false";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;

		// création de la liste
		ArrayList<Conseiller> listeDesConseillers = new ArrayList<Conseiller>();

		try {
			// Etape 1 : Chargement du driver
			Class.forName("com.mysql.jdbc.Driver");
			// Etape 2 : récupération de la connexion
			cn = DriverManager.getConnection(url, login, passwd);
			// Etape 3 : Création d'un statement
			st = cn.createStatement();
			String sql = "SELECT * FROM Conseiller";
			// Etape 4 : execution requete
			rs = st.executeQuery(sql);

			// etape 5 : parcours des résultats
			while (rs.next()) {
				String idAsString = rs.getString("id");
				Integer id = Integer.parseInt(idAsString);
				String prenom = rs.getString("prenom");
				String nom = rs.getString("nom");
				String identifiant = rs.getString("identifiant");
				String motDePasse = rs.getString("motDePasse");

				Conseiller conseiller = new Conseiller();
				conseiller.setId(id);
				conseiller.setIdentifiant(identifiant);
				conseiller.setMotDePasse(motDePasse);
				conseiller.setNom(nom);
				conseiller.setPrenom(prenom);
				listeDesConseillers.add(conseiller);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				cn.close();
				st.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listeDesConseillers;

	}

	public boolean ecrireUnConseillerDansUneBase(Conseiller conseiller) {
		// Info d'accès à la base de données

		int result = 0;
		String prenom = conseiller.getPrenom();
		String nom = conseiller.getNom();
		String identifiant = conseiller.getIdentifiant();
		String motDePasse = conseiller.getMotDePasse();

		String sql = "INSERT INTO Conseiller (prenom, nom, identifiant, motDePasse) VALUES ('" + "" + prenom + "', '"
				+ nom + "', '" + identifiant + "', '" + motDePasse + "')";

		// Etape 4 : exécution d'une requete

		try {
			result = connexion.creationConnexionBD().executeUpdate(sql);
		} catch (SQLException e) {

			e.printStackTrace();
		} finally

		{
			connexion.finConnexionBD();
		}
		if (result == 0)

		{
			return false;
		} else
			return true;

	}

}
