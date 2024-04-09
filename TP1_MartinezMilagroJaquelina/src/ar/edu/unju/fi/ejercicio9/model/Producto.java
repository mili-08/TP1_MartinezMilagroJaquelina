package ar.edu.unju.fi.ejercicio9.model;

public class Producto {
	private String nombre;
	private String codigo;
	private Double precio;
	private Integer descuento;

	public Producto() {

	}

	
	@Override
	public String toString() {
		return "\nNombre: " + nombre + "\nCodigo: " + codigo + "\nPrecio: " + precio + "\nDescuento: " + descuento + "\n";
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getDescuento() {
		return descuento;
	}

	public void setDescuento(Integer descuento) {
		this.descuento = descuento;
	}
	
	public Double calcularDescuento () {
		return this.precio - this.descuento;
	}

}
