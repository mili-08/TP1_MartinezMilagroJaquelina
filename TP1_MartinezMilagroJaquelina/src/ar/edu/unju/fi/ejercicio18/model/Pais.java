package ar.edu.unju.fi.ejercicio18.model;

public class Pais {
   private Integer codigo;
   private String nombre;
   
   public Pais() {
}

public Pais(Integer codigo, String nombre) {
	super();
	this.codigo = codigo;
	this.nombre = nombre;
}

public Integer getCodigo() {
	return codigo;
}

public void setCodigo(Integer codigo) {
	this.codigo = codigo;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

@Override
public String toString() {
	return "\nCodigo del pais: " + codigo + "\nNombre del pais: " + nombre + "\n";
}
   
   
}
