package ar.edu.unlam.pb1.vivero;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Collections;

public class Vivero {
	
	/**
	 * Se deberan realizar los siguientes tests
	 * 
	 * - 1 test para el metodo agregarPlanta() que arroje la excepcion de validacion
	 * - 1 test para el metodo venderPlanta() que arroje una excepcion a eleccion
	 * - 1 test para el metodo obtenerTodasLasVentasDeArbolesOrdenadosPorElValorTotalDeLaVenta()
	 * - 1 test para el metodo obtenerReporteDePlantasAgrupadasPorTipo()
	 * - 1 test para el metodo obtenerTodasLasPlantasFlorales()
	 * - 1 test para el metodo obtenerPrecio() de la clase Planta 
	 * - 1 test para el metodo obtenerPrecio() de alguna clase que implemente la interfaz Florales en estado de floracion
	 * - 1 test para el metodo obtenerPrecio() de alguna clase que implemente la interfaz Florales en estado de produccion
	 * */

	private String nombre;

	// No se pueden registrar plantas duplicadas. 2 plantas son iguales cuando tiene
	// el mismo Id
	private Map<Integer, Planta> plantas;
	private List<Planta> ventas;

	public Vivero(String nombre) {
		plantas = new TreeMap<>();
		ventas = new ArrayList<>();
	}

	// No puede haber 2 plantas con el mismo Id , Si se duplica lanza una Exception
	// Planta Duplicada Exception
	public Boolean agregarPlanta(Planta planta) throws PlantaDuplicadaException {
		/*try {
			if(!plantas.containsKey(planta.getCodigo())) {
				plantas.put(planta.getCodigo(), planta);
				return true;
			} else {
				throw new PlantaDuplicadaException("No puede haber dos plantas con el mismo id");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}*/
		if(!plantas.containsKey(planta.getCodigo())) {
			plantas.put(planta.getCodigo(), planta);
			return true;
		} else {
			throw new PlantaDuplicadaException("No puede haber dos plantas con el mismo id");
		}
		
		
	}

	/*
	 * Registra una venta y descuenta del stock de la planta la cantidad deseada. Si no se encuentra la planta lanza
	 * una exception Planta Inexistente. Si no hay Stock Lanza Una Exception
	 * ProdutoSinStockException
	 */
	public void venderPlanta(Integer codigoPlanta, Integer cantidadAVender) throws PlantaInexistenteException, ProdutoSinStockException {
		if(!plantas.containsKey(codigoPlanta)) {
			throw new PlantaInexistenteException("La planta a vender no existe");
		} if (plantas.get(codigoPlanta).getStock() < cantidadAVender) {
			throw new ProdutoSinStockException("No hay suficiente stock");
		}
		Planta planta = plantas.get(codigoPlanta);
		Integer stock = planta.getStock();
		planta.setStock(stock - cantidadAVender);
	}

	/*
	 * Obtener un listado de todos los arboles vendidos ordenados por el total de
	 * venta (Cantidad * precioDeLaPlanta)
	 * 
	 */
	
	public Integer getCantidadDePlantas() {
		return plantas.size();
	}
	
	public ArrayList<Arbol> obtenerTodasLasVentasDeArbolesOrdenadosPorElValorTotalDeLaVenta() {
		/*List<Arbol> arboles = new ArrayList<>(); 
		
		for (Map.Entry<Integer, Planta> arbol : plantas.entrySet()) {
			if(arbol instanceof Arbol) {
			System.out.println("Key = " + arbol.getKey() + 
                    ", Value = " + arbol.getValue());
			}
		}		*/
		return null;
	}

	/*
	 * Obtener Un reporte de las plantas vendidas agrupados por tipo Plantas
	 * 
	 * 
	 * Ejemplo: para una key "arbol", debemos completar las plantas de este tipo
	 * 
	 */

	/*public Map<String, ______> obtenerReporteDePlantasAgrupadasPorTipo() {
		return null;
	}

	/**
	 * Obtener una lista de plantas que implementen la interfaz correspondiente
	 * */
	/*public List<Florales> obtenerTodasLasPlantasFlorales() {
	}*/
}
