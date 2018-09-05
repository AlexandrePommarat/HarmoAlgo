package listefiche;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Main.Fiche;

/**
 * Classe permettant de creer une liste de {@link FicheChaine} et de les
 * manipuler, fiches indexées en commençant par 1.
 * 
 * @author gael
 *
 */
public class ListeFiche {

	/**
	 * La Premiere fiche
	 */
	private FicheChaine fiche;

	/**
	 * Constructeur de l'objet FicheChainee, il cree une nouvelle fiche chainee avec
	 * en parametre la premiere fiche
	 * 
	 * @param f la fiche qui deviendra la premiere fiche
	 */
	public ListeFiche(FicheChaine f) {
		this.fiche = f;
	}

	/**
	 * Constructeur vide, créé une liste vide.
	 */
	public ListeFiche() {
		this(null);
	}

	/**
	 * Cette methode permet d'ajouter une fiche
	 * 
	 * @param f
	 * @return
	 */
	public void ajouterFiche(Fiche f) {
		if (this.isEmpty()) {
			this.fiche = new FicheChaine(f);
		} else {
			FicheChaine derniereFiche = this.getDerniereFiche();
			derniereFiche.setFicheSuivante(new FicheChaine(f));
		}
	}

	/**
	 * Méthode permettant de retirer une fiche de la liste
	 * 
	 * @param index de la fiche à enlever
	 */
	public void retirerFiche(int index) {
		// si la fiche n'existe pas, la méthode s'arrête
		if (index == 1) {
			this.fiche = this.fiche.getFicheSuivante();
		} else if (index > 1 && index <= this.getSize() && !this.isEmpty()) {
			FicheChaine supr = this.getFicheChaine(index);
			FicheChaine avant = this.getFicheChaine(index - 1);
			avant.setFicheSuivante(supr.getFicheSuivante());
		}
	}

	/**
	 * Trie la liste par ordre alphabetique en fonction du nom de famille
	 */
	public void trier() {
		// tri à bulle : trier deux éléments à la fois jusqu'à ce qu'aucun changements
		// n'est effectué
		if (this.getSize() > 1) {
			// Si change est true, c'est qu'il y a eu un changement
			boolean change = true;

			while (change) {
				change = false;
				// On parcourt tout les éléments
				for (int index = 1; index < this.getSize(); index++) {
					// On récupère un élement
					FicheChaine fc1 = this.getFicheChaine(index);
					// Puis on récupère l'élément qui le suit
					FicheChaine fc2 = fc1.getFicheSuivante();

					// S'il faut les échanger (s'il faut que fc2 soit avant fc1)
					if (aEchanger(fc1, fc2)) {

						// Si l'échange se passe entre les deux premiers, le deuxième passe premier
						if (index == 1) {
							this.fiche = fc2;
						}

						// Echange des deux fiches
						if (index > 1) {
							FicheChaine fc0 = this.getFicheChaine(index - 1);
							fc0.setFicheSuivante(fc2);
						}
						fc1.setFicheSuivante(fc2.getFicheSuivante());
						fc2.setFicheSuivante(fc1);

						change = true;
					}
				}
			}
		}

	}

	/**
	 * Méthode qui détermine si f1 doit être avant ou après f2.
	 * 
	 * @param f1 première fiche
	 * @param f2 deuxième fiche
	 * @return true si f1 doit être après f2, sinon retourne faux
	 */
	private boolean aEchanger(Fiche f1, Fiche f2) {
		boolean echanger = false;

		int charCompare = 0;

		// Tant que les lettres dans le nom sont les mêmes et qu'il reste des lettres,
		// on passe à la lettre
		// suivante
		while (f1.getNom().toUpperCase().charAt(charCompare) == f2.getNom().toUpperCase().charAt(charCompare)) {
			charCompare++;

			// Si on est arrivé à la fin d'un des nom
			if (charCompare == f1.getNom().length() - 1 || charCompare == f2.getNom().length() - 1) {
				// Ils sont imcomparables
				return false;
			}
		}

		final int intCharF1 = (int) f1.getNom().toUpperCase().charAt(charCompare);
		final int intCharF2 = (int) f2.getNom().toUpperCase().charAt(charCompare);

		return intCharF1 > intCharF2; // Testé et approuvé
	}

	/**
	 * Méthode permettant de récuperer une des fiches
	 * 
	 * @param index index de la fiche choisie
	 * @return La fiche numéro index
	 */
	public FicheChaine getFicheChaine(int index) {
		// Si l'index n'est pas dans la liste OU si la liste est vide
		if (index <= 0 || index > this.getSize() || this.isEmpty()) {
			return null;
		}

		// On parcourt toutes les fiches de la première à la dernière
		// index de la fiche en cours
		int indexRech = 1;

		FicheChaine result = this.fiche;

		while (indexRech < index) {
			result = result.getFicheSuivante();
			indexRech++;
		}

		return result;
	}

	public Fiche getFiche(int index) {
		final FicheChaine f = this.getFicheChaine(index);

		if (f == null) {
			return null;
		}

		return (Fiche) f;
	}

	/**
	 * Méthode permettant de calculer la taille de la liste de fiches
	 * 
	 * @return le nombre de fiches contenues
	 */
	public int getSize() {
		if (this.isEmpty()) {
			return 0;
		}

		int size = 1;
		FicheChaine f = this.fiche;

		// Tant que la fiche suivante n'est pas la dernière fiche
		while (!f.estDerniereFiche()) {
			f = f.getFicheSuivante();
			size++;
		}

		return size;
	}

	public boolean isEmpty() {
		return this.fiche == null;
	}

	/**
	 * Methode pour recuperer la derniere fiche
	 * 
	 * @return
	 */
	public FicheChaine getDerniereFiche() {
		if (this.isEmpty()) {
			return null;
		}

		FicheChaine f = this.fiche;

		// Tant que f n'est pas la dernière fiche
		while (!f.estDerniereFiche()) {
			f = f.getFicheSuivante();
		}

		return f;
	}

	public void charger(){
		// des�rialisation
	      try {
	         FileInputStream fis = new FileInputStream("basedetest.txt");
	         ObjectInputStream ois = new ObjectInputStream(fis);
	         this.fiche = ((FicheChaine) ois.readObject());
	         ois.close();
	      } catch (Exception e) { 
	         e.printStackTrace(); 
	      }
	}
	
	public void sauvegarder(){
		try {
	         FileOutputStream fs = new FileOutputStream("basedetest.txt");
	         ObjectOutputStream os = new ObjectOutputStream(fs);
	         os.writeObject(this.getFicheChaine(1)); 
	         os.close();
	      } catch (Exception e) { 
	         e.printStackTrace(); 
	      }
	}

}
