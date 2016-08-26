package com.objis.gestionformations.presentation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.objis.gestionformations.domaine.User;
import com.objis.gestionformations.service.ConseillerService;
import com.objis.gestionformations.service.ServiceAuth;

/**
 * Servlet implementation class MaServletC
 */
@WebServlet("/MaServletC")
public class MaServletC extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MaServletC() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		traitement(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		traitement(request, response);
	}

	protected void traitement(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Etape 1 : Récupération des paramètre de la requete :

		String identifiant = request.getParameter("login");
		String motDePasse = request.getParameter("pwd");
		String prenom = request.getParameter("prenom");
		String nom = request.getParameter("nom");

		// Etape 2 : Soumettre les paramètre de la requete à la couche service

		ConseillerService conseillerService = new ConseillerService();
		Boolean inscription = conseillerService.creerUnConseillerEtLInscrireEnBase(nom, prenom, identifiant,
				motDePasse);

		// Etape 3 : Réponse à l'utilisateur

		RequestDispatcher dispatcher;
		if (inscription == true) {
			dispatcher = request.getRequestDispatcher("inscriptionReussie.jsp");
		} else {
			dispatcher = request.getRequestDispatcher("inscriptionRatee.jsp");
		}

		dispatcher.forward(request, response);

	}

}
