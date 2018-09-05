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
		if(index == 1) {
			this.fiche = this.fiche.getFicheSuivante();
		}
		else if (index > 1 && index <= this.getSize() && !this.isEmpty()) {
			FicheChaine supr = this.getFicheChaine(index);
			FicheChaine avant = this.getFicheChaine(index - 1);
			avant.setFicheSuivante(supr.getFicheSuivante());
		}
	}

	/**
	 * Trie la liste en fonction du nom de famille
	 */
	public void trier() {

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
		
		
		//On parcourt toutes les fiches de la première à la dernière
		//index de la fiche en cours
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
		
		if(f == null) {
			return null;
		}
		
		return (Fiche)f;
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
