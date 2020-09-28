/**
 *
 */
package board;

/**
 * Representa el conjunto de celdas del juego, las cuales son objetos que se encuentran en 
 * una posición fija y pueden cambiar su estado si es necesario (caso puntos y fruta).
 * @author Calderón Sergio, Ercoli Juan Martín
 * @version 1
 */
public class Tablero {
	private static final byte MAX_SIZE = 32;
	private int cantPuntosInicio, cantPuntosRestantes;
	private TipoCelda[][] matriz;
	
	/**
	 * Constructor sin parámetros, inicializa un tablero vacío de dimensiones por defecto
	 */
	public Tablero() {
		this.matriz = new TipoCelda[MAX_SIZE][MAX_SIZE];
	}
	
	
	
	public int getCantPuntosInicio() {
		return cantPuntosInicio;
	}



	public void setCantPuntosInicio(int cantPuntosInicio) {
		this.cantPuntosInicio = cantPuntosInicio;
	}



	public int getCantPuntosRestantes() {
		return cantPuntosRestantes;
	}



	public void setCantPuntosRestantes(int cantPuntosRestantes) {
		this.cantPuntosRestantes = cantPuntosRestantes;
	}



	/**
	 * Carga el tablero con los tipos de celda correspondientes
	 */
	public void crearPorDefecto() {
		// Implementación
	}
	
	/**
	 * 
	 * @param x el valor de abscisas a consultar
	 * @param y el valor de ordenada a consultar
	 * @return si la celda en la coordenada (x,y) es transitable
	 */
	public boolean esTransitable(int x, int y) {
		// Implementación
		return false;
	}
	
	/**
	 * 
	 * @param x el valor de abscisas a consultar
	 * @param y el valor de ordenada a consultar
	 * @return si la celda en la coordenada (x,y) es un túnel
	 */
	public boolean esTunel(int x, int y) {
		return this.matriz[x][y] == TipoCelda.TUNEL;
	}
	
	/**
	 * 
	 * @return Un arreglo con los valores (x,y) correspondientes a la casa.
	 */
	public int[] getEspacioCasa() {
		// Implementación
		return null;
	}
	
	/**
	 * 
	 * @param x el valor de abscisas a consultar
	 * @param y el valor de ordenada a consultar
	 * @return si la celda aún contiene un punto
	 */
	public boolean tieneComida(int x, int y) {
		return (this.matriz[x][y] == TipoCelda.PUNTO);
	}
	
	/**
	 * 
	 * @param x el valor de abscisas a consultar
	 * @param y el valor de ordenada a consultar
	 * @return si la celda contiene una de las 4 frutas
	 */
	public boolean tieneFruta(int x, int y) {
		return (this.matriz[x][y] == TipoCelda.FRUTA);
	}
	
	/**
	 * Establece una celda como libre y actualiza el contador de puntos restantes. 
	 * Invocar únicamente si se verificó anteriormente que la misma tiene comida o fruta
	 * @param x el valor de abscisas a cambiar
	 * @param y el valor de ordenada a cambiar
	 * @return Si se comieron todos los puntos del tablero
	 */
	public boolean quitarPunto(int x, int y) {
		this.matriz[x][y] = TipoCelda.LIBRE;
		this.cantPuntosRestantes--;
		return cantPuntosRestantes == 0;
	}
}
