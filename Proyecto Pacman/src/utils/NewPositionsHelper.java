package utils;

import board.Tablero;
import personajes.Direccion;

/**
 * Utilidad para calcular y verificar cambios de posición válidos
 * @author Calderón Sergio, Ercoli Juan Martín
 * @version 1
 */
public class NewPositionsHelper {
	private Tablero tabReferencia;

	/**
	 * Constructor por defecto, sin parámetros
	 */
	public NewPositionsHelper() {
		
	}
	
	/**
	 * Asigna el tablero con el cual se efectuarán los cálculos
	 * @param unTablero El tablero de la partida actual, 
	 * debe ser la misma instancia para todos los personajes
	 */
	public void referenciarTablero(Tablero unTablero) {
		this.tabReferencia = unTablero;
	}
	
	/**
	 * Calcula y devuelve vía parámetro la siguiente posición válida en la dirección solicitada
	 * @param posActual Los valores (x,y) actuales antes de efectuar el avance
	 * @param direccion En cuál de las 4 direcciones definidas se está moviendo
	 */
	public void getPosInmediata(int[] posActual, Direccion direccion) {
		// Implementación
	}
	
	/**
	 * Calcula y devuelve vía parámetro una futura posición válida en la dirección solicitada
	 * @param posActual Los valores (x,y) actuales antes de efectuar el avance
	 * @param direccion En cuál de las 4 direcciones definidas se está moviendo
	 * @param delta El número de celdas por delante que se solicita calcular
	 */
	public void getPosConDelta(int[] posActual, Direccion direccion, int delta) {
		// Implementación
	}
	
	/**
	 * Calcula y devuelve vía parámetro la posición luego de atravesar un túnel
	 * @param posicion Los valores (x,y) correspondientes al túnel de ingreso
	 * @param direccion En cuál de las 4 direcciones definidas ingresó al túnel
	 */
	public void getPosInversa(int[] posicion, Direccion direccion) {
		// Implementación
	}
	
	/**
	 * 
	 * @param x el valor de abscisa a consultar
	 * @param y el valor de ordenada a consultar
	 * @return si la celda calculada es transitable
	 */
	private boolean validarPosicion(int x, int y) {
		return this.tabReferencia.esTransitable(x, y);
	}
}
