package ar.edu.unju.fi.ejercicio12.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio12.model.Persona;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Ingrese el nomnbre: ");
		String nombre = sc.nextLine();
		Calendar fecha = Calendar.getInstance();
		fecha = verificarFecha();
		Persona persona = new Persona(nombre, fecha);
		persona.mostrarDatos();
		sc.close();  
	}
	
	public static Calendar verificarFecha() {

		boolean band;
		Scanner sc = new Scanner(System.in);
		Calendar fecha = Calendar.getInstance();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		do
		{
			band=false;
			System.out.print("Ingrese la fecha con este formato dd/MM/yyyy: ");
			String valorFecha = sc.next();
			try {
				   
				   fecha.setLenient(false);
				   fecha.setTime(formato.parse(valorFecha));   
				   band=true;
				   
				}catch (ParseException | IllegalArgumentException e) {
					System.out.println("La fecha no sigue el formato");
					sc.nextLine();
				}		
		}while(!band);	
		return fecha;
	}

}
