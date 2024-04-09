package ar.edu.unju.fi.ejercicio8.model;

public class CalculadoraEspecial {
	private Integer n;

	public CalculadoraEspecial() {
	}

	public Integer getN() {
		return n;
	}

	public void setN(Integer n) {
		this.n = n;
	}
    
	public Integer calcularSumatoria () {
		int suma=0;
		for (int k=1; k<=this.n; k++) {
			suma+=(int)Math.pow(((k*(k+1))/2), 2);
		}
		return suma;
	}
	public Integer calcularProductoria () {
		int suma=1;
		for (int k=1; k<=this.n; k++) {
			suma*=(k*(k+4));
		}
		return suma;
	}
}
