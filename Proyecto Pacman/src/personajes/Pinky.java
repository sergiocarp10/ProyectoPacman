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
	
	public Pinky() {
		// TODO Auto-generated constructor stub
		super();
	}

	public Pinky(Tablero tablero, Pacman pacman) {
		super(tablero, pacman, 7);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void resetearPosicion() {
		// TODO Auto-generated method stub
		super.setEstaEnCasa(true);
		super.setModo(ModoJuego.PERSECUCION);
		super.setAngulo(Direccion.UP);
		int[] posInicio = super.getHelper().getPosCasaSegunIndice(0);
		super.getPosicion().cambiar(posInicio[0], posInicio[1]);
	}

	@Override
	public void notificarPosPacman() {
		int[] vector = super.getPacman().getPosicion().getVector();
		super.getHelper().getPosConDelta(vector, super.getPacman().getAngulo(), CELDAS_DELANTE);
		super.cambiarObjetivo(vector[0], vector[1]);
	}
}
