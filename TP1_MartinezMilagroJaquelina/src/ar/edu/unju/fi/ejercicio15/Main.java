package ar.edu.unju.fi.ejercicio15;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static Scanner sc= new Scanner(System.in);
	
	public static void main(String[] args) {
	 int cantidad;
	 do
	 {
		 cantidad = verificarEntero();
		 if(!(cantidad>=5 && cantidad<=10))
			 System.out.println("\nINVALIDO, DEBE SER UN VALOR DE 5 A 1O\n");
	 }while(!(cantidad>=5 && cantidad<=10));
	 
	 String[] vector = new String[cantidad];
	 
	 System.out.println("\n*** INGRESO DE VALORES ***\n");
	 for(int a=0;a<vector.length;a++) {
		 System.out.print("Ingrese un nombre: ");
		 vector[a]=sc.nextLine();
	 }
	 
	 mostrarValores(vector);
	 mostrarValoresInverso(vector);
	 
     sc.close();
	}
	
	public static int verificarEntero() {
		int valor = 0;
		boolean band;
		do {
			band = false;
			try {
				System.out.print("Ingrese un valor del 5 al 10 de acuerdo a la cantidad de valores que desea ingresar: ");
				valor = sc.nextInt();
				sc.nextLine();
				band = true;
			} catch (InputMismatchException e) {
				System.out.println("\nINVALIDO, DEBE SER UN VALOR ENTERO DE 5 A 10\n");
				sc.nextLine();
			}
		} while (!band);
		return valor;
	}
	
	public static void mostrarValores(String[] vector) {
		System.out.println("\n*** MOSTRANDO DATOS ***\n");
		for(int valor=0;valor<vector.length;valor++)
		 System.out.println("vector[" + valor +"] = " + vector[valor]);
	}
	
	public static void mostrarValoresInverso (String[] vector) {
		System.out.println("\n*** MOSTRANDO DATOS INVERSAMENTE***\n");
		for(int a=vector.length-1;a>=0;a--)
			System.out.println("vector[" + a +"] = "+vector[a]);
	}

}
