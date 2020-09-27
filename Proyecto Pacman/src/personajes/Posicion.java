package personajes;
/**
 * 
 */

/**
 * Representa una ubicaci�n en el plano dada por un par de valores (x,y)
 * @author Calder�n Sergio, Ercoli Juan Mart�n
 * @version 1
 */
public class Posicion {
	int x, y;

	/**
	 * Constructor que permite inicializar variables
	 * @param x el valor de la abscisa (eje X)
	 * @param y el valor de la ordenada (eje Y)
	 */
	public Posicion(int x, int y) {
		this.cambiar(x, y);
	}

	/**
	 * Constructor por defecto, sin par�metros
	 */
	public Posicion() {
		
	}

	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	
	/**
	 * M�todo que permite actualizar la coordenada
	 * @param x el nuevo valor de la abscisa (eje X)
	 * @param y el nuevo valor de la ordenada (eje Y)
	 */
	public void cambiar(int x, int y) {
		this.setX(x);
		this.setY(y);
	}
	
}
