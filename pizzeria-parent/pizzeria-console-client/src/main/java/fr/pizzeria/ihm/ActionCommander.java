package fr.pizzeria.ihm;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import fr.pizzeria.exception.IhmRuntimeException;
import fr.pizzeria.exception.SaveDaoException;
import fr.pizzeria.model.Commande;
import fr.pizzeria.model.CommandePizza;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.tools.IhmTools;

@OptionMenu(afficherSansLogin = false)
public class ActionCommander extends Action {

	public Date convertToDatabaseColumn(LocalDate locDate) {
		return (locDate == null ? null : Date.valueOf(locDate));
	}

	@Override
	void faireAction(IhmTools ihmTools) {
		System.out.println("COMBIEN DE PIZZA VOULEZ VOUS COMMENDER");
		int nombreCommande = ihmTools.getReader().nextInt();
		ihmTools.getReader().nextLine();

		Commande commande = new Commande(3612, "en cours", convertToDatabaseColumn(LocalDate.now()), null,
				ihmTools.getClient());

		try {
			ihmTools.getCommandeDao().saveNew(commande);
		} catch (SaveDaoException e) {
			throw new IhmRuntimeException(e);
		}

		for (int i = 0; i < nombreCommande; ++i) {
			System.out.println("IL TE RESTE " + (nombreCommande - i) + " PIZZA A COMMANDER");
			System.out.println("TU VEUX QUELLE PIZZA ??????????????");

			List<Pizza> lPizza = ihmTools.getPizzaDao().findAll();

			int j = 0;
			for (Pizza pizza : lPizza) {

				System.out.println(j++ + " : " + pizza.toString());
			}

			int choix = -1;

			while (choix < 0 || choix > lPizza.size() - 1) {
				choix = ihmTools.getReader().nextInt();
				ihmTools.getReader().nextLine();

				if (choix < 0 || choix > lPizza.size() - 1) {
					System.out.println("CETTE PIZZA N'EXISTE PAS !!!!!!!!!!!");
				}

			}
			System.out.println(
					"TU AS CHOISI LA " + lPizza.get(choix).getNom().toUpperCase() + " ,TRES BON CHOIX !!!!!!!!");

			CommandePizza comPiz = new CommandePizza(commande, lPizza.get(choix));

			try {
				ihmTools.getCommandePizzaDao().saveNew(comPiz);
			} catch (SaveDaoException e) {
				throw new IhmRuntimeException(e);
			}

		}

	}

	@Override
	String getLibelle() {
		return "COMMANDER UNE PIZZA !!!!!!!!!!!";
	}

}
