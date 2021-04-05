package service;

import java.util.ArrayList;
import java.util.List;

import model.Report;

public class Utilities {
	
	public static List<Report> reportsViewForm(List<Report> reports) {
		
		List<Report> reportsViewForm = new ArrayList<Report>();
		
		for(Report report : reports) {
			report.setWeekOfTheYear("Year: " + report.getWeekOfTheYear().substring(0, 4) + ", week: " + report.getWeekOfTheYear().substring(6));
			report.setVaccine(vaccineName(report.getVaccine()));
			report.setTargetGroup(targetGroupName(report.getTargetGroup()));
			reportsViewForm.add(report);
		}
		
		return reportsViewForm;
		
	}
	
	public static String vaccineName(String vaccine) {
		
		String vaccineName = "";
		
		switch (vaccine) {
		case "COM":
			vaccineName = "Pfizer";
			break;
		case "MOD":
			vaccineName = "Moderna";
			break;
		case "CN":
			vaccineName = "CNBG";
			break;
		case "SIN":
			vaccineName = "Sinovac";
			break;
		case "SPU":
			vaccineName = "Sputnik V";
			break;
		case "AZ":
			vaccineName = "AstraZeneca";
			break;
		case "UNK":
			vaccineName = "UNKNOWN";
			break;
		}
		
		return vaccineName;
		
	}
	
	public static String vaccineCode(String vaccineName) {
		
		String vaccineCode = "";
		
		switch (vaccineName) {
		case "Pfizer":
			vaccineCode = "COM";
			break;
		case "Moderna":
			vaccineCode = "MOD";
			break;
		case "CNBG":
			vaccineCode = "CN";
			break;
		case "Sinovac":
			vaccineCode = "SIN";
			break;
		case "Sputnik V":
			vaccineCode = "SPU";
			break;
		case "AstraZeneca":
			vaccineCode = "AZ";
			break;
		case "UNKNOWN":
			vaccineCode = "UNK";
			break;
		}
		
		return vaccineCode;
		
	}
	
	public static String targetGroupName(String targetGroup) {
		
		String targetGroupName = "";
		
		switch (targetGroup) {
		case "ALL":
			targetGroupName = "Overall";
			break;
		case "HCW":
			targetGroupName = "Healthcare workers";
			break;
		case "LTCF":
			targetGroupName = "Residents in long term care facilities";
			break;
		case "Age18_24":
			targetGroupName = "18-24 year-olds";
			break;
		case "Age25_49":
			targetGroupName = "25-49 year-olds";
			break;
		case "Age50_59":
			targetGroupName = "50-59 year-olds";
			break;
		case "Age60_69":
			targetGroupName = "60-69 year-olds";
			break;
		case "Age70_79":
			targetGroupName = "70-79 year-olds";
			break;
		case "Age80+":
			targetGroupName = "80 years and over";
			break;
		case "AgeUNK":
			targetGroupName = "Unknown age";
			break;
		case "1_Age<60":
			targetGroupName = "below 60 years of age";
			break;
		case "1_Age60+":
			targetGroupName = "60 years and over";
			break;
		}
		
		return targetGroupName;
		
	}
	
	public static List<String> countriesFullNames(List<String> countryNames) {
		
		List<String> countriesFullNames = new ArrayList<String>();
		
		for(String countryName : countryNames) {
			switch (countryName) {
			case "AT":
				countriesFullNames.add("Austria");
				break;
			case "BE":
				countriesFullNames.add("Belgium");
				break;
			case "BG":
				countriesFullNames.add("Bulgaria");
				break;
			case "CY":
				countriesFullNames.add("Cyprus");
				break;
			case "CZ":
				countriesFullNames.add("Czechia");
				break;
			case "DE":
				countriesFullNames.add("Germany");
				break;
			case "DK":
				countriesFullNames.add("Denmark");
				break;
			case "EE":
				countriesFullNames.add("Estonia");
				break;
			case "EL":
				countriesFullNames.add("Greece");
				break;
			case "ES":
				countriesFullNames.add("Spain");
				break;
			case "FI":
				countriesFullNames.add("Finland");
				break;
			case "FR":
				countriesFullNames.add("France");
				break;
			case "HR":
				countriesFullNames.add("Croatia");
				break;
			case "HU":
				countriesFullNames.add("Hungary");
				break;
			case "IE":
				countriesFullNames.add("Ireland");
				break;
			case "IS":
				countriesFullNames.add("Iceland");
				break;
			case "IT":
				countriesFullNames.add("Italy");
				break;
			case "LI":
				countriesFullNames.add("Liechtenstein");
				break;
			case "LT":
				countriesFullNames.add("Lithuania");
				break;
			case "LU":
				countriesFullNames.add("Luxembourg");
				break;
			case "LV":
				countriesFullNames.add("Latvia");
				break;
			case "MT":
				countriesFullNames.add("Malta");
				break;
			case "NL":
				countriesFullNames.add("Netherlands");
				break;
			case "NO":
				countriesFullNames.add("Norway");
				break;
			case "PL":
				countriesFullNames.add("Poland");
				break;
			case "PT":
				countriesFullNames.add("Portugal");
				break;
			case "RO":
				countriesFullNames.add("Romania");
				break;
			case "SE":
				countriesFullNames.add("Sweden");
				break;
			case "SI":
				countriesFullNames.add("Slovenia");
				break;
			case "SK":
				countriesFullNames.add("Slovakia");
				break;
			}
		}
		
		return countriesFullNames;
		
	}
	
public static String countryCode(String countryName) {
		
		String countryCode = "";
		
			switch (countryName) {
			case "Austria":
				countryCode = "AT";
				break;
			case "Belgium":
				countryCode = "BE";
				break;
			case "Bulgaria":
				countryCode = "BG";
				break;
			case "Cyprus":
				countryCode = "CY";
				break;
			case "Czechia":
				countryCode = "CZ";
				break;
			case "Germany":
				countryCode = "DE";
				break;
			case "Denmark":
				countryCode = "DK";
				break;
			case "Estonia":
				countryCode = "EE";
				break;
			case "Greece":
				countryCode = "EL";
				break;
			case "Spain":
				countryCode = "ES";
				break;
			case "Finland":
				countryCode = "FI";
				break;
			case "France":
				countryCode = "FR";
				break;
			case "Croatia":
				countryCode = "HR";
				break;
			case "Hungary":
				countryCode = "HU";
				break;
			case "Ireland":
				countryCode = "IE";
				break;
			case "Iceland":
				countryCode = "IS";
				break;
			case "Italy":
				countryCode = "IT";
				break;
			case "Liechtenstein":
				countryCode = "LI";
				break;
			case "Lithuania":
				countryCode = "LT";
				break;
			case "Luxembourg":
				countryCode = "LU";
				break;
			case "Latvia":
				countryCode = "LV";
				break;
			case "Malta":
				countryCode = "MT";
				break;
			case "Netherlands":
				countryCode = "NL";
				break;
			case "Norway":
				countryCode = "NO";
				break;
			case "Poland":
				countryCode = "PL";
				break;
			case "Portugal":
				countryCode = "PT";
				break;
			case "Romania":
				countryCode = "RO";
				break;
			case "Sweden":
				countryCode = "SE";
				break;
			case "Slovenia":
				countryCode = "SI";
				break;
			case "Slovakia":
				countryCode = "SK";
				break;
			}
		
		return countryCode;
		
	}
	
}
