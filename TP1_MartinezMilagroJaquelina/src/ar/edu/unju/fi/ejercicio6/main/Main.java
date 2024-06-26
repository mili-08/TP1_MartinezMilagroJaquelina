package ar.edu.unju.fi.ejercicio6.main;


import java.time.LocalDate;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio6.model.Persona;

public class Main {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		Persona persona1 = new Persona();
		Long dni = solicitarDNI();
		String nombre = solicitarNombre();
		LocalDate fechaNac = solicitarFechNac();
		String provincia = solicitarProvincia();

		persona1.setDni(dni);
		persona1.setFechaNacimiento(fechaNac);
		persona1.setNombre(nombre);
		persona1.setProvincia(provincia);
		persona1.mostrarDato();

		dni = solicitarDNI();
		nombre = solicitarNombre();
		fechaNac = solicitarFechNac();
		provincia = solicitarProvincia();

		Persona persona2 = new Persona(dni, nombre, fechaNac, provincia);
		persona2.mostrarDato();


		dni = solicitarDNI();
		nombre = solicitarNombre();
		fechaNac = solicitarFechNac();

		Persona persona3 = new Persona(dni, nombre, fechaNac);
		persona3.mostrarDato();
		sc.close();
	}

	public static Long solicitarDNI() {
		System.out.print("Ingrese el dni: ");
		Long dni = sc.nextLong();
		sc.nextLine();
		return dni;
	}

	public static String solicitarNombre() {
		System.out.print("Ingrese el nombre: ");
		String nombre = sc.nextLine();
		return nombre;
	}

	public static LocalDate solicitarFechNac() {
		boolean band;
		LocalDate fechaNac=LocalDate.now();
		do
		{
		    band=false;
			try {
				System.out.print("Ingrese la fecha en este formato 'yyyy-mm-dd': ");
				fechaNac = LocalDate.parse(sc.next());
				sc.nextLine();
				band=true;
			}catch (Exception e) {
				System.out.println("\n ----- INVALIDO, TIENE QUE SEGUIR EL FORMATO 'yyyy-mm-dd' ----\n");
			    sc.nextLine();
			}
		}while(!band);
		return fechaNac;
	}

	public static String solicitarProvincia() {
		System.out.print("Ingrese la provincia: ");
		String provincia = sc.nextLine();
		return provincia;
	}
}
