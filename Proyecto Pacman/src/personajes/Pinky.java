/**
 * 
 */
package personajes;

import board.Tablero;

/**
 * Representa al fantasma llamado Pinky, el cual trata de emboscar a PacMan 
 * ubicando su objetivo 4 posiciones por delante
 * @author Calderón Sergio, Ercoli Juan Martín
 * @version 1
 */
public class Pinky extends Fantasma {
	private static final int CELDAS_DELANTE = 4;
	
	/**
	 * Constructor por defecto, sin parámetros
	 */
	public Pinky() {
		// TODO Auto-generated constructor stub
		this(null);
	}

	/**
	 * Constructor que permite referenciar el tablero
	 * @param tablero la instancia del tablero utilizada por la partida y 
	 * el resto de personajes
	 */
	public Pinky(Tablero tablero) {
		super(tablero);
		// TODO Auto-generated constructor stub
		super.setNombre("Pinky");
		super.setColor(7);
	}
	
	@Override
	public void resetearPosicion() {
		super.setEstaEnCasa(true);
		super.getPosActual().cambiar(x, y);
	}

}
