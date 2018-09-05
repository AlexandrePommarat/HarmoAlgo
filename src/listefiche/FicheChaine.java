package listefiche;

import Main.Fiche;

/**
 * Fiche chaine utilisée par la classe {@link ListeFiche}
 * @author gael
 *
 */
public class FicheChaine extends Fiche {
	
	/**
	 * Pointeur vers la fiche suivante
	 */
	private Fiche ficheSuivante;

	public FicheChaine(String prenom, String nom) {
		super(prenom, nom);
		this.ficheSuivante = null;
	}

	public FicheChaine(String prenom, String nom, String adresse, String tel) {
		super(prenom, nom, adresse, tel);
		this.ficheSuivante = null;
	}
	
	public FicheChaine(Fiche f) {
		super(f.getPrenom(), f.getNom(), f.getAdresse(), f.getTel());
		this.ficheSuivante = null;
	}

	public Fiche getFicheSuivante() {
		return ficheSuivante;
	}

	public void setFicheSuivante(Fiche ficheSuivante) {
		this.ficheSuivante = ficheSuivante;
	}
	
	public boolean estDerniereFiche() {
		return this.ficheSuivante == null;
	}
	
}
