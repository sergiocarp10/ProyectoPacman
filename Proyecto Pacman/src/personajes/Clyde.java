/**
 * 
 */
package personajes;

import board.Tablero;

/**
 * Representa al fantasma llamado Clyde, el cual no persigue en todo momento a PacMan
 * @author Calderón Sergio, Ercoli Juan Martín
 * @version 1
 */
public class Clyde extends Fantasma {
	private static final int MIN_PORCE = 33;
	
	/**
	 * Constructor por defecto, sin parámetros
	 */
	public Clyde() {
		// TODO Auto-generated constructor stub
		this(null);
	}

	/**
	 * Constructor que permite referenciar el tablero
	 * @param tablero la instancia del tablero utilizada por la partida y 
	 * el resto de personajes
	 */
	public Clyde(Tablero tablero) {
		super(tablero);
		// TODO Auto-generated constructor stub
		super.setNombre("Clyde");
		super.setColor(2);
	}
	
	@Override
	public void resetearPosicion() {
		// TODO Auto-generated method stub
		super.setEstaEnCasa(true);
		super.setModo(ModoJuego.PERSECUCION);
		super.setAngulo(Direccion.UP);
		int[] posInicio = super.getHelper().getPosCasaSegunIndice(2);
		super.getPosActual().cambiar(posInicio[0], posInicio[1]);
	}
	
	/**
	 * Notifica al fantasma el porcentaje de puntos comidos y lo saca de la casa si es necesario
	 * @param porce el porcentaje (entre 0 y 100) de los puntos totales comidos del tablero
	 */
	public void notifyPorce(int porce) {
		if (super.isEstaEnCasa() && porce >= MIN_PORCE) {
			super.abandonarCasa();
		}
	}

}
