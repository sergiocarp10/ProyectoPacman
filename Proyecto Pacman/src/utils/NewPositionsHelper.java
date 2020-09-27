package utils;

import board.Tablero;
import personajes.Direccion;

/**
 * Utilidad para calcular y verificar cambios de posici�n v�lidos
 * @author Calder�n Sergio, Ercoli Juan Mart�n
 * @version 1
 */
public class NewPositionsHelper {
	private Tablero tabReferencia;

	/**
	 * Constructor por defecto, sin par�metros
	 */
	public NewPositionsHelper() {
		
	}
	
	/**
	 * Asigna el tablero con el cual se efectuar�n los c�lculos
	 * @param unTablero El tablero de la partida actual, 
	 * debe ser la misma instancia para todos los personajes
	 */
	public void referenciarTablero(Tablero unTablero) {
		this.tabReferencia = unTablero;
	}
	
	/**
	 * Calcula y devuelve v�a par�metro la siguiente posici�n v�lida en la direcci�n solicitada
	 * @param posActual Los valores (x,y) actuales antes de efectuar el avance
	 * @param direccion En cu�l de las 4 direcciones definidas se est� moviendo
	 */
	public void getPosInmediata(int[] posActual, Direccion direccion) {
		// Implementaci�n
	}
	
	/**
	 * Calcula y devuelve v�a par�metro una futura posici�n v�lida en la direcci�n solicitada
	 * @param posActual Los valores (x,y) actuales antes de efectuar el avance
	 * @param direccion En cu�l de las 4 direcciones definidas se est� moviendo
	 * @param delta El n�mero de celdas por delante que se solicita calcular
	 */
	public void getPosConDelta(int[] posActual, Direccion direccion, int delta) {
		// Implementaci�n
	}
	
	/**
	 * Calcula y devuelve v�a par�metro la posici�n luego de atravesar un t�nel
	 * @param posicion Los valores (x,y) correspondientes al t�nel de ingreso
	 * @param direccion En cu�l de las 4 direcciones definidas ingres� al t�nel
	 */
	public void getPosInversa(int[] posicion, Direccion direccion) {
		// Implementaci�n
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
