package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Report {
	@JsonProperty(value = "YearWeekISO")
	private String weekOfTheYear;
	@JsonProperty(value = "FirstDose")
	private int firstDose;
	@JsonProperty(value = "SecondDose")
	private int secondDose;
	@JsonProperty(value = "ReportingCountry")
	private String countryName;
	@JsonProperty(value = "Population")
	private int population;
	@JsonProperty(value = "Vaccine")
	private String vaccine;
	@JsonProperty(value = "NumberDosesReceived")
	private int dosesReceived;
	@JsonProperty(value = "TargetGroup")
	private String targetGroup;
	
	public Report() {
		super();
	}
	
	public Report(String weekOfTheYear, int firstDose, int secondDose, String countryName, int population, String vaccine, int dosesReceived, String targetGroup) {
		this.weekOfTheYear = weekOfTheYear;
		this.firstDose = firstDose;
		this.secondDose = secondDose;
		this.countryName = countryName;
		this.population = population;
		this.vaccine = vaccine;
		this.dosesReceived = dosesReceived;
		this.targetGroup = targetGroup;
	}
	
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	
	public String getCountryName() {
		return this.countryName;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public String getVaccine() {
		return vaccine;
	}

	public void setVaccine(String vaccine) {
		this.vaccine = vaccine;
	}

	public int getDosesReceived() {
		return dosesReceived;
	}

	public void setDosesReceived(int dosesReceived) {
		this.dosesReceived = dosesReceived;
	}

	public String getWeekOfTheYear() {
		return weekOfTheYear;
	}

	public void setWeekOfTheYear(String weekOfTheYear) {
		this.weekOfTheYear = weekOfTheYear;
	}

	public int getFirstDose() {
		return firstDose;
	}

	public void setFirstDose(int firstDose) {
		this.firstDose = firstDose;
	}

	public int getSecondDose() {
		return secondDose;
	}

	public void setSecondDose(int secondDose) {
		this.secondDose = secondDose;
	}

	public String getTargetGroup() {
		return targetGroup;
	}

	public void setTargetGroup(String targetGroup) {
		this.targetGroup = targetGroup;
	}
	
}
