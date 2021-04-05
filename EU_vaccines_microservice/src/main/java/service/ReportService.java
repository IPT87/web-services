package service;

import java.util.HashMap;
import java.util.List;

import model.CitizensVaccinated;
import model.Report;

public interface ReportService {
	List<Report> reportsByCountry(String countryName);
	List<Report> reportsByCountryAndVaccine(String countryName, String vaccine);
	List<Report> reportsByCountryVaccineAndTargetGroup(String countryName, String vaccine, String targetGroup);
	CitizensVaccinated citizensVaccinated(String countryName, String vaccine);
	void addVaccineNamesInBD();
	List<String> vaccines();
	void addCountriesNamesInBD();
	List<String> countries();
	double populationVaccinated(String countryName);
	double populationEUVaccinated();
	int population(String countryName);
	int populationVaccinatedByVaccine(String countryName, String vaccine);
	void addPopulationEUVaccinatedInBD();
	HashMap<String, Integer> firstDosesByCountry(String countryName);
	int secondDosesByCountry(String countryName);
	double vaccinatedByCountryAndVaccine(String countryName, String vaccine);
	int dosesReceivedByCountry(String countryName);
}
