package com.objis.gestionformations.presentation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.objis.gestionformations.domaine.User;
import com.objis.gestionformations.service.ServiceAuth;

/**
 * Servlet implementation class MaServlet
 */
@WebServlet("/MaServlet")
public class MaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public MaServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		traitement(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		traitement(request, response);

	}

	protected void traitement(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Etape 1 : Récupération des paramètre de la requete :

		String identifiant = request.getParameter("login");
		String motDePasse = request.getParameter("pwd");

		// Etape 2 : Soumettre les paramètre de la requete à la couche service
		
		User user = new User(identifiant, motDePasse);
		HttpSession maSession = request.getSession();
		maSession.setAttribute("utilisateur", user);
		
		
		ServiceAuth serviceAuth = new ServiceAuth();

		// Etape 3 : Réponse à l'utilisateur

		RequestDispatcher dispatcher;
		if (serviceAuth.authentification(identifiant, motDePasse) == true) {
			dispatcher = request.getRequestDispatcher("resultatLogin.jsp");
		} else {
			dispatcher = request.getRequestDispatcher("login.jsp");
		}

		dispatcher.forward(request, response);

	}

}
