package ar.edu.unju.fi.ejercicio13;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int[] valores = new int[8];
		for (int a = 0; a < valores.length; a++) {
          valores[a]=verificarEntero();
		}
	  System.out.println("\n*** VALORES ***");
	  for(int a=0;a<valores.length;a++)
		  System.out.println("valores[" + a + "] = " + valores[a]);
     sc.close();
	}
	
	public static int verificarEntero () {
		boolean band;
		int valor =0;
		do {
			band = false;
			try {
				System.out.print("Ingrese un valor: ");
				valor = sc.nextInt();
				band = true;
			} catch (InputMismatchException e) {
				System.out.println("\nInvalido, el valor debe ser un entero\n");
				sc.nextLine();
			}
		} while (!band);
		return valor;
	}

}
