package ar.edu.unju.fi.ejercicio18.model;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DestinoTuristico {
	private Integer codigo;
	private String nombre;
	private Double precio;
	private Pais pais;
	private Integer cantidadDias;
	
	private Scanner sc = new Scanner(System.in);

	public DestinoTuristico() {

	}

	public DestinoTuristico(Integer codigo, String nombre, Double precio, Pais pais, Integer cantidadDias) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
		this.pais = pais;
		this.cantidadDias = cantidadDias;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public Integer getCantidadDias() {
		return cantidadDias;
	}

	public void setCantidadDias(Integer cantidadDias) {
		this.cantidadDias = cantidadDias;
	}

	@Override
	public String toString() {
		return "--- Datos del destino ---\n\nCodigo del destino: " + codigo + "\nNombre del destino: " + nombre + "\nPrecio: " + precio + "\nCantidad de dias: " + cantidadDias+ "\n\n---- Datos del Pais ----" + pais +
				"\n----------------------------------\n";
	}
	
	/**
	 * VERIFICA QUE EL VALOR INGRESADO SEA UN DECIMAL
	 * @return el valor valido
	 */
   
	public Double verificarPrecio () {
		Double valor = 0.0;
		boolean band;
		do
		{ 
			band=false;
			System.out.print("Ingrese el precio: " );
			try {
				valor=sc.nextDouble();
				sc.nextLine();
				band=true;
			}catch (InputMismatchException e) {
				System.out.println("\n---- El precio debe ser un valor decimal -----\n");
				sc.nextLine();
			}
		}while(!band);
		return valor;
	}
	
	/**
	 * Verificar que se ingrese un valor entero
	 * @return el valor correcto
	 */
	
	public Integer verificarValorEntero (String cadena) {
		Integer valor = 0;
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
				System.out.println("\n---- Debe ser un valor entero -----\n");
				sc.nextLine();
			}
		}while(!band);
		return valor;
	}
	
	
	/**
	 * CARGA DE UN JUGADOR
	 */
	public void cargarDestino () {
		String cadena = " el codigo del destino: ";
	    this.setCodigo(verificarValorEntero(cadena));
		System.out.print("Ingrese el nombre del destino: ");
		this.setNombre(sc.next());
		this.setPrecio(verificarPrecio());
		cadena=" la cantidad de dias: ";
		this.setCantidadDias(verificarValorEntero(cadena));
	}

}
