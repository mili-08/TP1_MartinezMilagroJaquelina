package ar.edu.unju.fi.ejercicio17.model;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Jugador {
	private String nombre;
	private String apellido;
	private LocalDate fechaNacimiento;
	private String nacionalidad;
	private Double estatura;
	private Double peso;
	private String posicion;
	
	private static Scanner sc = new Scanner(System.in);

	public Jugador() {
		// TODO Auto-generated constructor stub
	}
	
	

	@Override
	public String toString() {
		return "Nombre: " + nombre + "\nApellido: " + apellido + "\nFecha de Nacimiento: " + fechaNacimiento
				+ "\nNacionalidad: " + nacionalidad + "\nEstatura: " + estatura + "\nPeso: " + peso + "\nPosicion: "
				+ posicion + "\n";
	}



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public Double getEstatura() {
		return estatura;
	}

	public void setEstatura(Double estatura) {
		this.estatura = estatura;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
	
	public int calcularEdad() {
		LocalDate hoy = LocalDate.now();
		return Period.between(this.fechaNacimiento, hoy ).getYears();
	}
	
	public LocalDate verificarFecha () {
		
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fecha = LocalDate.now();
		boolean band;
		do
		{
			band=false;
			System.out.print("Ingrese la fecha de Nacimiento con este formato 'dd/mm/yyyy': ");
			try {
				fecha = LocalDate.parse(sc.next(),formato);
				band=true;
			}catch (DateTimeException e) {
				System.out.println("\n---- INVALIDO, debe ser este formato 'dd/mm/yyyy' -----\n");
				sc.nextLine();
			}
		}while(!band);	
		return fecha;
	}

	public String verificarPosicion() {
		String a="";
		boolean band=false;
		do {
			System.out.print("Ingrese la posicion: ");
			a=sc.next();
			band=a.toLowerCase().equals("delantero") || a.toLowerCase().equals("medio") || a.toLowerCase().equals("defensa") || a.toLowerCase().equals("arquero");
		    if(!band)
		    	System.out.println("\n---- Debe ingresar un valor correcto (delantero, medio, defensa, arquero) ----\n");
		}while(!band);
		return a;
	}
	
	public void cargarJugador() {
		System.out.print("\nIngrese el nombre: ");
		this.setNombre(sc.nextLine());
		System.out.print("Ingrese el apellido: ");
		this.setApellido(sc.nextLine());
		this.setFechaNacimiento(verificarFecha());
		System.out.print("Ingrese el nacionalidad: ");
		this.setNacionalidad(sc.next());
		this.setEstatura(verificarDouble("la estatura: "));
		this.setPeso(verificarDouble("el peso: "));
		this.setPosicion(verificarPosicion());
		sc.nextLine();
	}
	
	public Double verificarDouble (String cadena) {
		Double valor = 0.0;
		boolean band;
		do
		{ 
			band=false;
			System.out.print("Ingrese" + cadena);
			try {
				valor=sc.nextDouble();
				sc.nextLine();
				band=true;
			}catch (InputMismatchException e) {
				System.out.println("\n----  Debe ser un valor decimal -----\n");
				sc.nextLine();
			}
		}while(!band);
		return valor;
	}
	
	public String menuModificacion() {
		String op="";
		System.out.println("\n---- Menu ----\n");
		System.out.println("1- Nombre");
		System.out.println("2- Apellido");
		System.out.println("3- Fecha de Nacimiento");
		System.out.println("4- Nacionalidad");
		System.out.println("5- Estatura");
		System.out.println("6- Peso");
		System.out.println("7- Posicion");
		System.out.println("8- Volver");
		System.out.print("\nElegir una opcion: ");
		op=sc.next();
		sc.nextLine();
		return op;
	}
	
	public void modificarJugador() {
	    String op=menuModificacion();
	    String cadena;
	    switch (op) {
		case "1": 
			System.out.print("\nIngrese el nombre: ");
			this.setNombre(sc.nextLine());
			break;
		case "2":
			System.out.print("\nIngrese el Apellido: ");
			this.setApellido(sc.nextLine());
			break;
		case "3": 
			this.setFechaNacimiento(verificarFecha());
			break;
		case "4": 
			System.out.print("\nIngrese el nacionalidad:");
			this.setNacionalidad(sc.nextLine());
			break;
		case "5": 
			cadena= " la estatura: ";
			this.setEstatura(verificarDouble(cadena));
			break;
		case "6": 
			cadena= " el peso: ";
			this.setPeso(verificarDouble(cadena));
			break;
		case "7": 
			this.setPosicion(verificarPosicion());
			break;
		case "8":
			System.out.println("\nVolviendo al menu principal ........\n");
			break;
		default:
			System.out.println("\nOpcion Invalida\n");
		}
	    
		if(op=="1" || op=="2" || op=="3" || op=="4" || op=="5" || op=="6" || op=="7") 
			System.out.println("\n---- Modificacion Exitosa ----\n");
	}

}
 