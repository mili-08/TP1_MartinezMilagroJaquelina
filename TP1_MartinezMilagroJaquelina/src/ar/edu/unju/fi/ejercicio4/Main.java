package ar.edu.unju.fi.ejercicio4;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Integer valor=0;
		boolean band;
		do
		{
			band=false;
			System.out.println("\nIngrese un valor entero de 1 a 10:");
			if (sc.hasNextInt()) {
				valor = sc.nextInt();
				if (valor >=1 && valor <=10) 
					band=true;
				else 
				{
					System.out.println("El valor debe ser 1 a 10");
					sc.nextLine();
				} 
			}else {
				System.out.println("El valor debe ser numerico del 1 al 10");
				sc.nextLine();
			}
		}while(!band);
		System.out.println("\nEl factorial de " +valor+ " es: " + calcularFactorial(valor));
		sc.close();
	}
	
	 public static Integer calcularFactorial (Integer valor) {
		int aux=1;
		while(valor!=0) {
			aux=aux*valor;
			valor--;
		}
		return aux;
	}
}
