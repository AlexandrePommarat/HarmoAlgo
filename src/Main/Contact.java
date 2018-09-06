package Main;

import java.io.Serializable;

/**
 * Classe qui permet d'instancier une contact avec les informations sur une personne
 * Elle contient nom, prenom, adresse, numero de telephone
 */
public class Contact implements Serializable{

	private String prenom;
	private String nom;
	private String adresse;
	private String tel;
	
	/**
	 * Premier constructeur de fiche, il permet de creer une contact avec toute les informations possibles d'une personne
	 * @param prenom
	 * @param nom
	 * @param adresse
	 * @param tel
	 */
	public Contact(String prenom, String nom, String adresse, String tel) {
		this.setPrenom(prenom);
		this.setNom(nom);
		this.setAdresse(adresse);
		this.setTel(tel);
	}

	/**
	 * Deuxieme constructeur 
	 * @param prenom
	 * @param nom
	 */
	public Contact(String prenom, String nom) {
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
		return "Contact [prenom=" + prenom + ", nom=" + nom + ", adresse=" + adresse + ", tel=" + tel + "]";
	}
}
