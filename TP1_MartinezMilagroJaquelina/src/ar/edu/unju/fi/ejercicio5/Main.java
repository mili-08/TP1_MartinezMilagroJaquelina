package ar.edu.unju.fi.ejercicio5;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Integer valor=0;
		boolean band;
		do
		{
			band=false;
			System.out.println("\nIngrese un valor de 1 a 9: ");
		    if(sc.hasNextInt()) {
		    	valor=sc.nextInt();
		    	if(valor>=1 && valor<=9)
		    	   band=true;
		    	else {
			    	System.out.println("Debe ser un valor de 1 a 9");
			    	sc.nextLine();
			    }   		
		    }else {
		    	System.out.println("Debe ser un valor de 1 a 9");
		    	sc.nextLine();
		    }
		}while(!band);
		for(int a=0; a<=10; a++) 
			System.out.println(valor + " x " + a + " = " + (valor*a));
	}

}
