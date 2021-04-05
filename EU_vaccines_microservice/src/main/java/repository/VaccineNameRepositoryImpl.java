package repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.VaccineNamesEntity;

@Repository
public class VaccineNameRepositoryImpl implements VaccineNameRepository {
	
	@Autowired
	VaccineNameRepositoryJpa repository;

	@Override
	public void addNewCountryName(VaccineNamesEntity vaccineName) {
		
		repository.save(vaccineName);

	}

	@Override
	public List<String> vaccineNames() {
		
		List<VaccineNamesEntity> vaccines = repository.findAll();
		List<String> vaccineNames = new ArrayList<String>();
		
		for(VaccineNamesEntity vaccine : vaccines) {
			vaccineNames.add(vaccine.getVaccine_name());
		}

		return vaccineNames;
		
	}

	@Override
	public void clearTable() {
		
		repository.deleteAll();
		
	}

}
