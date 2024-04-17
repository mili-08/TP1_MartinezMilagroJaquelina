package ar.edu.unju.fi.ejercicio18.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio18.model.DestinoTuristico;
import ar.edu.unju.fi.ejercicio18.model.Pais;

public class Main {

	private static Scanner sc = new Scanner(System.in);
	private static List<DestinoTuristico> destinosTuristicos;
	private static List<Pais> paises;
	
	public static void main(String[] args) {
		String op="";
		precargarPaises();
		destinosTuristicos = new ArrayList<>();
		do
		{
			op=menu();
			opciones(op);
		}while(!op.equals("9"));
		
		sc.close();
	}
	
	/**
	 * Agregando objetos de tipo Pais a la 
	 * ArrayLis de paises
	 */
	
	public static void precargarPaises() {
		if(paises == null) {
			paises = new ArrayList<>();
		}
		paises.add(new Pais(1, "Argentina"));
		paises.add(new Pais(3, "Tailandia"));
		paises.add(new Pais(2, "Mexico"));
		paises.add(new Pais(4, "Inglaterra"));
		paises.add(new Pais(5, "Canada"));
		paises.add(new Pais(6, "Estados Unidos"));
		paises.add(new Pais(7, "España"));
		paises.add(new Pais(8, "Corea"));
		paises.add(new Pais(8, "Filipinas"));
		paises.add(new Pais(8, "Colombia"));
	}
	
	/**
	 * Menu de opciones
	 * @return la opcion elegida
	 */
	
	public static String menu() {
		System.out.println("**** MENU ******\n");
		System.out.println("1- Alta de destino turistico");
		System.out.println("2- Mostrar todos los destinos turisticos");
		System.out.println("3- Modificar el pais de un destino");
		System.out.println("4- Limpiar el ArrayList de destinos turisticos");
		System.out.println("5- Eliminar un destino turistico");
		System.out.println("6- Mostrar los destinos turisticos ordenados por nombre");
		System.out.println("7- Mostrar todos los paises");
		System.out.println("8- Mostrar los destinos turisticos que pertenecen a un pais");
		System.out.println("9- Salir");
		System.out.print("\nElegir una opcion: ");
		return sc.next();
	}
 
	/**
	 * OPCIONESD DEL MENU
	 * @param oocion elegida
	 */
	
	public static void opciones(String op) {
		switch (op) {
		case "1": agregarDestino();	break;
		case "2": mostrarDestinos(); break;
		case "3": modificarPaisDestino(); break;
		case "4": limpiarArrayListDestinos();break;
		case "5": eliminarDestino(); break;
		case "6": mostrarDestinosPorNombre();break;
		case "7": mostrarPaises();break;
		case "8": mostrarDestinosPais();break;
		case "9": System.out.println("\n---- FIN DEL PROGRAMA -----\n");break;
		default:
			System.out.println("\n---- OPCION INVALIDA ----\n");
		}
		
	}
	/**
	 * Agregando objetos de tipo ds¿estinos a la
	 * ArrayList de destinosTuristicos
	 */
	public static void agregarDestino() {
			boolean band;
			String cadena;
			System.out.println("\n====== CARGA DE DESTINOS =======");
			DestinoTuristico destino = new DestinoTuristico();
			System.out.println("\n");
			destino.cargarDestino();
			do
			{
				band=false;
				cadena=" el codigo del pais: ";
				int codigo = verificarEntero(cadena);
				Pais pais = buscarPais(codigo);
				if (pais==null)
					System.out.println("\n---- No existe ese pais ------\n");  // deberia volver a intentar
				else {
					destino.setPais(pais);
					destinosTuristicos.add(destino);
					System.out.println("\n---- Destino cargado con exito ----\n");
					band=true;
				}
			}while(!band);
			System.out.println("\n===============================\n");
	}
	
	/**
	 * Busca el pais para poder almacenarlo para completar la carga
	 * del objeto destino
	 * @param codigo del pais
	 * @return el pais encontrado si es que existe sino devuelve null
	 */
	public static Pais buscarPais (int codigo) {
		Pais paisEncontrado = null;
		for(Pais p : paises) {
			if(p.getCodigo() == codigo) {
				paisEncontrado=p;
				break;
			}
		}
		return paisEncontrado;
	}
	
	/**
	 * Se controla las excepciones al 
	 * ingresar valores invalidos
	 * @return devuelve el valor ingresado que sea valido
	 */
	
	public static Integer verificarEntero (String cadena) {
		Integer valor = -1;
		boolean band;
		do
		{ 
			band=false;
			System.out.print("Ingrese" + cadena);
			try {
				valor=sc.nextInt();
				sc.nextLine();
				band=true;
			}catch (InputMismatchException e) {
				System.out.println("\n---- Debe ingresar un valor entero -----\n");
				sc.nextLine();
			}
		}while(!band);
		return valor;
	}
	
	/**
	 * Muestra todos los destinos
	 */
	public static void mostrarDestinos () {
		if (!listaDestinosVacia()) {
			System.out.println("\n======== DESTINOS TURISTICOS ======\n");
			destinosTuristicos.forEach(d -> System.out.println(d));
			System.out.println("=================================\n");
		}else 
			System.out.println("\n---- NO HAY DESTINOS CARGADOS -----\n");
	}
	
	/**
	 * Modificar un destino determinado
	 */
	
	public static void modificarPaisDestino() {
		if (!listaDestinosVacia()) {
			System.out.println("\n====== MODIFICAR DESTINO ========\n");
			int codigo = verificarEntero(" el codigo del destino: ");
			DestinoTuristico destino = buscarDestino(codigo);
			if (destino == null) {
				System.out.println("\n---- No existe el destino turistico con codigo " + codigo + " ----\n");
			} else {
				codigo = verificarEntero(" un codigo de pais: ");
				Pais pais = buscarPais(codigo);
				if (pais == null)
					System.out.println("\n---- El pais con codigo " + codigo + " no existe ----\n");
				else {
					destino.setPais(pais);
					System.out.println("\n ---- MODIFICACION EXITOSA ----\n");
				}
			}
			System.out.println("\n=================================\n");
		}else 
			System.out.println("\n---- NO HAY DESTINOS CARGADOS -----\n");
	}
	
	/**
	 * Buscar un destino de la ArrayLIst de destinosTuristicos
	 * @param codigo del destino
	 * @return el destino encontrado o null
	 */
	
	public static DestinoTuristico buscarDestino(int codigo) {
		DestinoTuristico destinoEncontrado = null;
		for(DestinoTuristico dest : destinosTuristicos) {
			if(dest.getCodigo()==codigo) {
				destinoEncontrado=dest;
				break;
			}
		}
		return destinoEncontrado;
	}
	
	
	/**
	 * Limpieza del arrayList de destinos turisticos
	 */

	public static void limpiarArrayListDestinos() {
		if (!listaDestinosVacia()) {
			System.out.println("\n==============================\n");
	        destinosTuristicos.clear();
	        System.out.println("\n---- LIMPIEZA EXITOSA ----\n");
	        System.out.println("\n==============================\n");
		}else 
			System.out.println("\n---- NO HAY DESTINOS CARGADOS -----\n");	
	}
	
	
	/**
	 * Elimina un objeto tipo DestinoTuristico del ArrayList
	 */
	
	public static void eliminarDestino() {
		if(!listaDestinosVacia()) {
			System.out.println("\n===== ELIMINAR DESTINO ======\n");
			 int codigo = verificarEntero(" el codigo del destino: ");
			 Iterator<DestinoTuristico> iterator = destinosTuristicos.iterator();
			 while(iterator.hasNext()) {
				 DestinoTuristico dest = iterator.next();
				 if(dest.getCodigo() == codigo) {
					 iterator.remove();
					 System.out.println("\n--- Eliminado con exito ---\n");
					 break;
				 }
			 }
			 System.out.println("\n=============================\n");
		}else 
			System.out.println("\n---- NO HAY DESTINOS CARGADOS -----\n");	
	}
	
	/**
	 * MOSTRAR LOS DESTINOS ORDENADOS POR NOMBRE
	 */
	
	public static void mostrarDestinosPorNombre() {
		if (!listaDestinosVacia()) {
			System.out.println("\n===== DESTINO POR NOMBRE =======\n");
			List<DestinoTuristico> destinosPorNombre;
			destinosPorNombre = new ArrayList<>(destinosTuristicos);
			destinosPorNombre.sort(Comparator.comparing(DestinoTuristico::getNombre));
			destinosPorNombre.forEach(dest -> System.out.println(dest));
			destinosPorNombre = null; 
			System.out.println("\n==============================\n");
		}else 
			System.out.println("\n---- NO HAY DESTINOS CARGADOS -----\n");	
	}
	
	public static void mostrarPaises() {
		if(paises.size()!=0) {
			System.out.println("\n==== PAISES CARGADOS ====\n");
			paises.forEach(p -> System.out.println(p + "\n-------------------------------\n"));
			System.out.println("============================\n");
		}else 
			System.out.println("\n---- NO HAY PAISES CARGADOS -----\n");	
	}

	/**
	 * MOSTRAR USUARIOS POR PAIS
	 */
	
	public static void mostrarDestinosPais() {
		if(!listaDestinosVacia()) {
			boolean band=false;
			System.out.println("\n===== DESTINOS POR PAIS ======\n");
			int codigo = verificarEntero(" el codigo de un pais: ");
			System.out.println("\n");
			for(DestinoTuristico dest:destinosTuristicos) {
				if(dest.getPais().getCodigo() == codigo) {
                  System.out.println(dest);	
                  band=true;
				}
				
			}
			if(!band)
				System.out.println("---- No hay destinos con el codigo " + codigo + " -----\n");
			System.out.println("\n====================\n");
		}else 
			System.out.println("\n---- NO HAY DESTINOS CARGADOS -----\n");	
	}
	
	public static boolean listaDestinosVacia () {
		return destinosTuristicos.size() ==0;
	}
}
