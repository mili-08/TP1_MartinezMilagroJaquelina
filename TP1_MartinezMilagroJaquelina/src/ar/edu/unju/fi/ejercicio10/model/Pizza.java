package ar.edu.unju.fi.ejercicio10.model;

public class Pizza {
	private Integer diametro;
	private Integer precio;
	private Boolean ingredientesEsp;
	private Double area;

	private final Integer ADICIONAL_20 = 500;
	private final Integer ADICIONAL_30 = 750;
	private final Integer ADICIONAL_40 = 1000;

	public Pizza() {

	}

	@Override
	public String toString() {
		return "Diametro = " + diametro + "\nPrecio = " + precio + "$\nIngredientes Especiales = " + ingredientesEsp + "\nArea = "
				+ area + "\n";
	}

	public Integer getDiametro() {
		return diametro;
	}

	public void setDiametro(Integer diametro) {
		this.diametro = diametro;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

	public Boolean getIngredientesEsp() {
		return ingredientesEsp;
	}

	public void setIngredientesEsp(Boolean ingredientesEsp) {
		this.ingredientesEsp = ingredientesEsp;
	}

	public Double getArea() {
		return area;
	}

	public void setArea(Double area) {
		this.area = area;
	}
    
	public void calcularPrecio () {
		
		Integer precio=0;
		if(this.diametro == 20) 
			precio = this.ingredientesEsp ? 4500 + ADICIONAL_20 : 4500;
		else if(this.diametro == 30) 
			precio = this.ingredientesEsp ? 4800 + ADICIONAL_30 : 4800;
		else 
			precio = this.ingredientesEsp ? 5500 + ADICIONAL_40 : 5500;			
		this.precio=precio;
	}
	
    public void calcularArea () {
    	Double area= Math.PI*Math.pow(this.diametro/2.0, 2);
    	this.area=area;
    }
}
