package ar.edu.unju.fi.ejercicio7.main;

import java.util.Scanner;

import ar.edu.unju.fi.ejercicio7.model.Empleado;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese el legajo: ");
		String legajo = sc.next();
		System.out.println("Ingrese el nombre: ");
		sc.nextLine();
		String nombre = sc.nextLine();
		System.out.println("Ingrese el salario: ");
		Double salario = Double.parseDouble(sc.next());
		
		Empleado empleado = new Empleado(legajo, nombre, salario);
		empleado.mostrarDatos();
		empleado.aumentarSalario();
		empleado.mostrarDatos();
		sc.close();
	}

}
