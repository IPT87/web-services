package service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import model.Conjunto;
import model.Informe;

@Service
public class InformeServiceImpl implements InformeService {
	
	@Autowired
	private RestTemplate template;

	private String url = "https://datos.comunidad.madrid/catalogo/dataset/7da43feb-8d4d-47e0-abd5-3d022d29d09e/resource/877fa8f5-cd6c-4e44-9df5-0fb60944a841/download/covid19_tia_muni_y_distritos_s.json";
	
	@Override
	public List<Informe> todosInformes() {			
		
		Conjunto conjunto = template.getForObject(url, Conjunto.class);
		
		return Arrays.stream(conjunto.getData())
						.collect(Collectors.toList());	
	}

	@Override
	public List<Informe> informesPorMunicipio(String municipio) {
		
		Conjunto conjunto = template.getForObject(url, Conjunto.class);
		
		return Arrays.stream(conjunto.getData())
				.filter(i -> i.getMunicipio_distrito().equals(municipio))
				.collect(Collectors.toList());
	}

	@Override
	public List<Informe> informesPorFecha(String fecha) {
		
		Conjunto conjunto = template.getForObject(url, Conjunto.class);
		
		return Arrays.stream(conjunto.getData())
				.filter(i -> Utilidades.convertirFechaEnTexto(i.getFechaInforme()).equals(fecha.substring(0, 10)))
				.collect(Collectors.toList());
	}

	@Override
	public int casosTotal() {
		
		Conjunto conjunto = template.getForObject(url, Conjunto.class);
		String ultimaFechaInforme = Utilidades.convertirFechaEnTexto(conjunto.getData()[0].getFechaInforme());
		
		return Arrays.stream(conjunto.getData())
				.filter(i -> Utilidades.convertirFechaEnTexto(i.getFechaInforme()).equals(ultimaFechaInforme))
				.mapToInt(i -> i.getCasosTotal())
				.sum();

	}

	@Override
	public int casosPorMunicipio(String municipio) {
		
		Conjunto conjunto = template.getForObject(url, Conjunto.class);
		
		return Arrays.stream(conjunto.getData())
				.filter(i -> i.getMunicipio_distrito().equals(municipio))
				.findFirst()
				.map(i -> i.getCasosTotal())
				.get();
				
	}

	@Override
	public List<String> municipios() {
		
		Conjunto conjunto = template.getForObject(url, Conjunto.class);
		
		List<String> municipios = new ArrayList<>();
		
		Arrays.stream(conjunto.getData())
				.map(i -> i.getMunicipio_distrito())
				.forEach(m -> {
					if(!municipios.contains(m)) {
						municipios.add(m);
						}
					});
		
		return municipios;
	}

	@Override
	public Informe informePorMunicipioFecha(String municipio, String fecha) {
		
		Conjunto conjunto = template.getForObject(url, Conjunto.class);
				
		return Arrays.stream(conjunto.getData())
				.filter(i -> i.getMunicipio_distrito().equals(municipio))
				.filter(i -> Utilidades.convertirFechaEnTexto(i.getFechaInforme()).equals(fecha.substring(0, 10)))
				.findFirst()
				.get();
		
	}

	@Override
	public void descargarDatos(String municipio, String casosUltimos14Dias, String casosTotales, String fechaInforme) {
		
		String home = System.getProperty("user.home");
		String fechaFormateadaParaGuardar = Utilidades.formatearFechaParaGuardar(fechaInforme);
		
		try {
		      FileWriter myWriter = new FileWriter(home + "\\Desktop\\" + municipio + "(" + fechaFormateadaParaGuardar + ")" + ".txt");
		      myWriter.write(Utilidades.datosDescarga(municipio, casosUltimos14Dias, casosTotales, fechaInforme));
		      myWriter.close();
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}

}
