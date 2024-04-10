package ar.edu.unju.fi.ejercicio12.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Persona {
	private String nombre;
	private Calendar fechaNac;

	public Persona() {

	}

	public Persona(String nombre, Calendar fechaNac) {
		super();
		this.nombre = nombre;
		this.fechaNac = fechaNac;
	}
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Calendar getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Calendar fechaNac) {
		this.fechaNac = fechaNac;
	}
	
	
	public Integer calcularEdad() {
		Calendar hoy = Calendar.getInstance();
		Integer edad = hoy.get(Calendar.YEAR) - this.fechaNac.get(Calendar.YEAR);
		edad = hoy.get(Calendar.DAY_OF_YEAR) > this.fechaNac.get(Calendar.DAY_OF_YEAR) ? edad: edad - 1; 
		return edad;
	}
	
	public String calcularZodiaco() {
		int dia = this.fechaNac.get(Calendar.DAY_OF_MONTH);
		int mes = this.fechaNac.get(Calendar.MONTH);
		String signo="";
	    if ((mes == 2 && dia >= 21) || (mes == 3 && dia <= 19))
	        signo = "Aries";
	    else if ((mes == 3 && dia >= 20) || (mes == 4 && dia <= 20))
	        signo = "Tauro";
	    else if ((mes == 4 && dia >= 21) || (mes == 5 && dia <= 20))
	        signo = "Geminis"; 
	    else if ((mes == 5 && dia >= 21) || (mes == 6 && dia <= 21))
	        signo = "Cancer"; 
	    else if ((mes == 6 && dia >= 22) || (mes == 7 && dia <= 22))
	        signo = "Leo";
	    else if ((mes == 7 && dia >= 23) || (mes == 8 && dia <= 22))
	        signo = "Virgo";
	    else if ((mes == 8 && dia >= 23) || (mes == 9 && dia <= 22))
	        signo = "Libra";
	    else if ((mes == 9 && dia >= 23) || (mes == 10 && dia <= 22))
	        signo = "Escorpio";
	    else if ((mes == 10 && dia >= 23) || (mes == 11 && dia <= 21))
	        signo = "Sagitario";
	    else if ((mes == 11 && dia >= 22) || (mes == 0 && dia <= 19))
	        signo = "Capricornio";
	    else if ((mes == 0 && dia >= 20) || (mes == 1 && dia <= 18))
	        signo = "Acuario";
	    else
	        signo = "Piscis";
		return signo;
	}
	
	public boolean verificarBisiesto (int anio) {
		return (anio%4==0 && anio%100!=0) || anio%400==0;
	}

    public String calcularEstacion () {
    	int dia = fechaNac.get(Calendar.DAY_OF_YEAR);
    	String estacion;
    	boolean bisiesto = verificarBisiesto(fechaNac.get(Calendar.YEAR));
    	if (!bisiesto) {
    		if (dia>=80 && dia<=172)
        		estacion = "Otonio";
        	else if (dia>=173 && dia<=265)
        		estacion = "Invierno";
        	else if (dia>=266 && dia<=356)
        		estacion = "Primavera";
        	else 
        		estacion="Verano";	
    	}else 
    	{
    		if (dia>=81 && dia<=173)
        		estacion = "Otonio";
        	else if (dia>=174 && dia<=266)
        		estacion = "Invierno";
        	else if (dia>=267 && dia<=357)
        		estacion = "Primavera";
        	else 
        		estacion="Verano";
    	}
    	return estacion;
    }
	
	public void mostrarDatos () {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("\nNombre: " + nombre + "\nFecha de Nacimiento: " + formato.format(fechaNac.getTime())
		+ "\nEdad: " + this.calcularEdad() + " años\nSigno del Zodiaco: " + this.calcularZodiaco() + "\nEstacion: " + this.calcularEstacion());
	}
}
