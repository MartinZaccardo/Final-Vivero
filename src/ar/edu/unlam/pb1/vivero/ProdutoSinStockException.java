package ar.edu.unlam.pb1.vivero;

public class ProdutoSinStockException extends Exception {

	public ProdutoSinStockException (String mensaje) {
		super(mensaje);
	}
}
