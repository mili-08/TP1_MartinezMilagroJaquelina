package ar.edu.unju.fi.ejercicio9.main;

import java.util.Scanner;

import ar.edu.unju.fi.ejercicio9.model.Producto;

public class Main {

	public static void main(String[] args) {
	 Scanner sc = new Scanner(System.in);
	 int a=1;
	 while(a<=3) {
		
		System.out.println("Ingrese el nombre del producto: ");
		String nombre = sc.next();
		System.out.println("Ingrese el codigo del producto: ");
		String codigo = sc.next();
		Double precio = verificarPrecio();
		Integer descuento = verificarDescuento();
		Producto producto = new Producto();
		producto.setNombre(nombre);
		producto.setCodigo(codigo);
		producto.setPrecio(precio);
		producto.setDescuento(descuento);
		System.out.println(producto.toString());
		a++;
	 }
	 sc.close();

	}
	public static Integer verificarDescuento () {
		Scanner sc = new Scanner(System.in);
		Integer valor=0;
		boolean band;
		do
		{
			band=false;
			System.out.println("Ingrese el descuento 1 a 50: ");
			if (sc.hasNextInt()) {
				valor = sc.nextInt();
				if (valor>=1 && valor<=50)
					band=true;
				else {
					System.out.println("VALOR INVALIDO");
					sc.nextLine();
				}
			}
			else {
				System.out.println("VALOR INVALIDO");
				sc.nextLine();
			}
		}while(!band);		
		return valor;
	}
	public static Double verificarPrecio () {
		Scanner sc = new Scanner(System.in);
		Double valor=0.0;
		boolean band;
		do
		{
			band=false;
			System.out.println("Ingrese el precio: ");
			if (sc.hasNextDouble()) {
				valor=sc.nextDouble();
				band=true;
			}
			else {
				System.out.println("VALOR INVALIDO");
				sc.nextLine();
			}
		}while(!band);		
		return valor;
	}

}
