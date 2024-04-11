package ar.edu.unju.fi.ejercicio16;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		String[] vector = new String[5];
		int [] ocupado = new int[1];
		ocupado[0]=-1;
		for(int a=0;a<vector.length;a++) {
			System.out.print("Ingrese un nombre: ");
			vector[a]=sc.nextLine();
			ocupado[0]++;
		}
		
		mostrarValores(vector,ocupado);
		int indice = obtenerIndice(ocupado[0]);
		eliminarValor(vector,indice,ocupado);
		mostrarValores(vector,ocupado);
		sc.close();
	}
    	
	public static void mostrarValores(String[] vector, int[] ocupado) {
		System.out.println("\n*** MOSTRANDO VALORES ***\n");
		for(int a=0;a<=ocupado[0];a++)
			System.out.println(vector[a]);
		System.out.println("\nLa longitud del vector es: " + vector.length);
		System.out.println("\nCantidad de valores cargados: " + (ocupado[0] + 1));
	}
	
	public static int obtenerIndice(int longitudVector) {
		boolean band;
		byte valor=0;
		do
		{
			band=false;
			try {
				System.out.print("\nIngrese el numero del indice que desea eliminar: ");
				valor = sc.nextByte();
				sc.nextLine();	
				if (valor<=longitudVector && valor>=0)
					band=true;
				else {
					System.out.println("\nINVALIDO, INDICE INEXISTE DEBE SER MENOR O IGUAL A " + longitudVector + " Y MAYOR A 0 \n");
				}
			}catch (InputMismatchException e) {
				System.out.println("\nINVALIDO");
				sc.nextLine();	
			}	
		}while(!band);	
		return valor;
	}
	
	public static void eliminarValor(String[] vector, int indice, int[] ocupado) {
		
		if (ocupado[0] != -1) {
			while (indice != ocupado[0]) {
				vector[indice] = vector[indice + 1];
				indice++;
			}
			vector[ocupado[0]]="";
			ocupado[0]--;
		}else 
			System.out.println("\nNo hay elementos para eliminar");
	}
}
