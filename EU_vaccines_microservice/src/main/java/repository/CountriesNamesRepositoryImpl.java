package repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.CountriesNamesEntity;

@Repository
public class CountriesNamesRepositoryImpl implements CountriesNamesRepository {
	
	@Autowired
	CountriesNamesRepositoryJpa repository;

	@Override
	public void addNewCountryName(CountriesNamesEntity countryName) {
		repository.save(countryName);
	}

	@Override
	public List<String> countriesNames() {
		
		List<CountriesNamesEntity> countries = repository.findAll();
		List<String> countriesNames = new ArrayList<String>();
		
		for(CountriesNamesEntity cName : countries) {
			countriesNames.add(cName.getCountryName());
		}
		
		return countriesNames;
	}
	
	@Override
	public void clearTable() {
		
		repository.deleteAll();
		
	}

}
