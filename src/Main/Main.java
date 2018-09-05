package Main;

import java.util.Scanner;

import listefiche.FicheChaine;
import listefiche.ListeFiche;

public class Main {

	public static void main(String[] args) {

		boolean quitter = false;
		final ListeFiche listeFiche = new ListeFiche();
		listeFiche.ajouterFiche(new FicheChaine("Alexandre", "Pommarat"));
		listeFiche.ajouterFiche(new FicheChaine("Gael", "Dim"));

		while (!quitter) {
			System.out.println("\n---------------------------------------");
			System.out.println("Selectionnez une action a effectuer:");
			System.out.println("A. Afficher fiches");
			System.out.println("B. Afficher une fiche");
			System.out.println("C. Ajouter une fiche");
			System.out.println("D. Supprimer une fiche");
			System.out.println("E. Rechercher une fiche");
			System.out.println("F. Trier le tableau");
			System.out.println("G. Quitter");
			System.out.println("---------------------------------------\n");

			Scanner sc = new Scanner(System.in);
			char reponse;

			System.out.println("\nRéponse : ");
			// Récupération de la réponse en majuscule
			reponse = Character.toUpperCase(sc.nextLine().charAt(0));

			switch (reponse) {
			case 'G':
				quitter = true;
				break;

			case 'A':
				afficherFiches(listeFiche);
				break;

			case 'B':
				System.out.println("Afficher la fiche numéro : ");
				final int index = sc.nextInt();
				Fiche f = listeFiche.getFiche(index);
				if (f == null) {
					System.out.println("Ce contact n'existe pas !");
				} else {
					//Affichage de la fiche
					afficherFiche(f);
				}

			default:
				System.out.println("Reponse inconnue");
			}
		}

		System.out.println("Au revoir !!");

	}

	private static void afficherFiche(Fiche f) {
		
	}

	private static void afficherFiches(ListeFiche listeFiche) {
		if (!listeFiche.isEmpty()) {
			FicheChaine f = listeFiche.getFicheChaine(1);
			int indexFiche = 1;
			System.out.println("\n-----------------------");
			do {
				System.out.println(indexFiche + " : " + f.getPrenom() + " " + f.getNom());
				f = f.getFicheSuivante();
				indexFiche++;
			} while (f != null);
			System.out.println("-----------------------\n");

		} else {
			System.out.println("Vous n'avez pas de fiches d'adresses !");
		}

	}

}
