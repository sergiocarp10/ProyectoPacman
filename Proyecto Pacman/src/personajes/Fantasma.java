/**
 * 
 */
package personajes;

import board.Tablero;

/**
 * @author Calderón Sergio, Ercoli Juan Martín
 * @version 1
 */
public abstract class Fantasma extends Entidad {

	/**
	 * 
	 */
	public Fantasma() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param tablero
	 */
	public Fantasma(Tablero tablero) {
		super(tablero);
		// TODO Auto-generated constructor stub
	}

	@Override
	void resetearPosicion() {
		// TODO Auto-generated method stub

	}

}
