package ar.edu.unju.fi.ejercicio17.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio17.model.Jugador;

public class Main {

	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
	ArrayList<Jugador> jugadores = new ArrayList();
	String rta="";
	
	do
	{
	   menu();
	   System.out.print("\nElegir una opcion: ");
	   rta=sc.next();
	   opciones(rta,jugadores); 
	}while(!rta.equals("7"));
	
     sc.close();
	}

	public static void menu() {
		System.out.println("**** MENU ******\n");
		System.out.println("1- Alta de Jugador");
		System.out.println("2- Mostrar los datos de un jugador");
		System.out.println("3- Mostrar todos los jugadores ordenados por apellido");
		System.out.println("4- Modificar los datos de un jugador");
		System.out.println("5- Eliminar un jugador");
		System.out.println("5- Mostrar la cantidad total de jugadores");
		System.out.println("6- Mostrar la cantidad de jugadores que pertenecen a una nacionalidad");
		System.out.println("7- Salir");
	}
	
	public static void opciones(String rta, ArrayList<Jugador> jugadores) {
		Jugador jugador = new Jugador();
		boolean band;
		String cadena1, cadena2;
		switch (rta) {
		case "1": 
			jugador.cargarJugador();
			if(jugadores.add(jugador))
				System.out.println("\n ---- ALTA EXITOSA ----\n");
			else
				System.out.println("\n ---- ERROR EN EL ALTA ----\n");
			break;
		case "2": 
			band=false;
			System.out.print("Ingrese el nombre: ");
			cadena1=sc.next();
			System.out.print("Ingrese el nombre: ");
			cadena2=sc.next();
			for(int a=0;a<jugadores.size() && !band;a++){
				if(jugadores.get(a).getNombre().equals(cadena1) && jugadores.get(a).getApellido().equals(cadena2)) { 
				   System.out.println(jugadores.get(a).toString());
				   band=true;
			    } 
			}
			if(!band)
				System.out.println("\n---- No hay registro de " + cadena2 + ", " + cadena1 + " ------");
			break;
		case "3": 
			jugadores.sort(Comparator.comparing(Jugador::getApellido));
			System.out.println("\n**** MOSTRANDO JUGADORES****\n");
			for(Jugador jug:jugadores) {
				System.out.println(jug + "\n");
			}
			break;
		case "4": 
			System.out.println("Opcion 4");
			break;
		case "5": 
			System.out.println("Opcion 5");
			break;
		case "6": 
			System.out.println("Opcion 6");
			break;
		case "7": 
			System.out.println("Opcion 7");
			break;
		default:
			System.err.println("Opcion Invalida");
		}
	}
}
