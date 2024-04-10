package ar.edu.unju.fi.ejercicio14;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
 
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
	  int cantidad=0;
	  String cadena;
	  do
	  {
		  cadena=" de 3 a 10 para la cantidad de valores que desea ingresar: ";
		  cantidad = verificarEntero(cadena); 
		  if (!(cantidad>=3 && cantidad<=10))
			  System.out.println("\nINVALIDO, DEBE SER UN NUMERO DE 3 A 10\n");
	  }while(!(cantidad>=3 && cantidad<=10));
	  
	  int[] vector = new int[cantidad]; 
	  cadena=": ";
	  System.out.print("\n *** Ingresando Valores ***\n");
	  for(int a=0;a<vector.length;a++)
		  vector[a]=verificarEntero(cadena);
	  
	  mostrarValores(vector);
	  System.out.println("\nResultado de la suma: " + sumarValores(vector));
	 
	  sc.close();
	}
	
	public static int verificarEntero(String cadena) {
		boolean band;
		int valor = 0;
		do {
			band = false;
			try {
				System.out.print("Ingrese un valor" + cadena);
				valor = sc.nextInt();
				band = true;
			} catch (InputMismatchException e) {
				System.out.println("\nINVALIDO, EL VALOR DEBE SER UN ENTERO\n");
				sc.nextLine();
			}
		} while (!band);
		return valor;
	}
    
    public static void mostrarValores (int[] vector) {
    	System.out.println("\n*** Mostrando Valores ***");
    	for(int a=0; a<vector.length;a++)
    		System.out.println("vector[" + a +"] = "+ vector[a]);
    }
    
    public static int sumarValores (int [] vector) {
    	int suma=0;
    	for(int valor:vector)
    		suma=suma+valor;
    	return suma;
    }
}
