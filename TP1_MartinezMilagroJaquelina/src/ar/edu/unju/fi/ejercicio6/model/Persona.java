package ar.edu.unju.fi.ejercicio6.model;

import java.time.LocalDate;
import java.time.Period;

public class Persona {
	private Long dni;
	private String nombre;
	private LocalDate fechaNacimiento;
	private String provincia;

	public Persona() {

	}
    

	public Persona(Long dni, String nombre, LocalDate fechaNacimiento, String provincia) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.provincia = provincia;
	}

    

	public Persona(Long dni, String nombre, LocalDate fechaNacimiento) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.provincia = "Jujuy";
	}


	public long getDni() {
		return dni;
	}

	public void setDni(Long dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
    
	public int calcularEdad () {
		Period periodo = Period.between(this.fechaNacimiento, LocalDate.now());
		return periodo.getYears();
	}
    
	public boolean mayorEdad () {
		return calcularEdad()>=18;
	}
	
	public void mostrarDato() {
		System.out.println("\n ---- MOSTRANDO DATOS ------\n");
		System.out.println("Nombre: " + nombre + "\nDNI: " + dni + "\nProvincia: " + provincia + "\nFecha de Nacimiento: " + fechaNacimiento);
		if (mayorEdad()==true)
			System.out.println("La persona es mayor de edad" + "\n----------------------------\n");
		else 
			System.out.println("La persona no es mayor de edad" + "\n----------------------------\n");
	}
}
