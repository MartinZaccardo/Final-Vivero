package ar.edu.unlam.pb1.vivero;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestVivero {

	@Test
	public void queNoSePuedaAgregarMasDeUnaPlantaConElMismoCodigo() throws PlantaDuplicadaException {
		Vivero vivero = new Vivero("Rosadita");
		Planta planta = new Arbusto(1, "Rosa", 200.0, 100);
		Planta planta2 = new Arbol(1, "Pino", 600.0, 10);
		
		
		Boolean plantaAgregada = vivero.agregarPlanta(planta);
		Boolean plantaAgregada2 = vivero.agregarPlanta(planta2);
		
		assertTrue(plantaAgregada);
		assertTrue(plantaAgregada2);
		
		// Exception de planta duplicada
	
	}
	
	@Test
	public void queNoSePuedaVenderUnaPlantaPorqueNoHayStock() throws PlantaDuplicadaException, PlantaInexistenteException, ProdutoSinStockException {
		Vivero vivero = new Vivero("Rosadita");
		Planta planta = new Arbusto(1, "Rosa", 200.0, 40);
		
		vivero.agregarPlanta(planta);
		
		vivero.venderPlanta(1, 50);
		
		//Excpetion de producto sin stock
		
	}
	
	@Test
	public void obtenerListaArboles() throws PlantaDuplicadaException {
		Vivero vivero = new Vivero("Rosadita");
		vivero.obtenerTodasLasVentasDeArbolesOrdenadosPorElValorTotalDeLaVenta();
		
		Planta planta = new Arbol(1, "Pino", 600.0, 100, 45.0, 3);
		Planta planta2 = new Arbol(2, "Roble", 1600.0, 100, 35.0, 1);
		Planta planta3 = new Arbol(3, "Cerezo", 300.0, 100, 100.0, 5);
		
		vivero.agregarPlanta(planta);
		vivero.agregarPlanta(planta2);
		vivero.agregarPlanta(planta3);
	}

}
