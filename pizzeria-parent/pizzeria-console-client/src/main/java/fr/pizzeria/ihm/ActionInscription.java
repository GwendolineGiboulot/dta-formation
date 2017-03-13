package fr.pizzeria.ihm;

import fr.pizzeria.exception.IhmRuntimeException;
import fr.pizzeria.exception.SaveDaoException;
import fr.pizzeria.model.Client;
import fr.pizzeria.tools.IhmTools;

@OptionMenu(afficherSansLogin = true)
public class ActionInscription extends Action {

	@Override
	void faireAction(IhmTools ihmTools) {

		System.out.println("Veuillez saisir votre nom");

		String nom = ihmTools.getReader().nextLine();
		System.out.println("Veuillez saisir votre prénom");
		String prenom = ihmTools.getReader().nextLine();
		System.out.println("Veuillez saisir votre email");
		String email = ihmTools.getReader().nextLine();
		System.out.println("Veuillez saisir votre mot de passe");
		String motDePasse = ihmTools.getReader().nextLine();

		try {

			Client client = new Client(nom, prenom, email, motDePasse);

			ihmTools.getClientDao().saveNew(client);

			ihmTools.setClient(client);

			ihmTools.setEstConnecte(true);

		} catch (SaveDaoException e) {
			throw new IhmRuntimeException(e);
		}

	}

	@Override
	String getLibelle() {
		return "INSCRIPTION !!!!!";
	}

}
