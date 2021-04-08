package model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Informe {
	
	private String municipio_distrito;
	@JsonProperty(value = "casos_confirmados_ultimos_14dias")
	private int casosUltimos14dias;
	@JsonProperty(value = "casos_confirmados_totales")
	private int casosTotal;
	@JsonProperty(value = "fecha_informe")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd hh:mm:ss")
	private Date fechaInforme;
	
	public Informe() {
		
	}

	public Informe(String municipio_distrito, int casosUltimos14dias, int casosTotal, Date fechaInforme) {
		super();
		this.municipio_distrito = municipio_distrito;
		this.casosUltimos14dias = casosUltimos14dias;
		this.casosTotal = casosTotal;
		this.fechaInforme = fechaInforme;
	}

	public String getMunicipio_distrito() {
		return municipio_distrito;
	}

	public void setMunicipio_distrito(String municipio_distrito) {
		this.municipio_distrito = municipio_distrito;
	}

	public int getCasosUltimos14dias() {
		return casosUltimos14dias;
	}

	public void setCasosUltimos14dias(int casosUltimos14dias) {
		this.casosUltimos14dias = casosUltimos14dias;
	}

	public int getCasosTotal() {
		return casosTotal;
	}

	public void setCasosTotal(int casosTotal) {
		this.casosTotal = casosTotal;
	}

	public Date getFechaInforme() {
		return fechaInforme;
	}

	public void setFechaInforme(Date fechaInforme) {
		this.fechaInforme = fechaInforme;
	}
	
}
