package ar.edu.unju.fi.ejercicio10.main;

import java.util.Scanner;

import ar.edu.unju.fi.ejercicio10.model.Pizza;

public class Main {

	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
	  int a=1;
	  System.out.println("----- Ingreso de Pedido -----\n");
	  while(a<=3)
	  {
	     Integer diametro = verificarDiametro();
	     Boolean ingredientesEsp = verificarIngEsp();
	     Pizza pizza = new Pizza();
	     pizza.setDiametro(diametro);
	     pizza.setIngredientesEsp(ingredientesEsp);
	     pizza.calcularArea();
	     pizza.calcularPrecio();
	     
	     System.out.println("\n**** Pizza " + a + " ****\n");
	     System.out.println(pizza.toString());
	     System.out.println("\n**************************\n");
	     a++;
	  }
	  sc.close();

	}
	
	public static Integer verificarDiametro() {
		boolean band;
		Integer diametro=0;
		do
		{
			band=false;
			System.out.print("Ingrese el diametro de la pizza pequenia(20), mediana(30) y grande(40): ");
			if(sc.hasNextInt()) {
			    diametro = sc.nextInt();
			    sc.nextLine();
				if(diametro == 20 || diametro == 30 || diametro == 40) {
					band=true;
				}else {
					System.out.println("\n--- INVALIDO!!, debe ser 20, 30 o 40 ---\n");
					sc.nextLine();
				}
			}else {
				System.out.println("\n--- INVALIDO!!, debe ser 20, 30 o 40 ---\n");
				sc.nextLine();
			}
		}while(!band);	
		return diametro;
	}
	
	public static Boolean verificarIngEsp() {
		Boolean band, aux=false;
		do
		{
			band=false;
			System.out.print("\nSi tiene ingredientes especiales escriba 'T' sino 'F': ");
			String valor = sc.next();
			if(valor.toUpperCase().equals("T") || valor.toUpperCase().equals("F")) {
				band=true;
			 aux=valor.toUpperCase().equals("T") ? true : false;	
			}
			else {
				System.out.println("\n----- Por favor, escriba 'T' para ingredientes especiales y sino 'F' ------\n");
			    sc.nextLine();
			}
		}while(!band);
		return aux;
	}

}
