package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "countries")
public class CountriesNamesEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String country_name;

	public CountriesNamesEntity() {
		super();
	}

	public CountriesNamesEntity(String countryName) {
		super();
		this.country_name = countryName;
	}

	public String getCountryName() {
		return country_name;
	}

	public void setCountryName(String countryName) {
		this.country_name = countryName;
	}
	
}
