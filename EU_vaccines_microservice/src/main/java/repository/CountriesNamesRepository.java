package repository;

import java.util.List;

import model.CountriesNamesEntity;

public interface CountriesNamesRepository {
	
	void addNewCountryName(CountriesNamesEntity countryName);
	List<String> countriesNames();
	void clearTable();
	
}
