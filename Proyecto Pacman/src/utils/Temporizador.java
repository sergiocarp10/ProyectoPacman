/**
 * 
 */
package utils;

/**
 * Representa una cuenta regresiva para realizar acciones a posteriori
 * @author Calderón Sergio, Ercoli Juan Martín
 * @version 1
 */
public class Temporizador {
	private int tiempo;
	
	/**
	 * Constructor por defecto, sin parámetros
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
		// Implementación
	}
	
	/**
	 * Verifica si el temporizador llegó a su fin
	 * @return Si ya transcurrieron los segundos asignados
	 */
	public boolean fin() {
		return this.getTiempo() == 0;
	}

}
