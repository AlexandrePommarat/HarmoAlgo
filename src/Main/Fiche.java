package Main;

import java.io.Serializable;

public class Fiche implements Serializable{

	private String prenom;
	private String nom;
	private String adresse;
	private String tel;

	public Fiche(String prenom, String nom, String adresse, String tel) {
		this.setPrenom(prenom);
		this.setNom(nom);
		this.setAdresse(adresse);
		this.setTel(tel);
	}

	public Fiche(String prenom, String nom) {
		this.setPrenom(prenom);
		this.setNom(nom);
		this.adresse = "";
		this.tel = "";
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		if (adresse == null) {
			throw new IllegalArgumentException();
		}
		this.adresse = adresse;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel.trim();
	}
	
	public boolean aUnTelephone() {
		return this.tel.trim() != "";
	}
	
	public boolean aUneAdresse() {
		return this.adresse.trim() != "";
	}

	@Override
	public String toString() {
		return "Fiche [prenom=" + prenom + ", nom=" + nom + ", adresse=" + adresse + ", tel=" + tel + "]";
	}
}
