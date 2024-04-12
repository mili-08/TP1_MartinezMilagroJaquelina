package ar.edu.unju.fi.ejercicio7.model;

public class Empleado {
   private String legajo;
   private String nombre;
   private Double salario; 
   
   private final Double SALARIO_MINIMO = (double) 210000;
   private final Double AUMENTO_MERITOS = (double) 20000;

	public Empleado(String legajo, String nombre, Double salario) {
		super();
		this.legajo = legajo;
		this.nombre = nombre;
		if (salario>=SALARIO_MINIMO)
			this.salario=salario;
		else 
			this.salario = SALARIO_MINIMO;
	}
    
	public void aumentarSalario () {
		this.salario = salario + AUMENTO_MERITOS;
	}
	
	public void mostrarDatos() {
		System.out.println("Nombre del Empleado: " + nombre +"\nLegajo: " +legajo +  "\nSalario: $" + salario);
	}
   
}
