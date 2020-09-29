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
	private static final int MIN_PORCE = 33, DELAY = 20;
	private int movUntilNextTarget;
	
	public Clyde() {
		// TODO Auto-generated constructor stub
		super();
	}

	public Clyde(Tablero tablero) {
		super(tablero, null, 2);
		// TODO Auto-generated constructor stub
		this.movUntilNextTarget = DELAY;
	}
	
	@Override
	public void resetearPosicion() {
		// TODO Auto-generated method stub
		super.setEstaEnCasa(true);
		super.setModo(ModoJuego.PERSECUCION);
		super.setAngulo(Direccion.UP);
		int[] posInicio = super.getHelper().getPosCasaSegunIndice(2);
		super.getPosicion().cambiar(posInicio[0], posInicio[1]);
	}
	
	@Override
	public void notificarPosPacman() {
		this.verificarSalirCasa();
		
		// Randomizar una esquina objetivo cada ciertos pasos
		if (--movUntilNextTarget == 0) {
			int[] random = super.getHelper().getRandomPosValida();
			super.cambiarObjetivo(random[0], random[1]);
			this.movUntilNextTarget = DELAY;
		}
	}
	
	/**
	 * Notifica al fantasma el porcentaje de puntos comidos y lo saca de la casa si es necesario
	 * @param porce el porcentaje (entre 0 y 100) de los puntos totales comidos del tablero
	 */
	private void verificarSalirCasa() {
		if (super.isEstaEnCasa() && super.getHelper().getPorcentajeComido() >= MIN_PORCE) {
			super.abandonarCasa();
		}
	}

}
