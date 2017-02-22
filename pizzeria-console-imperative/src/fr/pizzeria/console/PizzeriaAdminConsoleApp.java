package fr.pizzeria.console;

import java.util.Scanner;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {

		int tailleTableau = 8;

		String tableauPizza[][] = new String[4][100];

		// Initialisation des PIZZAS
		tableauPizza[0][0] = "0";
		tableauPizza[0][1] = "1";
		tableauPizza[0][2] = "2";
		tableauPizza[0][3] = "3";
		tableauPizza[0][4] = "4";
		tableauPizza[0][5] = "5";
		tableauPizza[0][6] = "6";
		tableauPizza[0][7] = "7";

		tableauPizza[1][0] = "PEP";
		tableauPizza[1][1] = "MAR";
		tableauPizza[1][2] = "REI";
		tableauPizza[1][3] = "FRO";
		tableauPizza[1][4] = "CAN";
		tableauPizza[1][5] = "SAV";
		tableauPizza[1][6] = "ORI";
		tableauPizza[1][7] = "IND";

		tableauPizza[2][0] = "Pépéroni";
		tableauPizza[2][1] = "Margherita";
		tableauPizza[2][2] = "La Reine";
		tableauPizza[2][3] = "La 4 fromages";
		tableauPizza[2][4] = "La cannibale";
		tableauPizza[2][5] = "La savoyarde";
		tableauPizza[2][6] = "L’orientale";
		tableauPizza[2][7] = "L’indienne";

		tableauPizza[3][0] = "12.50";
		tableauPizza[3][1] = "14.00";
		tableauPizza[3][2] = "11.50";
		tableauPizza[3][3] = "12.00";
		tableauPizza[3][4] = "12.50";
		tableauPizza[3][5] = "13.00";
		tableauPizza[3][6] = "13.50";
		tableauPizza[3][7] = "14.00";

		System.out.println("***** Pizzeria Administration *****");

		System.out.println("              _....._   ");
		System.out.println("          _.:`.--|--.`:._   ");
		System.out.println("        .: .'\\o  | o /'. '.   ");
		System.out.println("       // '.  \\ o|  /  o '.\\   ");
		System.out.println("      //'._o'. \\ |o/ o_.-'o\\\\   ");
		System.out.println("      || o '-.'.\\|/.-' o   ||   ");
		System.out.println("      ||--o--o-->|<o-----o-||   ");
		System.out.println("      \\\\  o _.-'/|\\'-._o  o//   ");
		System.out.println("       \\\\.-'  o/ |o\\ o '-.//   ");
		System.out.println("        '.'.o / o|  \\ o.'.'   ");
		System.out.println("          `-:/.__|__o\\:-'   ");
		System.out.println("             `\"--=--\"`   ");

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
				for (int i = 0; i < tailleTableau; ++i) {
					System.out.println(
							tableauPizza[1][i] + " -> " + tableauPizza[2][i] + " (" + tableauPizza[3][i] + " €)");
				}
				break;
			case 2:

				if (tailleTableau < 98) {

					System.out.println("Veuillez saisir le code");
					entree = reader.next();
					tableauPizza[1][tailleTableau] = entree;
					System.out.println("Veuillez saisir le nom (sans espace)");
					entree = reader.next();
					tableauPizza[2][tailleTableau] = entree;
					System.out.println("Veuillez saisir le prix");
					entree = reader.next();
					tableauPizza[3][tailleTableau] = entree;

					tableauPizza[0][tailleTableau] = String.valueOf(tailleTableau);

					tailleTableau++;
				} else {
					System.out.println("Impossible de creer plus de pizza");
				}

				break;
			case 3:
				for (int i = 0; i < tailleTableau; ++i) {
					System.out.println(
							tableauPizza[1][i] + " -> " + tableauPizza[2][i] + " (" + tableauPizza[3][i] + " €)");
				}
				System.out.println("Veuillez choisir la pizza à modifier.");
				System.out.println("(99 pour abandonner).");

				entree = reader.next();

				if (entree != "99") {

					int trouve = 0;
					int num_pizza = -1;
					for (int i = 0; i < tailleTableau; ++i) {

						if (tableauPizza[1][i].equals(entree)) {

							trouve = 1;
							num_pizza = i;
							break;
						}
					}

					if (trouve == 1) {

						System.out.println("Veuillez saisir le code");
						entree = reader.next();
						tableauPizza[1][num_pizza] = entree;
						System.out.println("Veuillez saisir le nom (sans espace)");
						entree = reader.next();
						tableauPizza[2][num_pizza] = entree;
						System.out.println("Veuillez saisir le prix");
						entree = reader.next();
						tableauPizza[3][num_pizza] = entree;
					} else {
						System.out.println("cette pizza n'existe pas");

					}

				}

				break;
			case 4:
				for (int i = 0; i < tailleTableau; ++i) {
					System.out.println(
							tableauPizza[1][i] + " -> " + tableauPizza[2][i] + " (" + tableauPizza[3][i] + " €)");
				}
				System.out.println("Veuillez choisir la pizza à modifier.");
				System.out.println("(99 pour abandonner).");

				entree = reader.next();

				if (entree != "99") {

					int trouve = 0;
					int num_pizza = -1;
					for (int i = 0; i < tailleTableau; ++i) {

						if (tableauPizza[1][i].equals(entree)) {

							trouve = 1;
							num_pizza = i;
							break;
						}
					}

					if (trouve == 1) {

						for (int i = num_pizza; i < tailleTableau - 1; ++i) {

							tableauPizza[0][i] = tableauPizza[0][i + 1];
							tableauPizza[1][i] = tableauPizza[1][i + 1];
							tableauPizza[2][i] = tableauPizza[2][i + 1];
							tableauPizza[3][i] = tableauPizza[3][i + 1];

						}
						tailleTableau--;
					} else {
						System.out.println("cette pizza n'existe pas");

					}

				}

				break;

			case 99:
				break;

			default:
				System.out.println("Commande inconnue");
				break;
			}

		}

		System.out.println("Au revoir");

	}

}
