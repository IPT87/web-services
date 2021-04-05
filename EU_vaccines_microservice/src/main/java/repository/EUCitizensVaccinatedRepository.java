package repository;

import model.EUCitizensVaccinatedEntity;

public interface EUCitizensVaccinatedRepository {
	
	void addEUCitizensVaccinated(EUCitizensVaccinatedEntity euCitizens);
	double euCitizensVaccinated();
	void clearTable();
	
}
