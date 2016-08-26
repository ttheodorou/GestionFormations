package com.objis.gestionformations.domaine;

public class User {
	private String identifiant;
	private String motDePasse;

	public User() {
		super();
	}

	public User(String identifiant, String motDePasse) {
		super();
		this.identifiant = identifiant;
		this.motDePasse = motDePasse;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public String getMotDePsse() {
		return motDePasse;
	}

	public void setMotDePsse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

}
