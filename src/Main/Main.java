package Main;

import java.util.Scanner;
import listefiche.FicheChaine;
import listefiche.ListeFiche;

public class Main {

	public static void main(String[] args) {
		boolean quitter = false;
		final ListeFiche listeFiche = new ListeFiche();


		while (!quitter) {
			System.out.println("\n---------------------------------------");
			System.out.println("Selectionnez une action a effectuer:");
			System.out.println("A. Afficher les contacts");
			System.out.println("B. Afficher un contact");
			System.out.println("C. Ajouter un contact");
			System.out.println("D. Supprimer un contact");
			System.out.println("E. Rechercher un contact");
			System.out.println("F. Trier les contacts");
			System.out.println("G. Sauvegarder les contacts");
			System.out.println("H. Charger une nouvelle liste de contacts");
			System.out.println("Q. Quitter");
			System.out.println("---------------------------------------\n");

			Scanner sc = new Scanner(System.in);
			char reponse;

			System.out.print("Réponse : ");
			// Récupération de la réponse en majuscule
			reponse = Character.toUpperCase(sc.nextLine().charAt(0));

			switch (reponse) {
			case 'Q':
				quitter = true;
				break;

			case 'A': // Afficher les contacts numerotees
				afficherFiches(listeFiche);
				break;

			case 'B':// Afficher un contact
				System.out.println("Afficher la fiche numéro : ");
				final int index = sc.nextInt();
				Fiche f = listeFiche.getFiche(index);
				if (f == null) {
					System.out.println("Ce contact n'existe pas !");
				} else {
					// Affichage de la fiche
					afficherFiche(f);
				}
				break;

			case 'C':// Saisir une nouvelle contact
				saisirUneFiche(listeFiche);
				break;

			case 'D':// Supprimer un contact
				System.out.print("Numero du contact a supprimer : ");
				int indexSuppr = sc.nextInt();
				if (indexSuppr <= 0 || indexSuppr > listeFiche.getSize()) {
					System.out.println("Le contact n'existe pas");
				} else {
					listeFiche.retirerFiche(indexSuppr);
					System.out.println("Contact supprime !");
				}
				break;

			case 'E': // Rechercher un contact
				break;

			case 'F': // Trier les contacts
				System.out.println("Tri en cours");
				listeFiche.trier();
				break;

			case 'G': // Sauvegarder
				if (listeFiche.isEmpty()) {
					System.out.println("Vous n'avez aucun contact, il n'y a rien a sauvegarder");
				} else {
					listeFiche.sauvegarder();
					System.out.println("Sauvegarde effectuee !");
				}
				break;

			case 'H': // Charger
				listeFiche.charger();
				break;

			default:
				System.out.println("Reponse inconnue");
			}
		}

		System.out.println("Au revoir !!");
	}

	private static void afficherFiche(Fiche f) {
		System.out.println("\n-----------------------");
		System.out.println("Contact :");
		System.out.println("Prenom : " + f.getPrenom());
		System.out.println("Nom : " + f.getNom());

		System.out.print("Telephone : ");
		if (f.aUnTelephone())
			System.out.println(f.getTel());
		else
			System.out.println("Inconnu");

		System.out.print("Adresse : ");
		if (f.aUneAdresse())
			System.out.println(f.getAdresse());
		else
			System.out.println("Inconnu");
		System.out.println("-----------------------\n");
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
			System.out.println("\nVous n'avez pas de fiches d'adresses !\n");
		}

	}

	private static void saisirUneFiche(ListeFiche listeFiche) {
		String prenom;
		String nom;
		String adresse;
		String tel;

		Scanner sc = new Scanner(System.in);

		System.out.println("Saisissez votre contact : (Ne rien mettre si vous voulez laisser vide)");

		System.out.print("Prenom : ");
		prenom = sc.nextLine();

		System.out.print("Nom : ");
		nom = sc.nextLine();

		Fiche f = new Fiche(prenom, nom);

		System.out.print("Adresse : ");
		adresse = sc.nextLine();
		f.setAdresse(adresse);

		System.out.print("Telephone : ");
		tel = sc.nextLine();
		while (tel.length() != 0 && tel.length() != 10) {
			System.out.print("Saisir un numero a dix chiffres : (ou ne rien saisir)");
			tel = sc.nextLine();
		}
		f.setTel(tel);

		listeFiche.ajouterFiche(f);
	}

}
