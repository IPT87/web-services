package service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import model.SetOfReports;
import model.VaccineNamesEntity;
import repository.CountriesNamesRepository;
import repository.EUCitizensVaccinatedRepository;
import repository.VaccineNameRepository;
import model.CountriesNamesEntity;
import model.EUCitizensVaccinatedEntity;
import model.Report;
import model.CitizensVaccinated;

@Service
public class ReportServiceImpl implements ReportService {
	private String url = "https://opendata.ecdc.europa.eu/covid19/vaccine_tracker/json/";
	
	@Autowired
	private RestTemplate template;
	
	@Autowired
	CountriesNamesRepository countriesRepository;
	
	@Autowired
	EUCitizensVaccinatedRepository euCitizensRepository;
	
	@Autowired
	VaccineNameRepository vaccineRepository;

	@Override
	public List<Report> reportsByCountry(String countryName) {
		
		SetOfReports set = template.getForObject(url, SetOfReports.class);
		
		if (set != null) {
			ArrayList<Report> reportsList = (ArrayList<Report>) Arrays.stream(set.getRecords())
							.filter(r -> r.getCountryName().equalsIgnoreCase(Utilities.countryCode(countryName)))		
							.collect(Collectors.toList());
			
			return Utilities.reportsViewForm(reportsList);
		} else {
			return new ArrayList<>();
		}
		
	}

	@Override
	public List<Report> reportsByCountryAndVaccine(String countryName, String vaccine) {
		
		SetOfReports set = template.getForObject(url, SetOfReports.class);

		if (set != null) {
			ArrayList<Report> reportsList = (ArrayList<Report>) Arrays.stream(set.getRecords())
										.filter(r -> r.getCountryName().equalsIgnoreCase(Utilities.countryCode(countryName)))
										.filter(r -> r.getVaccine().equalsIgnoreCase(Utilities.vaccineCode(vaccine)))
										.collect(Collectors.toList());
			
			return Utilities.reportsViewForm(reportsList);
		} else {
			return new ArrayList<>();
		}
		
	}

	@Override
	public List<Report> reportsByCountryVaccineAndTargetGroup(String countryName, String vaccine, String targetGroup) {

		SetOfReports set = template.getForObject(url, SetOfReports.class);
		
		return Arrays.stream(set.getRecords())
						.filter(r -> r.getCountryName().equalsIgnoreCase(countryName) && r.getVaccine().equalsIgnoreCase(vaccine) && r.getTargetGroup().equalsIgnoreCase(targetGroup))
						.collect(Collectors.toList());
	}
	
	@Scheduled(cron = "0 12 * * * ?")
	@Override
	public void addVaccineNamesInBD() {
		
		SetOfReports set = template.getForObject(url, SetOfReports.class);
		VaccineNamesEntity vaccineName;
		
		List<String> vaccines = Arrays.stream(set.getRecords())
										.map(r -> r.getVaccine())
										.distinct()
										.collect(Collectors.toList());
		
		vaccineRepository.clearTable();
		
		for(String vaccine : vaccines) {
			vaccineName = new VaccineNamesEntity(Utilities.vaccineName(vaccine));
			vaccineRepository.addNewCountryName(vaccineName);
		}
		
	}

	@Override
	public List<String> vaccines() {
		
		return vaccineRepository.vaccineNames();
	}

	@Override
	public int population(String countryName) {
		
		SetOfReports set = template.getForObject(url, SetOfReports.class);
		
		return Arrays.stream(set.getRecords())
						.filter(r -> r.getCountryName().equalsIgnoreCase(Utilities.countryCode(countryName)))
						.mapToInt(r -> r.getPopulation())
						.findFirst()
						.getAsInt();
	}

	@Override
	public HashMap<String, Integer> firstDosesByCountry(String countryName) {
		
		SetOfReports set = template.getForObject(url, SetOfReports.class);
		HashMap<String, Integer> firstDosesByWeek = new HashMap<>();
		
		Arrays.stream(set.getRecords())
				.filter(r -> r.getCountryName().equalsIgnoreCase(countryName))
				.forEach(r -> firstDosesByWeek.put(r.getWeekOfTheYear(), r.getFirstDose()));
		
		return firstDosesByWeek;
	}

	@Override
	public int secondDosesByCountry(String countryName) {
		
		SetOfReports set = template.getForObject(url, SetOfReports.class);
		
		return Arrays.stream(set.getRecords())
						.filter(r -> r.getCountryName().equalsIgnoreCase(Utilities.countryCode(countryName)))
						.mapToInt(r -> r.getSecondDose())
						.sum();
	}

	@Override
	public int dosesReceivedByCountry(String countryName) {
		
		SetOfReports set = template.getForObject(url, SetOfReports.class);
		
		return Arrays.stream(set.getRecords())
						.filter(r -> r.getCountryName().equalsIgnoreCase(countryName))
						.mapToInt(r -> r.getDosesReceived())
						.sum();
	}

	@Override
	public List<String> countries() {
		
		return countriesRepository.countriesNames();
		
	}
	
	@Scheduled(cron = "0 12 * * * ?")
	@Override
	public void addCountriesNamesInBD() {
		
		SetOfReports set = template.getForObject(url, SetOfReports.class);
		CountriesNamesEntity cName;
		
		List<String> countryNames = Arrays.stream(set.getRecords())
											.map(r -> r.getCountryName())
									 		.distinct()
									 		.collect(Collectors.toList());
		
		countryNames = Utilities.countriesFullNames(countryNames);
		
		countriesRepository.clearTable();
		
		for(String countryName : countryNames) {
			cName = new CountriesNamesEntity(countryName);
			countriesRepository.addNewCountryName(cName);
		}
		
	}

	@Override
	public double populationVaccinated(String countryName) {
		
		int population = population(countryName);
		int secondDosesByCountry = secondDosesByCountry(countryName);
		return ((double) secondDosesByCountry / population) * 100;
		
	}

	@Scheduled(cron = "0 12 * * * ?")
	@Override
	public void addPopulationEUVaccinatedInBD() {
		
		SetOfReports set = template.getForObject(url, SetOfReports.class);
		int populationEU = 0;
		int populationEUVaccinated = 0;
		List<String> countries = countries();
		
		for (String country : countries) {
			
			populationEU += Arrays.stream(set.getRecords())
									.filter(r -> r.getCountryName().equalsIgnoreCase(Utilities.countryCode(country)))
									.map(r -> r.getPopulation())
									.findFirst()
									.get();
		}
		
		for (String country : countries) {
			
			populationEUVaccinated += Arrays.stream(set.getRecords())
									.filter(r -> r.getCountryName().equalsIgnoreCase(Utilities.countryCode(country)))
									.mapToInt(r -> r.getSecondDose())
									.sum();
		}
		
		euCitizensRepository.clearTable();
		
		EUCitizensVaccinatedEntity euCitizensVaccinated = new EUCitizensVaccinatedEntity();
		euCitizensVaccinated.setEu_citizens_vaccinated(((double) populationEUVaccinated / populationEU) * 100);
		euCitizensRepository.addEUCitizensVaccinated(euCitizensVaccinated);
		
	}

	@Override
	public double populationEUVaccinated() {
		
		return euCitizensRepository.euCitizensVaccinated();
		
	}

	@Override
	public int populationVaccinatedByVaccine(String countryName, String vaccine) {
		
		SetOfReports set = template.getForObject(url, SetOfReports.class);
		
		return Arrays.stream(set.getRecords())
						.filter(r -> r.getCountryName().equalsIgnoreCase(Utilities.countryCode(countryName)))
						.filter(r -> r.getVaccine().equalsIgnoreCase(Utilities.vaccineCode(vaccine)))
						.mapToInt(r -> r.getSecondDose())
						.sum();
	}

	@Override
	public double vaccinatedByCountryAndVaccine(String countryName, String vaccine) {
		
		SetOfReports set = template.getForObject(url, SetOfReports.class);
		int population = population(countryName);
		
		int citizensVaccinated = Arrays.stream(set.getRecords())
										.filter(r -> r.getCountryName().equalsIgnoreCase(Utilities.countryCode(countryName)))
										.filter(r -> r.getVaccine().equalsIgnoreCase(Utilities.vaccineCode(vaccine)))
										.mapToInt(r -> r.getSecondDose())
										.sum();
		
		return ((double) citizensVaccinated / population) * 100;
		
	}

	@Override
	public CitizensVaccinated citizensVaccinated(String countryName, String vaccine) {
		
		CitizensVaccinated citizensVaccinated = new CitizensVaccinated(vaccine,
														population(countryName),
														populationVaccinatedByVaccine(countryName, vaccine),
														vaccinatedByCountryAndVaccine(countryName, vaccine), 
														populationVaccinated(countryName));
		
		return citizensVaccinated;
	}

}
