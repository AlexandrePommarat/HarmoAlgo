package liste_contacts;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Classe permettant de creer une liste de {@link ContactChaine} et de les
 * manipuler, fiches indexées en commençant par 1.
 * 
 * @author gael
 *
 */
public class ListeContact {

	/**
	 * La Premiere fiche
	 */
	private ContactChaine fiche;

	/**
	 * Constructeur de l'objet FicheChainee, il cree une nouvelle Contact chainee
	 * avec en parametre la premiere fiche
	 * 
	 * @param f la Contact qui deviendra la premiere fiche
	 */
	public ListeContact(ContactChaine f) {
		this.fiche = f;
	}

	/**
	 * Constructeur vide, créé une liste vide.
	 */
	public ListeContact() {
		this(null);
	}

	/**
	 * Cette methode permet d'ajouter une fiche
	 * 
	 * @param f
	 * @return
	 */
	public void ajouterContact(Contact f) {
		if (this.isEmpty()) {
			this.fiche = new ContactChaine(f);
		} else {
			ContactChaine derniereFiche = this.getDerniereFiche();
			derniereFiche.setContactSuivante(new ContactChaine(f));
		}
	}

	/**
	 * Méthode permettant de retirer une Contact de la liste
	 * 
	 * @param index de la Contact à enlever
	 */
	public void retirerContact(int index) {
		// si la Contact n'existe pas, la méthode s'arrête
		if (index == 1) {
			this.fiche = this.fiche.getContactSuivant();
		}
		else if (index > 1 && index <= this.getSize() && !this.isEmpty()) {
			ContactChaine avant = this.getFicheChaine(index - 1);
			ContactChaine supr = avant.getContactSuivant();
			avant.setContactSuivante(supr.getContactSuivant());
		}
	}

	/**
	 * Trie la liste par ordre alphabetique en fonction du nom de famille
	 */
	public void trier() {
		if (this.getSize() > 1) {
			boolean change = true;

			while (change) {
				change = false;
				for (int index = 1; index < this.getSize(); index++) {
					// On récupère un élement
					ContactChaine fc1 = this.getFicheChaine(index);
					// Puis on récupère l'élément qui le suit
					ContactChaine fc2 = fc1.getContactSuivant();

					// S'il faut les échanger (s'il faut que fc2 soit avant fc1)
					if (aEchanger(fc1, fc2)) {

						// Si l'échange se passe entre les deux premiers, le deuxième passe premier
						if (index == 1) {
							this.fiche = fc2;
						}

						// Echange des deux fiches
						if (index > 1) {
							ContactChaine fc0 = this.getFicheChaine(index - 1);
							fc0.setContactSuivante(fc2);
						}
						fc1.setContactSuivante(fc2.getContactSuivant());
						fc2.setContactSuivante(fc1);

						change = true;
					}
				}
			}
		}
	}

	/**
	 * Méthode permettant de rechercher dans les contacts.
	 * 
	 * @param recherche le mot à rechercher dans les contacts
	 * @return Une liste de Contact qui match avec la recherche
	 */
	public ListeContact recherche(String recherche) {
		final ListeContact result = new ListeContact();

		if (this.isEmpty()) {
			return result;
		}

		ContactChaine fc = this.getFicheChaine(1);
		while (!fc.estDernierContact()) {
			// On vérifie si fc match avec la recherche
			if (correspond(recherche, fc)) {
				result.ajouterContact(fc);
			}
			// Si ça match, on le rajoute dans result

			fc = fc.getContactSuivant();
		}
		// On vérifie si fc match avec la recherche une dernière fois
		if (correspond(recherche, fc)) {
			result.ajouterContact(fc);
		}

		return result;
	}

	/**
	 * Méthode permettant de vérifier si le mot recherche est contenu dans un des
	 * champs de la fiche
	 * 
	 * @param recherche le mot à rechercher
	 * @param Contact   la Contact à vérifier
	 * @return vrai si la recherche correspond, sinon retourne faux
	 */
	private boolean correspond(String recherche, ContactChaine fiche) {
		if (fiche == null) {
			return false;
		}

		recherche = recherche.toUpperCase();

		boolean result = false;
		// recherche dans toutes les catégories
		final String prenom = fiche.getPrenom().toUpperCase();
		final String nom = fiche.getNom().toUpperCase();
		final String tel = fiche.getTel().trim();
		final String adresse = fiche.getAdresse().toUpperCase();

		if (prenom.contains(recherche))
			result = true;
		else if (nom.contains(recherche))
			result = true;
		else if (tel.contains(recherche))
			result = true;
		else if (adresse.contains(recherche))
			result = true;

		return result;
	}

	/**
	 * Méthode qui détermine si f1 doit être avant ou après f2.
	 * 
	 * @param f1 première fiche
	 * @param f2 deuxième fiche
	 * @return true si f1 doit être après f2, sinon retourne faux
	 */
	private boolean aEchanger(Contact f1, Contact f2) {
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
	 * @param index index de la Contact choisie
	 * @return La Contact numéro index
	 */
	public ContactChaine getFicheChaine(int index) {
		if (index <= 0 || index > this.getSize() || this.isEmpty()) {
			throw new IllegalArgumentException("Ce contact n'existe pas");
		}

		// On parcourt toutes les fiches de la première à la dernière
		// index de la Contact en cours
		int indexRech = 1;

		ContactChaine result = this.fiche;

		while (indexRech < index) {
			result = result.getContactSuivant();
			indexRech++;
		}

		return result;
	}

	public Contact getContact(int index) {
		return (Contact) this.getFicheChaine(index);
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
		ContactChaine f = this.fiche;

		// Tant que la Contact suivante n'est pas la dernière fiche
		while (!f.estDernierContact()) {
			f = f.getContactSuivant();
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
	public ContactChaine getDerniereFiche() {
		if (this.isEmpty()) {
			return null;
		}

		ContactChaine f = this.fiche;

		// Tant que f n'est pas la dernière fiche
		while (!f.estDernierContact()) {
			f = f.getContactSuivant();
		}

		return f;
	}

	public void charger() {
		try {
			FileInputStream fis = new FileInputStream("basedetest.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			this.fiche = ((ContactChaine) ois.readObject());
			ois.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void sauvegarder() {
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
