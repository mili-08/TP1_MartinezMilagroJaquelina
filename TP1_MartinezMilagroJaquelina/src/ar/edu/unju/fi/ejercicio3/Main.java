package ar.edu.unju.fi.ejercicio3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean band;
		do
		{
			band=false;
			System.out.println("Ingrese un valor entero: ");
			if (sc.hasNextInt()) {
				Integer valor = sc.nextInt();
				if (valor%2==0)
					System.out.println("Resutado: " + 3*valor);
				else 
					System.out.println("Resultado: " + 2*valor);
				band=true;
			}else {
			  System.out.println("EL valor ingresado no es valido\n");
			  sc.next(); //Para limpiar el bufer
			}
		}while(!band);
      sc.close();
	}

}
