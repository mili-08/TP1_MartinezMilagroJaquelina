package ar.edu.unju.fi.ejercicio17.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio17.model.Jugador;

public class Main {

	private static Scanner sc = new Scanner(System.in);
	private static List<Jugador> jugadores;
	private static String[] vector;
	
	public static void main(String[] args) {
	
	jugadores = new ArrayList<>();
	String rta="";
	do
	{
	   menu();
	   System.out.print("\nElegir una opcion: ");
	   rta=sc.next();
	   opciones(rta); 
	}while(!rta.equals("8"));
     sc.close();
	}

	public static void menu() {
		System.out.println("**** MENU ******\n");
		System.out.println("1- Alta de Jugador");
		System.out.println("2- Mostrar los datos de un jugador");
		System.out.println("3- Mostrar todos los jugadores ordenados por apellido");
		System.out.println("4- Modificar los datos de un jugador");
		System.out.println("5- Eliminar un jugador");
		System.out.println("6- Mostrar la cantidad total de jugadores");
		System.out.println("7- Mostrar la cantidad de jugadores que pertenecen a una nacionalidad");
		System.out.println("8- Salir");
	}
	
	public static void ingresarNombreApellido() {
		sc.nextLine();
		System.out.print("Ingrese el nombre: ");
		vector[0] =  sc.nextLine();
		System.out.print("Ingrese el apellido: ");
		vector[1] = sc.nextLine();
	}
	
	public static boolean listaVacia () {
		return jugadores.size() ==0;
	}
	
	public static void opciones(String rta) {
		Jugador jugador = new Jugador();
		boolean band;
		vector = new String[2];
		switch (rta) {
		case "1": 
			System.out.println("\n===== ALTA DE USUARIOS =======");
			jugador.cargarJugador();
			if(jugadores.add(jugador))
				System.out.println("\n ---- ALTA EXITOSA ----\n");
			else
				System.out.println("\n ---- ERROR EN EL ALTA ----\n");
			System.out.println("=================================\n");
			break;
		case "2": 
			band=false;
			if (!listaVacia()) {
				System.out.println("===== DATOS DE USUARIOS =======\n");
				ingresarNombreApellido();
				for(int a=0;a<jugadores.size() && !band;a++){
					if(jugadores.get(a).getNombre().equals(vector[0]) && jugadores.get(a).getApellido().equals(vector[1])) { 
					   System.out.println(jugadores.get(a).toString());
					   band=true;
				    } 
				}
				if(!band)
					System.out.println("\n---- No hay registro de " + vector[1] + ", " + vector[0] + " ------");
				System.out.println("\n==================================\n");
			}else 
				System.out.println("\n----- NO HAY USUARIOS CARGADOS -----\n");
			break;
		case "3": 
			if(!listaVacia()) {
				ArrayList<Jugador> jugadoresOrdenados = new ArrayList<>(jugadores);
				System.out.println("\n===== JUGADORES ORDENADOS POR APELLIDO =====\n");
				jugadoresOrdenados.sort(Comparator.comparing(Jugador::getApellido));
				jugadoresOrdenados.forEach(jug -> System.out.println(jug));
				System.out.println("\n============================================\n");
			}else 
				System.out.println("\n----- NO HAY USUARIOS CARGADOS -----\n");
			break;
		case "4": 
			band=false;
			if (!listaVacia()) {
				System.out.println("\n===== MODIFICAR JUGADOR =====\n");
				ingresarNombreApellido();
				for(int a=0;a<jugadores.size() && !band;a++) {
					if(jugadores.get(a).getNombre().equals(vector[0]) && jugadores.get(a).getApellido().equals(vector[1])) {
						jugador=jugadores.get(a);
						jugador.modificarJugador();
						jugadores.set(a, jugador);
						band=true;
						System.out.println("\n---- DATOS ACTULIZADOS -----\n");
	                    System.out.println(jugadores.get(a).toString());
					 }
				}
				if(!band)
					System.out.println("\n--- NO HAY REGISTRO DE " + vector[1] + ", " + vector[0] + "-----\n");
				System.out.println("\n=====================================\n");	
			}else 
				System.out.println("\n----- NO HAY USUARIOS CARGADOS -----\n");
		break;
		case "5": 
			band=false;
			if(!listaVacia()) {
				System.out.println("\n===== ELIMINAR JUGADOR =====\n");
				ingresarNombreApellido();
				Iterator<Jugador> iteradorJugadores = jugadores.iterator();
				while(iteradorJugadores.hasNext() && !band) {
					Jugador jug = iteradorJugadores.next();
					if(jug.getApellido().equals(vector[1]) && jug.getNombre().equals(vector[0])){
						iteradorJugadores.remove();
						System.out.println("\n---- BORRADO CON EXITO ----\n");
						band=true;
					}
				}
				if(!band)
					System.out.println("\n--- NO HAY REGISTRO DE " + vector[1] + ", " + vector[0] + "-----\n");
				System.out.println("\n==============================\n");
			}else 
				System.out.println("\n----- NO HAY USUARIOS CARGADOS -----\n");
			break;
		case "6": 
			if (!listaVacia()) {
				System.out.println("\n===== JUGADORES TOTALES =====\n");
				jugadores.forEach(jug -> System.out.println(jug));
				System.out.println("\n---- La cantidad total de jugadores es: " + jugadores.size() + " -----\n");
				System.out.println("==============================\n");
				
			}else 
				System.out.println("\n----- NO HAY USUARIOS CARGADOS -----\n");
			break;
		case "7": 
			if (!listaVacia()) {
				int a=0;
				String cadena1;
				System.out.println("\n===== JUGADORES POR NACIONALIDAD =====\n");
				System.out.print("Ingrese un nacionalidad: ");
				cadena1=sc.next();
				Iterator<Jugador> iteradorJugadores = jugadores.iterator();
				while(iteradorJugadores.hasNext()) {
					Jugador jug=iteradorJugadores.next();
					if(jug.getNacionalidad().equals(cadena1)) {
						System.out.println(jug.toString());
						a++;
					}
				}
				System.out.println("\n---- La cantidad de jugadores con nacionalidad en " + cadena1 + " es: " + a + " ----\n");
				System.out.println("\n======================================\n");
			}else 
				System.out.println("\n----- NO HAY USUARIOS CARGADOS -----\n");
			break;
		case "8": 
			System.out.println("\n----- FIN DEL PROGRAMA -----\n");
			break;
		default:
			System.err.println("Opcion Invalida");
		}
	}
}
