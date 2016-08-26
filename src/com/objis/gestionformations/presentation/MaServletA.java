package com.objis.gestionformations.presentation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MaServletA
 */
@WebServlet("/MaServletA")
public class MaServletA extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
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

		// Etape 1 : R�cup�ration des param�tre de la requete :

		// Etape 2 : Soumettre les param�tre de la requete � la couche service

		// Etape 3 : R�ponse � l'utilisateur

		RequestDispatcher dispatcher;

		dispatcher = request.getRequestDispatcher("inscription.jsp");

		dispatcher.forward(request, response);

	}

}
