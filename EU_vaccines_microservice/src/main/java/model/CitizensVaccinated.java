package model;

public class CitizensVaccinated {
	
	private String vaccine;
	private int population;
	private int populationVaccinatedByVaccine;
	private double percentCitizensVaccinatedByVaccine;
	private double totalVaccinated;
	
	public CitizensVaccinated() {
		super();
	}

	public CitizensVaccinated(String vaccine, int population, int populationVaccinatedByVaccine, double percentCitizensVaccinatedByVaccine, double totalVaccinated) {
		super();
		this.vaccine = vaccine;
		this.population = population;
		this.populationVaccinatedByVaccine = populationVaccinatedByVaccine;
		this.percentCitizensVaccinatedByVaccine = percentCitizensVaccinatedByVaccine;
		this.totalVaccinated = totalVaccinated;
	}

	public int getPopulationVaccinatedByVaccine() {
		return populationVaccinatedByVaccine;
	}

	public void setPopulationVaccinatedByVaccine(int populationVaccinatedByVaccine) {
		this.populationVaccinatedByVaccine = populationVaccinatedByVaccine;
	}

	public double getPercentCitizensVaccinatedByVaccine() {
		return percentCitizensVaccinatedByVaccine;
	}

	public void setPercentCitizensVaccinatedByVaccine(double percentCitizensVaccinatedByVaccine) {
		this.percentCitizensVaccinatedByVaccine = percentCitizensVaccinatedByVaccine;
	}

	public String getVaccine() {
		return vaccine;
	}

	public void setVaccine(String vaccine) {
		this.vaccine = vaccine;
	}

	public double getTotalVaccinated() {
		return totalVaccinated;
	}

	public void setTotalVaccinated(double totalVaccinated) {
		this.totalVaccinated = totalVaccinated;
	}

	public int getPopulation() {
		return population;
	}

	public void setCountryName(int population) {
		this.population = population;
	}
	
}
