package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "eu_citizens_vaccinated")
public class EUCitizensVaccinatedEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private double eu_citizens_vaccinated;

	public EUCitizensVaccinatedEntity() {
		super();
	}

	public EUCitizensVaccinatedEntity(double eu_citizens_vaccinated) {
		super();
		this.eu_citizens_vaccinated = eu_citizens_vaccinated;
	}

	public double getEu_citizens_vaccinated() {
		return eu_citizens_vaccinated;
	}

	public void setEu_citizens_vaccinated(double eu_citizens_vaccinated) {
		this.eu_citizens_vaccinated = eu_citizens_vaccinated;
	}

}
