package fr.pizzeria.model;

public enum CategoriePizza {
	VIANDE("Viande"), POISSON("Poisson"), SANS_VIANDE("Sans Viande");

	private String libelle;

	public String getLibelle() {
		return libelle;
	}

	private CategoriePizza(String libelle) {
		this.libelle = libelle;
	}

	public static CategoriePizza getEnum(String value) {
		for (CategoriePizza v : values())
			if (v.getLibelle().equalsIgnoreCase(value))
				return v;
		throw new IllegalArgumentException();
	}

	public String toString() {
		return this.getLibelle();
	}

}
