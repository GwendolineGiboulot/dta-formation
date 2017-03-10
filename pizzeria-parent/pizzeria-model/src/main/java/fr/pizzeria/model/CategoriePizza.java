package fr.pizzeria.model;

/**
 * @author Quelqun
 *
 */
public enum CategoriePizza {
	VIANDE("Viande"), POISSON("Poisson"), SANS_VIANDE("Sans Viande");

	private String libelle;

	private CategoriePizza(String libelle) {
		this.libelle = libelle;
	}

	public String getLibelle() {
		return libelle;
	}

	/**
	 * @param value
	 * @return
	 */
	public static CategoriePizza getEnum(String value) {
		for (CategoriePizza v : values())
			if (v.getLibelle().equalsIgnoreCase(value))
				return v;
		throw new IllegalArgumentException();
	}

	@Override
	public String toString() {
		return this.getLibelle();
	}

}
