package ar.edu.unju.fi.ejercicio8.main;

import java.util.Scanner;

import ar.edu.unju.fi.ejercicio8.model.CalculadoraEspecial;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean band;
		Integer valor=0;
		do {
			band=false;
			System.out.println("\nIngrese un valor entero: ");
			if(sc.hasNextInt()) {
				valor= sc.nextInt();
				band=true;
			}
			else {
				System.out.println("El valor es invalido");
				sc.nextLine();
			}
		}while(!band);
	    CalculadoraEspecial calculadora = new CalculadoraEspecial();
	    calculadora.setN(valor);
	    System.out.println("Sumatoria: " + calculadora.calcularSumatoria());
	    System.out.println("\nProducotoria: " + calculadora.calcularProductoria());
	    sc.close();
	}

}
