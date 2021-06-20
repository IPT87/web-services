package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Cliente {

	private String nombre;
	private String tratamiento;
	private int duracionTratamiento;
	private String empleadoSesion;
	private LocalDate date;
	private ArrayList<String> historialTratamientos;
	
	public Cliente() {
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTratamiento() {
		return tratamiento;
	}

	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
	}

	public int getDuracionTratamiento() {
		return duracionTratamiento;
	}

	public void setDuracionTratamiento(int duracionTratamiento) {
		this.duracionTratamiento = duracionTratamiento;
	}

	public ArrayList<String> getHistorialTratamientos() {
		return historialTratamientos;
	}

	public void setHistorialTratamientos(ArrayList<String> historialTratamientos) {
		this.historialTratamientos = historialTratamientos;
	}

	public String getEmpleadoSesion() {
		return empleadoSesion;
	}

	public void setEmpleadoSesion(String empleadoSesion) {
		this.empleadoSesion = empleadoSesion;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
}
