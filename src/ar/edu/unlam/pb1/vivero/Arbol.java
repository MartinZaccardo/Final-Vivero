package ar.edu.unlam.pb1.vivero;

public class Arbol extends Planta implements Florales, Comparable<Arbol> {

	private final Double GANANCIA_ARBOL = 2.3;
	private Double estadoFloracion;
	private Integer madurezFrutos;
	private Double precio;

	public Arbol(int codigo, String nombre, double precio, int stock) {
		super(codigo, nombre, precio, stock);
	}
	
	public Arbol(int codigo, String nombre, double precio, int stock, Double estadoFloracion, Integer madurezFrutos) {
		super(codigo, nombre, precio, stock);
		this.estadoFloracion = estadoFloracion;
		this.madurezFrutos = madurezFrutos;
	}

	@Override
	public Double obtenerPrecio() {
		florar();
		producirFrutos();
		return this.precio;
	}

	/**
	 * Los arboles pueden dar flores, las que posteriormente se convertiran en
	 * frutos. Las flores tienen un rango de crecimiento, siendo 0 (el valor
	 * inicial) cuando no tiene flores aun y 100 cuando ya estan aptas para dar
	 * frutos. El precio del arbol se incrementa de acuerdo al avance de la
	 * floracion: - Menos de 33% de floracion incrementa un 5% su precio. - Entre
	 * 34% y 66% incrementa un 7.5% su precio. - Mas del 66% y menos de 100%
	 * incrementa un 8.5% su precio. - Cuando el estado de floracion llega al 100%,
	 * se comienza la produccion de frutos
	 */
	@Override
	public void florar() {
		Double incremento = 0.0;
		this.precio = 0.0;

		if (estadoFloracion <= 33) {
			incremento = GANANCIA_ARBOL * 0.05;
			this.precio = GANANCIA_ARBOL + incremento;
		}
		if (estadoFloracion > 33 && estadoFloracion <= 66) {
			incremento = GANANCIA_ARBOL * 0.075;
			this.precio = GANANCIA_ARBOL + incremento;
		}
		if (estadoFloracion > 66 && estadoFloracion <= 100) {
			incremento = GANANCIA_ARBOL * 0.085;
			this.precio = GANANCIA_ARBOL + incremento;
		}

	}

	/**
	 * Para poder producir frutos, el estado de floracion debe ser 100%. La
	 * produccion de frutos se mide entre 1 y 5 siendo 5 el mejor escenario. Cuando
	 * un arbol produce frutos, su precio aumenta 10% inicialmente (por tener el
	 * estado de floracion al 100%) y agrega al precio, el porcentaje de madurez.
	 * Ejemplo: precioBase = 100 + 10% (por floracion) + 3% (madurez actual de los
	 * frutos)
	 */
	@Override
	public void producirFrutos() {
		Double incremento = 0.0;
		
		if (estadoFloracion == 100) {
			incremento = GANANCIA_ARBOL * 0.1;
			this.precio += incremento;
		}
		
		switch(madurezFrutos) {
		case 1:
			incremento = GANANCIA_ARBOL * 0.01;
			this.precio += incremento;
			break;
		case 2:
			incremento = GANANCIA_ARBOL * 0.02;
			this.precio += incremento;
			break;
		case 3:
			incremento = GANANCIA_ARBOL * 0.03;
			this.precio += incremento;
			break;
		case 4:
			incremento = GANANCIA_ARBOL * 0.04;
			this.precio += incremento;
			break;
		case 5:
			incremento = GANANCIA_ARBOL * 0.05;
			this.precio += incremento;
			break;
		}

	}

	public Double getEstadoFloracion() {
		return estadoFloracion;
	}

	public void setEstadoFloracion(Double estadoFloracion) {
		this.estadoFloracion = estadoFloracion;
	}

	public Integer getMadurezFrutos() {
		return madurezFrutos;
	}

	public void setMadurezFrutos(Integer madurezFrutos) {
		this.madurezFrutos = madurezFrutos;
	}

	@Override
	public int compareTo(Arbol o) {
		return obtenerPrecio().compareTo(o.obtenerPrecio());
	}

}
