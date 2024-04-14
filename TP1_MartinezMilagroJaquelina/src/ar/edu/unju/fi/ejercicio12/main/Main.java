package ar.edu.unju.fi.ejercicio12.main;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio12.model.Persona;

public class Main {

	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("-------INGRESO DE DATOS ------\n");
		System.out.print("Ingrese el nombre: ");
		String nombre = sc.nextLine();
		Calendar fecha = Calendar.getInstance();
		fecha = verificarFecha();
		Persona persona = new Persona(nombre, fecha);
		System.out.println("\n-----DATOS DE PERSONALES ----\n");
		persona.mostrarDatos();
		System.out.println("\n------------------------------");
		sc.close();  
	}
	
	public static Calendar verificarFecha() {
		boolean band;
		LocalDate fecha = LocalDate.now();
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		do
		{
			band=false;
			System.out.print("Ingrese la fecha con este formato 'dd/mm/yyyy': ");
			try {
				   
				   fecha=LocalDate.parse(sc.next(),formato); 
				   band=true;	   
				}catch (DateTimeException e) {
					System.out.println("\n----- INVALIDO, La fecha no sigue el formato 'dd/mm/yyyy' -------\n");
					sc.nextLine();
				}		
		}while(!band);
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
	    calendar.set(fecha.getYear(), fecha.getMonthValue()-1, fecha.getDayOfMonth());
		return calendar;
	}

}
