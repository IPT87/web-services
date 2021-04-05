package repository;

import java.util.List;

import model.VaccineNamesEntity;

public interface VaccineNameRepository {
	
	void addNewCountryName(VaccineNamesEntity vaccineName);
	List<String> vaccineNames();
	void clearTable();

}
