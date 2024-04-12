package ar.edu.unju.fi.ejercicio7.main;

import java.util.Scanner;

import ar.edu.unju.fi.ejercicio7.model.Empleado;

public class Main {

	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.print("Ingrese el legajo: ");
		String legajo = sc.next();
		sc.nextLine();
		System.out.print("Ingrese el nombre: ");
		String nombre = sc.nextLine();
		Double salario = verificarSalario();

		
		Empleado empleado = new Empleado(legajo, nombre, salario);
		System.out.println("\n ----- DATOS ANTES DEL AUMENTO ------\n");
		empleado.mostrarDatos();
		empleado.aumentarSalario();
		System.out.println("\n ----- DATOS DESPUES DEL AUMENTO ------\n");
		empleado.mostrarDatos();
		sc.close();
	}
	
	public static Double verificarSalario() {
		Double salario =0d;
		boolean band;
		do
		{
			band=false;
			try {
				System.out.print("Ingrese el salario: ");
				salario = Double.parseDouble(sc.next());
				sc.nextLine();
				band=true;
			}catch (NumberFormatException e) {
				System.out.println("\n ---- INVALIDO, DEBE SER UN VALOR REAL -----\n");
			    sc.nextLine();
			}
		}while(!band);
		
		return salario;
	}

}
