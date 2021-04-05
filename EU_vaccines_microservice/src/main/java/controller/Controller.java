package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import model.CitizensVaccinated;
import model.Report;
import service.ReportService;

@CrossOrigin("*")
@RestController
public class Controller {
	@Autowired
	private ReportService service;
	
	@GetMapping(value = "vaccineNames", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<String> vaccineNames() {
		return service.vaccines();
	}
	
	@GetMapping(value = "countryNames", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<String> countryNames() {
		return service.countries();
	}
	
	@GetMapping(value = "reportsByCountryName", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Report> reportsByCountryName(@RequestParam("countryName") String countryName) {
		return service.reportsByCountry(countryName);
	}
	
	@GetMapping(value = "reportsByCountryNameAndVaccine", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Report> reportsByCoutryAndVaccine(@RequestParam("countryName") String countryName, @RequestParam("vaccine") String vaccine) {
		return service.reportsByCountryAndVaccine(countryName, vaccine);
	}
	
	@GetMapping(value = "reportsByCountryVaccineAndTargetGroup", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Report> reportsByCountryVaccineAndTargetgroup(@RequestParam(value = "countryName") String countryName,
																			@RequestParam(value = "vaccine") String vaccine,
																			@RequestParam(value = "targetGroup") String targetGroup) {
		return service.reportsByCountryVaccineAndTargetGroup(countryName, vaccine, targetGroup);
	}
	
	@GetMapping(value = "populationVaccinated", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody double populationVaccinated(@RequestParam(value = "countryName") String countryName) {
		return service.populationVaccinated(countryName);
	}
	
	@GetMapping(value = "dosesReceived", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody int dosesReceived(@RequestParam(value = "countryName") String countryName) {
		return service.dosesReceivedByCountry(countryName);
	}
	
	@GetMapping(value = "populationEuVaccinated", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody double populationEU() {
		return service.populationEUVaccinated();
	}
	
	@GetMapping(value = "populationVaccinatedByVaccine", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody int populationVaccinatedByVaccine(@RequestParam("countryName") String countryName, @RequestParam("vaccine") String vaccine) {
		return service.populationVaccinatedByVaccine(countryName, vaccine);
	}
	
	@GetMapping(value = "vaccinatedByCountryAndVaccine", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody double vaccinatedByCountryAndVaccine(@RequestParam("countryName") String countryName, @RequestParam("vaccine") String vaccine) {
		return service.vaccinatedByCountryAndVaccine(countryName, vaccine);
	}
	
	@GetMapping(value = "citizensVaccinated", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody CitizensVaccinated citizensVaccinated(@RequestParam("countryName") String countryName, @RequestParam("vaccine") String vaccine) {
		return service.citizensVaccinated(countryName, vaccine);
	}
	
	@GetMapping(value = "countryPopulation", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody int countryPopulation(@RequestParam("countryName") String countryName) {
		return service.population(countryName);
	}

}
