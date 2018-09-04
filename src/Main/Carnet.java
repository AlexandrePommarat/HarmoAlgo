package Main;

import java.util.Scanner;

public class Carnet {

	private Fiche[] fiches;
	private int taille;

	/**
	 * 
	 * @param taille
	 */
	public Carnet(int taille) {
		if (taille > 0) {
			this.taille = taille;
		} else {
			this.taille = 2;
		}

		this.fiches = new Fiche[this.taille];
	}

	/**
	 * Méthode qui créé et ajoute une nouvelle fiche si il reste de la place,
	 * sinon ne fais rien
	 * 
	 * @return la fiche créée
	 * @throws Exception
	 */
	public Fiche nouvelleFiche() throws Exception {
		if (this.estRempli()) {
			throw new Exception("Carnet rempli !");
		} else {
			String prenom;
			String nom;
			String adresse;
			String tel;

			Scanner sc = new Scanner(System.in);

			System.out.println("Prénom : ");
			prenom = sc.nextLine();

			System.out.println("Nom : ");
			nom = sc.nextLine();

			Fiche f = new Fiche(prenom, nom);

			System.out.println("Adresse : ");
			adresse = sc.nextLine();
			f.setAdresse(adresse);

			System.out.println("Téléphone : ");
			tel = sc.nextLine();
			f.setTel(tel);

			this.fiches[this.getPlaceLibre()] = f;

			return f;
		}
	}

	/**
	 * Méthode permettant de calculer le nombre de fiches contenues
	 * 
	 * @return int - le nb de fiches contenues
	 */
	public int size() {
		int size;
		size = 0;
		for (int i = 0; i < this.fiches.length; i++) {
			if (this.fiches[i] != null)
				size++;
		}
		return size;
	}

	/**
	 * Méthode permettant de vérifier si le carnet est rempli
	 * 
	 * @return true si le carnet est rempli, sinon false s'il reste au moins une
	 *         place
	 */
	public boolean estRempli() {
		return this.size() == this.taille;
	}

	/**
	 * Méthode retournant le numéro d'une place libre, s'il n'y en a pas,
	 * retourne -1
	 * 
	 * @return numéro d'une place libre, -1 s'il n'y en a pas
	 */
	public int getPlaceLibre() {
		if (this.size() >= this.taille) {
			return -1;
		}

		return size();
	}

	public Fiche getFiche(int num) {
		return this.fiches[num];
	}

	public void afficherFiches() {
		for (int i = 0; i < this.size(); i++) {
			System.out.println("----------------------");
			System.out.println(i + " : " + this.getFiche(i));
			System.out.println("----------------------");
		}
	}

}
