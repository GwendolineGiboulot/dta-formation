package fr.pizzeria.model;

import java.lang.reflect.Field;

public class Pizza {

	public int id;
	public String code;
	@ToString(uppercase = true)
	public String nom;
	@ToString
	public double prix;
	public static int nbPizzas;
	public CategoriePizza categorie;

	public Pizza(int id, String code, String nom, double prix, CategoriePizza categorie) {
		this.id = id;
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.categorie = categorie;

		nbPizzas++;

	}

	public String toString() {

		String temp = "";
		try {
			for (Field champ : this.getClass().getDeclaredFields()) {

				ToString annotationTrouve = champ.getAnnotation((ToString.class));

				if (annotationTrouve != null) {

					if (champ.getAnnotation((ToString.class)).uppercase() == false) {

						temp += champ.get(this).toString();
					} else {
						temp += champ.get(this).toString().toUpperCase();
					}
				}

			}
		}

		catch (IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return temp;
	}

}
