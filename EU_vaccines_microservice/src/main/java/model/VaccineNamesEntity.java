package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vaccines")
public class VaccineNamesEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private String vaccine_name;

	public VaccineNamesEntity() {
		super();
	}

	public VaccineNamesEntity(String vaccine_name) {
		super();
		this.vaccine_name = vaccine_name;
	}

	public String getVaccine_name() {
		return vaccine_name;
	}

	public void setVaccine_name(String vaccine_name) {
		this.vaccine_name = vaccine_name;
	}
	
}
