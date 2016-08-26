package com.objis.gestionformations.service;

import com.objis.gestionformations.dao.ConseillerDAO;
import com.objis.gestionformations.domaine.Conseiller;

public class ConseillerService {

	public Conseiller creerUnConseiller(String nom, String prenom, String identifiant, String motDePasse) {
		Conseiller conseiller = new Conseiller(nom, prenom, identifiant, motDePasse);
		return conseiller;

	}

	public boolean inscrireUnConseillerEnBase(Conseiller conseiller) {

		ConseillerDAO conseillerDao = new ConseillerDAO();
		boolean verif = conseillerDao.ecrireUnConseillerDansUneBase(conseiller);

		return verif;

	}

	public boolean creerUnConseillerEtLInscrireEnBase(String nom, String prenom, String identifiant, String motDePasse) {
		boolean verif = inscrireUnConseillerEnBase(creerUnConseiller(nom, prenom, identifiant, motDePasse));
		return verif;
	}

}
