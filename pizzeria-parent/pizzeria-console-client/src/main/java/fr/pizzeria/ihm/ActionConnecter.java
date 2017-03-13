package fr.pizzeria.ihm;

import java.util.List;

import fr.pizzeria.model.Client;
import fr.pizzeria.tools.IhmTools;

@OptionMenu(afficherSansLogin = true)
public class ActionConnecter extends Action {

	@Override
	void faireAction(IhmTools ihmTools) {

		System.out.println("Veuillez saisir votre email");
		String email = ihmTools.getReader().nextLine();
		System.out.println("Veuillez saisir votre mot de passe");
		String motDePasse = ihmTools.getReader().nextLine();

		List<Client> lClient = ihmTools.getClientDao().findAll();

		for (Client client : lClient) {
			if (client.getEmail().equals(email) && client.getMotDePasse().equals(motDePasse)) {

				ihmTools.setClient(client);
				ihmTools.setEstConnecte(true);

			}
		}

	}

	@Override
	String getLibelle() {

		return "SE CONNECTER !!!!!!!!!!";
	}

}
