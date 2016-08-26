package com.objis.gestionformations.service;

import com.objis.gestionformations.dao.ConseillerDAO;

public class ServiceAuth {
	
	public boolean authentification(String identifiant, String motDePasse){
		
//		String loginEnregistre = "bob";
//		String motDePasseEnregistre = "azerty";
		
		ConseillerDAO conseillerdao = new ConseillerDAO();
		String loginEnregistre = conseillerdao.lireUnConseiller(identifiant, motDePasse).getIdentifiant();
		String motDePasseEnregistre = conseillerdao.lireUnConseiller(identifiant, motDePasse).getMotDePasse();
		
		if((identifiant.equalsIgnoreCase(loginEnregistre))&&(motDePasse.equalsIgnoreCase(motDePasseEnregistre))){
			return true;
		}else
			return false;
		
		
	}

}
