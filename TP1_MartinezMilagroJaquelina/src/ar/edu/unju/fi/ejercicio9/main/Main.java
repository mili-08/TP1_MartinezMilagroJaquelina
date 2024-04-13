package ar.edu.unju.fi.ejercicio9.main;

import java.util.Scanner;

import ar.edu.unju.fi.ejercicio9.model.Producto;

public class Main {
 
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
	 int a=1;
	 while(a<=3) {
		
		System.out.print("Ingrese el nombre del producto: ");
		String nombre = sc.next();
		System.out.print("Ingrese el codigo del producto: ");
		String codigo = sc.next();
		sc.nextLine();
		Double precio = verificarPrecio();
		Integer descuento = verificarDescuento();
		Producto producto = new Producto();
		producto.setNombre(nombre);
		producto.setCodigo(codigo);
		producto.setPrecio(precio);
		producto.setDescuento(descuento);
		System.out.println("\n----- MOSTRANDO DETALLE DE PRODUCTO  ------\n");
		System.out.println(producto.toString());
		System.out.println("Precio con descuento: $" + producto.calcularDescuento() + "\n");
		System.out.println("\n-------------------------------------------\n");
		a++;
	 }
	 sc.close();

	}
	public static Integer verificarDescuento () {
		Integer valor=0;
		boolean band;
		do
		{
			band=false;
			System.out.print("Ingrese el descuento 0 a 50: ");
			if (sc.hasNextInt()) {
				valor = sc.nextInt();
				sc.nextLine();
				if (valor>=0 && valor<=50)
					band=true;
				else
					System.out.println("\n ------ VALOR INVALIDO ---------\n");
			}
			else {
				System.out.println("\n------- VALOR INCORRECTO --------\n");
				sc.nextLine();
			}
		}while(!band);		
		return valor;
	}
	public static Double verificarPrecio () {
		Double valor=0.0;
		boolean band;
		do
		{
			band=false;
			System.out.print("Ingrese el precio: ");
			if (sc.hasNextDouble()) {
				valor=sc.nextDouble();
				sc.nextLine();
				band=true;
			}
			else {
				System.out.println("\n---- VALOR INVALIDO ------\n");
				sc.nextLine();
			}
		}while(!band);		
		return valor;
	}

}
