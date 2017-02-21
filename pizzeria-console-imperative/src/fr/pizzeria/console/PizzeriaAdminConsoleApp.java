package fr.pizzeria.console;

import java.util.Scanner;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {

		// Initialisation des PIZZAS

		int taille_tableau = 8;

		String Tableau_Pizza[][] = new String[4][100];

		Tableau_Pizza[0][0] = "0";
		Tableau_Pizza[0][1] = "1";
		Tableau_Pizza[0][2] = "2";
		Tableau_Pizza[0][3] = "3";
		Tableau_Pizza[0][4] = "4";
		Tableau_Pizza[0][5] = "5";
		Tableau_Pizza[0][6] = "6";
		Tableau_Pizza[0][7] = "7";

		Tableau_Pizza[1][0] = "PEP";
		Tableau_Pizza[1][1] = "MAR";
		Tableau_Pizza[1][2] = "REI";
		Tableau_Pizza[1][3] = "FRO";
		Tableau_Pizza[1][4] = "CAN";
		Tableau_Pizza[1][5] = "SAV";
		Tableau_Pizza[1][6] = "ORI";
		Tableau_Pizza[1][7] = "IND";

		Tableau_Pizza[2][0] = "Pépéroni";
		Tableau_Pizza[2][1] = "Margherita";
		Tableau_Pizza[2][2] = "La Reine";
		Tableau_Pizza[2][3] = "La 4 fromages";
		Tableau_Pizza[2][4] = "La cannibale";
		Tableau_Pizza[2][5] = "La savoyarde";
		Tableau_Pizza[2][6] = "L’orientale";
		Tableau_Pizza[2][7] = "L’indienne";

		Tableau_Pizza[3][0] = "12.50";
		Tableau_Pizza[3][1] = "14.00";
		Tableau_Pizza[3][2] = "11.50";
		Tableau_Pizza[3][3] = "12.00";
		Tableau_Pizza[3][4] = "12.50";
		Tableau_Pizza[3][5] = "13.00";
		Tableau_Pizza[3][6] = "13.50";
		Tableau_Pizza[3][7] = "14.00";

		System.out.println("***** Pizzeria Administration *****");
		System.out.println("1. Lister les pizzas");
		System.out.println("2. Ajouter une nouvelle pizza");
		System.out.println("3. Mettre à jour une pizza");
		System.out.println("4. Supprimer une pizza");
		System.out.println("99. Sortir");

		int choix = 0;
		String entree;

		Scanner reader = new Scanner(System.in); // Reading from System.in

		while (choix != 99) {
			choix = reader.nextInt(); // Scans the next token of the input as an

			switch (choix) {
			case 1:
				for (int i = 0; i < taille_tableau; ++i) {
					System.out.println(
							Tableau_Pizza[1][i] + " -> " + Tableau_Pizza[2][i] + " (" + Tableau_Pizza[3][i] + " €)");
				}
				break;
			case 2:

				if (taille_tableau < 98) {

					System.out.println("Veuillez saisir le code");
					entree = reader.next();
					Tableau_Pizza[1][taille_tableau] = entree;
					System.out.println("Veuillez saisir le nom (sans espace)");
					entree = reader.next();
					Tableau_Pizza[2][taille_tableau] = entree;
					System.out.println("Veuillez saisir le prix");
					entree = reader.next();
					Tableau_Pizza[3][taille_tableau] = entree;

					Tableau_Pizza[0][taille_tableau] = String.valueOf(taille_tableau);

					taille_tableau++;
				} else {
					System.out.println("Impossible de creer plus de pizza");
				}

				break;
			case 3:
				for (int i = 0; i < taille_tableau; ++i) {
					System.out.println(
							Tableau_Pizza[1][i] + " -> " + Tableau_Pizza[2][i] + " (" + Tableau_Pizza[3][i] + " €)");
				}
				System.out.println("Veuillez choisir la pizza à modifier.");
				System.out.println("(99 pour abandonner).");

				choix = reader.nextInt();

				if (choix == 99) {
					choix = 0; // pour éviter que le programme finisse
								// complètement

				} else {
					if (choix > taille_tableau) {
						System.out.println("(cette pizza n'existe pas");
					} else {
						System.out.println("Veuillez saisir le code");
						entree = reader.next();
						Tableau_Pizza[1][choix] = entree;
						System.out.println("Veuillez saisir le nom (sans espace)");
						entree = reader.next();
						Tableau_Pizza[2][choix] = entree;
						System.out.println("Veuillez saisir le prix");
						entree = reader.next();
						Tableau_Pizza[3][choix] = entree;

					}

				}

				break;
			case 4:
				for (int i = 0; i < taille_tableau; ++i) {
					System.out.println(
							Tableau_Pizza[1][i] + " -> " + Tableau_Pizza[2][i] + " (" + Tableau_Pizza[3][i] + " €)");
				}
				System.out.println("Veuillez choisir la pizza à modifier.");
				System.out.println("(99 pour abandonner).");

				choix = reader.nextInt() - 1; // -1 parce que pour l'utilisateur
												// le tableau démarre de 1

				if (choix == 99) {
					choix = 0; // pour éviter que le programme finisse
								// complètement

				} else {
					if (choix > taille_tableau) {
						System.out.println("(cette pizza n'existe pas");
					} else {
						for (int i = choix; i < taille_tableau - 1; ++i) {

							Tableau_Pizza[0][i] = Tableau_Pizza[0][i + 1];
							Tableau_Pizza[1][i] = Tableau_Pizza[1][i + 1];
							Tableau_Pizza[2][i] = Tableau_Pizza[2][i + 1];
							Tableau_Pizza[3][i] = Tableau_Pizza[3][i + 1];

						}
						taille_tableau--;

					}
				}

				break;
			default:
				break;
			}

		}

		System.out.println("Au revoir");

	}

}
