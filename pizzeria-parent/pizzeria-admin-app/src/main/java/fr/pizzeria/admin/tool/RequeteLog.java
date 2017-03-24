package fr.pizzeria.admin.tool;

public class RequeteLog {

	private String chemin;
	private Long temps;

	public RequeteLog(String chemin, Long temps) {
		super();
		this.chemin = chemin;
		this.temps = temps;
	}

	public String getChemin() {
		return chemin;
	}

	public void setChemin(String chemin) {
		this.chemin = chemin;
	}

	public Long getTemps() {
		return temps;
	}

	public void setTemps(Long temps) {
		this.temps = temps;
	}

}
