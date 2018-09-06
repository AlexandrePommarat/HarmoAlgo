package liste_contacts;

import java.io.Serializable;

import Main.Contact;

/**
 * ContactChaine utilisée par la classe {@link ListeContact}, cette objet est un Contact qui a un pointeur qui
 * pointe vers un autre contact
 *
 */
public class ContactChaine extends Contact{
	
	/**
	 * Pointeur vers le Contact suivante
	 */
	private ContactChaine ficheSuivante;

	public ContactChaine(String prenom, String nom) {
		super(prenom, nom);
		this.ficheSuivante = null;
	}

	public ContactChaine(String prenom, String nom, String adresse, String tel) {
		super(prenom, nom, adresse, tel);
		this.ficheSuivante = null;
	}
	
	public ContactChaine(Contact f) {
		super(f.getPrenom(), f.getNom(), f.getAdresse(), f.getTel());
		this.ficheSuivante = null;
	}

	public ContactChaine getContactSuivant() {
		return ficheSuivante;
	}

	public void setContactSuivante(ContactChaine ficheSuivante) {
		this.ficheSuivante = ficheSuivante;
	}
	
	public boolean estDernierContact() {
		return this.ficheSuivante == null;
	}
	
}
