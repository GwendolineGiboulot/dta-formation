package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.model.Pizza;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {

		Pizza tableauPizza[] = new Pizza[100];
		Pizza.nbPizzas = 0;

		tableauPizza[0] = new Pizza(0, "PEP", "Pépéroni", 12.50);
		tableauPizza[1] = new Pizza(1, "MAR", "Margherita", 14.00);
		tableauPizza[2] = new Pizza(2, "REI", "La Reine", 11.50);
		tableauPizza[3] = new Pizza(3, "FRO", "La 4 fromages", 12.00);
		tableauPizza[4] = new Pizza(4, "CAN", "La cannibale", 12.50);
		tableauPizza[5] = new Pizza(5, "SAV", "La savoyarde", 13.00);
		tableauPizza[6] = new Pizza(6, "ORI", "L’orientale", 13.50);
		tableauPizza[7] = new Pizza(7, "IND", "L’indienne", 14.00);

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
		String entreeString;
		Double entreeDouble;

		Scanner reader = new Scanner(System.in); // Reading from System.in

		while (choix != 99) {
			choix = reader.nextInt(); // Scans the next token of the input as an

			switch (choix) {
			case 1:
				for (int i = 0; i < Pizza.nbPizzas; ++i) {
					System.out.println(
							tableauPizza[i].code + " -> " + tableauPizza[i].nom + " (" + tableauPizza[i].prix + " €)");
				}
				System.out.println("-> " + Pizza.nbPizzas + " pizzas créées depuis l'initialisation du programme");

				break;
			case 2:

				if (Pizza.nbPizzas < 98) {

					System.out.println("Veuillez saisir le code");
					String code = reader.next();
					System.out.println("Veuillez saisir le nom (sans espace)");
					String nom = reader.next();
					System.out.println("Veuillez saisir le prix");
					double prix = reader.nextDouble();

					tableauPizza[Pizza.nbPizzas] = new Pizza(Pizza.nbPizzas, code, nom, prix);

				} else {
					System.out.println("Impossible de creer plus de pizza");
				}

				break;
			case 3:
				for (int i = 0; i < Pizza.nbPizzas; ++i) {
					System.out.println(
							tableauPizza[i].code + " -> " + tableauPizza[i].nom + " (" + tableauPizza[i].prix + " €)");
				}
				System.out.println("Veuillez choisir la pizza à modifier.");
				System.out.println("(99 pour abandonner).");

				entreeString = reader.next();

				if (entreeString != "99") {

					int trouve = 0;
					int num_pizza = -1;
					for (int i = 0; i < Pizza.nbPizzas; ++i) {

						if (tableauPizza[i].code.equals(entreeString)) {

							trouve = 1;
							num_pizza = i;
							break;
						}
					}

					if (trouve == 1) {

						System.out.println("Veuillez saisir le code");
						entreeString = reader.next();
						tableauPizza[num_pizza].code = entreeString;
						System.out.println("Veuillez saisir le nom (sans espace)");
						entreeString = reader.next();
						tableauPizza[num_pizza].nom = entreeString;
						System.out.println("Veuillez saisir le prix");
						entreeDouble = reader.nextDouble();
						tableauPizza[num_pizza].prix = entreeDouble;
					} else {
						System.out.println("cette pizza n'existe pas");

					}

				}

				break;
			case 4:
				for (int i = 0; i < Pizza.nbPizzas; ++i) {
					System.out.println(
							tableauPizza[i].code + " -> " + tableauPizza[i].nom + " (" + tableauPizza[i].prix + " €)");
				}
				System.out.println("Veuillez choisir la pizza à modifier.");
				System.out.println("(99 pour abandonner).");

				entreeString = reader.next();

				if (entreeString != "99") {

					int trouve = 0;
					int num_pizza = -1;
					for (int i = 0; i < Pizza.nbPizzas; ++i) {

						if (tableauPizza[i].code.equals(entreeString)) {

							trouve = 1;
							num_pizza = i;
							break;
						}
					}

					if (trouve == 1) {

						for (int i = num_pizza; i < Pizza.nbPizzas - 1; ++i) {

							tableauPizza[i].id = tableauPizza[i + 1].id;
							tableauPizza[i].code = tableauPizza[i + 1].code;
							tableauPizza[i].nom = tableauPizza[i + 1].nom;
							tableauPizza[i].prix = tableauPizza[i + 1].prix;

						}
						Pizza.nbPizzas--;
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
