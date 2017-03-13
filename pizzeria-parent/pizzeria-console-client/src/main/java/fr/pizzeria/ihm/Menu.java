package fr.pizzeria.ihm;

import java.util.HashMap;
import java.util.Map;

import fr.pizzeria.exception.IhmRuntimeException;
import fr.pizzeria.tools.IhmTools;

/**
 * @author Quelqun
 *
 */
public abstract class Menu {

	protected Map<Integer, Action> menuAction = new HashMap<>();

	public Menu() {

	}

	/**
	 * lance le menu principal
	 */
	public void demarrer() {

		System.out.println("PIZZERIA CLIENT !!!!!!!!!!!");

		try {

			int choix = 0;

			IhmTools ihmTools;

			ihmTools = new IhmTools();

			while (choix != 98) {

				menuAction.forEach((k, v) -> {

					if (!ihmTools.isEstConnecte() && v.getClass().getAnnotation(OptionMenu.class).afficherSansLogin()
							|| ihmTools.isEstConnecte()
									&& !v.getClass().getAnnotation(OptionMenu.class).afficherSansLogin()) {

						System.out.println(k + " : " + v.getLibelle());
					}

				});

				System.out.println("99 : Sortir");

				choix = ihmTools.getReader().nextInt();
				ihmTools.getReader().nextLine();

				if (choix == 99) {
					break;
				} else {
					if (choix > 0 && choix < menuAction.size() + 1)

						if (!ihmTools.isEstConnecte()
								&& menuAction.get(choix).getClass().getAnnotation(OptionMenu.class).afficherSansLogin()
								|| ihmTools.isEstConnecte() && !menuAction.get(choix).getClass()
										.getAnnotation(OptionMenu.class).afficherSansLogin()) {

							menuAction.get(choix).faireAction(ihmTools);
						}

				}

			}

			ihmTools.getReader().close();
		} catch (InstantiationException | IllegalAccessException |

				ClassNotFoundException e) {
			throw new IhmRuntimeException(e);
		}
	}

}
