package service;

import java.util.List;

import model.Informe;

public interface InformeService {

	List<Informe> todosInformes();
	List<Informe> informesPorMunicipio(String municipio);
	List<Informe> informesPorFecha(String fecha);
	Informe informePorMunicipioFecha(String municipio, String fecha);
	List<String> municipios();
	int casosTotal();
	int casosPorMunicipio(String municipio);
	void descargarDatos(String municipio, String casosUltimos14Dias, String casosTotales, String fechaInforme);
	
}
