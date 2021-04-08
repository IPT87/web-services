package controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import model.Informe;
import service.InformeService;

@CrossOrigin("*")
@RestController
public class InformesController {
	@Autowired
	InformeService service;
	
	@GetMapping(value = "informes", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Informe> todosInformes() {
		return service.todosInformes();
	}
	
	@GetMapping(value = "informes_municipio", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Informe> informesPorMunicipio(@RequestParam("municipio") String municipio) {
		return service.informesPorMunicipio(municipio);
	}
	
	@GetMapping(value = "municipios", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<String> municipios() {
		return service.municipios();
	}
	
	@GetMapping(value = "municipio_fecha", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Informe municipioPorFecha(@RequestParam("municipio") String municipio, @RequestParam("fecha") String fecha) {
		return service.informePorMunicipioFecha(municipio, fecha);
	}
	
	@GetMapping(value = "informes_fecha", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Informe> informesPorFecha(@RequestParam("fecha") String fecha) {
		return service.informesPorFecha(fecha);
	}
	
	@GetMapping(value = "total_casos", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody int totalCasos() {
		return service.casosTotal();
	}
	
	@GetMapping(value = "casos_municipio", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody int casosMunicipio(@RequestParam("municipio") String municipio) {
		return service.casosPorMunicipio(municipio);
	}
	
	@GetMapping(value = "descargar_datos", produces = MediaType.TEXT_PLAIN_VALUE)
	public @ResponseBody void descargarDatos(@RequestParam("municipio") String municipio, @RequestParam("casosUltimos14Dias") String casosUltimos14Dias,
			@RequestParam("casosTotales") String casosTotales, @RequestParam("fechaInforme") String fechaInforme) {
		service.descargarDatos(municipio, casosUltimos14Dias, casosTotales, fechaInforme);
	}

}
