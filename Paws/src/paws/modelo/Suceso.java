package paws.modelo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import paws.control.Tiempo;

public class Suceso implements Serializable {
	
	private static final long serialVersionUID = 333L;
	
	private String estado;
	private String lugar;
	private Calendar fecha;
	private String detalles;
	private String nick;
	
	public Suceso() {
		nick = "";
		estado = "";
		lugar = "";
		// Copia el valor Date de la fecha del Sistema
		fecha = new Calendar.Builder().setCalendarType("iso8601")
				.setInstant(Tiempo.getFechaSistema().getTime()).build();
		detalles = "";
	}
	
	public Suceso(String pNick, String pEstado, String pLugar, String pDetalles) {
		nick = pNick;
		estado = pEstado;
		lugar = pLugar;
		// Copia el valor Date de la fecha del Sistema
		fecha = new Calendar.Builder().setCalendarType("iso8601")
				.setInstant(Tiempo.getFechaSistema().getTime()).build();
		detalles = pDetalles;
	}
	
	public String getNick() {
		return nick;
	}
	
	public String getEstado() {
		return estado;
	}

	public String getLugar() {
		return lugar;
	}

	public Calendar getFecha() {
		return fecha;
	}
	
	public String getFechaString() {
		SimpleDateFormat mascara = new SimpleDateFormat("dd/MM/yy");
		return mascara.format(fecha.getTime());
	}

	public String getDetalles() {
		return detalles;
	}
	
	public String toString() {
		String msg = "\nUsuario reportante: " + nick;
		msg += "Lugar: " + lugar;
		msg += "\nFecha: " + getFechaString();
		msg += "\nDescripcion: " + detalles;
		return msg;
	}

}