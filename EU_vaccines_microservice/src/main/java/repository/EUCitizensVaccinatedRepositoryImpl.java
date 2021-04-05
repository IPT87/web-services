package repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.EUCitizensVaccinatedEntity;

@Repository
public class EUCitizensVaccinatedRepositoryImpl implements EUCitizensVaccinatedRepository {

	@Autowired
	EUCitizensVaccinatedRepositoryJpa repository;
	
	@Override
	public void addEUCitizensVaccinated(EUCitizensVaccinatedEntity euCitizens) {
		
		repository.save(euCitizens);
		
	}

	@Override
	public double euCitizensVaccinated() {
		
		return repository.findAll().get(0).getEu_citizens_vaccinated();
		
	}
	
	@Override
	public void clearTable() {
		
		repository.deleteAll();
		
	}

}
