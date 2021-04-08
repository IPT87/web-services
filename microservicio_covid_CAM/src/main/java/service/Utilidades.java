package service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilidades {
	private static String pattern = "yyyy-MM-dd";
	private static DateFormat df = new SimpleDateFormat(pattern);
	
	public static String convertirFechaEnTexto(Date fecha) {
		return df.format(fecha);
	}
	
	public static String datosDescarga(String municipio, String casosUltimos14Dias, String casosTotales, String fechaInforme) {
		return "Municipio: " + municipio + "\n"
				+ "Casos en los ultimos 14 dias: " + casosUltimos14Dias + "\n"
				+ "Casos totales: " + casosTotales + "\n"
				+ "Fecha del informe: " + fechaInforme;
	}
	
	public static String formatearFechaParaGuardar(String fecha) {
		String[] fechaInicial = fecha.split("/");
		return fechaInicial[0] + "_" + fechaInicial[1] + "_" + fechaInicial[2].substring(0, 2);
	}
}
