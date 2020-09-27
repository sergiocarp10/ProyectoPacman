/**
 * 
 */
package utils;

/**
 * Representa una cuenta regresiva para realizar acciones a posteriori
 * @author Calder�n Sergio, Ercoli Juan Mart�n
 * @version 1
 */
public class Temporizador {
	private int tiempo;
	
	/**
	 * Constructor por defecto, sin par�metros
	 */
	public Temporizador() {
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * Constructor que permite asignar un tiempo
	 * @param tiempo La cantidad de segundos a asignar
	 */
	public Temporizador(int tiempo) {
		this.tiempo = tiempo;
	}



	/**
	 * @return el valor del atributo tiempo
	 */
	public int getTiempo() {
		return tiempo;
	}

	/**
	 * @param tiempo el valor del atributo tiempo a asignar
	 */
	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}
	
	/**
	 * Comienza la cuenta regresiva desde un tiempo antes asignado
	 */
	public void iniciar() {
		// Implementaci�n
	}
	
	/**
	 * Verifica si el temporizador lleg� a su fin
	 * @return Si ya transcurrieron los segundos asignados
	 */
	public boolean fin() {
		return this.getTiempo() == 0;
	}

}
