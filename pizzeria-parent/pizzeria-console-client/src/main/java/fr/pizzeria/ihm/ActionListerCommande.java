package fr.pizzeria.ihm;

import java.util.List;

import fr.pizzeria.model.Commande;
import fr.pizzeria.model.CommandePizza;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.tools.IhmTools;

@OptionMenu(afficherSansLogin = false)
public class ActionListerCommande extends Action {

	@Override
	void faireAction(IhmTools ihmTools) {

		List<Commande> lCom = ihmTools.getCommandeDao().findAll();

		List<CommandePizza> lComPizz = ihmTools.getCommandePizzaDao().findAll();

		List<Pizza> lPizz = ihmTools.getPizzaDao().findAll();

		// Ca c'est VRAIMENT pas bien, il faut rajouter une fonction au DOA pour
		// faire
		// une bonne query

		for (Commande commande : lCom) {
			if (commande.getClient().getId() == ihmTools.getClient().getId()) {

				System.out.println("COMMANDE NUMERO " + commande.getId());
				System.out.println("VOUS AVEZ COMMANDE " + commande.getId());

				for (CommandePizza commandePizza : lComPizz) {
					if (commandePizza.getCommande().getId() == commande.getId()) {

						// Ca c'est VRAIMENT VRAIMENT PAS BIEN
						System.out.println("UNE " + lPizz.get(commandePizza.getPizza().getId() - 1));

					}

				}

			}
		}

	}

	@Override
	String getLibelle() {
		return "LISTER SES COMMANDES !!!!!!!!!!!!!!!";
	}

}
