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

	public Blinky() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public Blinky(Tablero tablero, Pacman pacman) {
		super(tablero, pacman, 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void resetearPosicion() {
		// TODO Auto-generated method stub
		super.setEstaEnCasa(true);
		super.setModo(ModoJuego.PERSECUCION);
		super.setAngulo(Direccion.LEFT);
		int[] posInicio = super.getHelper().getPosCasaSegunIndice(1);
		super.getPosicion().cambiar(posInicio[0], posInicio[1]);
	}

	@Override
	public void notificarPosPacman() {
		// TODO Auto-generated method stub
		Posicion posPacman = super.getPacman().getPosicion();
		super.cambiarObjetivo(posPacman.getX(), posPacman.getY());
	}

}
