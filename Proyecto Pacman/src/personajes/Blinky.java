/**
 * 
 */
package personajes;

import board.Tablero;

/**
 * Representa al fantasma llamado Blinky, el cual se encarga de perseguir a PacMan en
 * todo momento si es posible
 * @author Calderón Sergio, Ercoli Juan Martín
 * @version 1
 */
public class Blinky extends Fantasma {

	/**
	 * Constructor por defecto, sin parámetros
	 */
	public Blinky() {
		// TODO Auto-generated constructor stub
		this(null);
	}

	/**
	 * Constructor que permite referenciar el tablero
	 * @param tablero la instancia del tablero utilizada por la partida y 
	 * el resto de personajes
	 */
	public Blinky(Tablero tablero) {
		super(tablero);
		// TODO Auto-generated constructor stub
		super.setNombre("Blinky");
		super.setColor(1);
	}
	
	@Override
	public void resetearPosicion() {
		// TODO Auto-generated method stub
		super.setEstaEnCasa(false);
		super.setModo(ModoJuego.PERSECUCION);
		super.setAngulo(Direccion.LEFT);
		// es el único fantasma que comienza fuera de la casa
		super.getPosicion().cambiar(14, 14);
	}
	
	/**
	 * Realiza un cambio de objetivo según la posición de PacMan
	 * @param x el valor de abscisas actual de PacMan
	 * @param y el valor de ordenada actual de PacMan
	 */
	public void notifyPos(int x, int y) {
		super.cambiarObjetivo(x, y);
	}

}
