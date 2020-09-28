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
		// TODO Auto-generated method stub
		super.setEstaEnCasa(true);
		super.setModo(ModoJuego.PERSECUCION);
		super.setAngulo(Direccion.UP);
		int[] posInicio = super.getHelper().getPosCasaSegunIndice(0);
		super.getPosActual().cambiar(posInicio[0], posInicio[1]);
	}

	/**
	 * Realiza el cambio de objetivo a partir de la ubicación de PacMan
	 * @param vector el par de valores (x,y) actuales de PacMan
	 * @param direccion En cuál de las 4 direcciones posibles está avanzando PacMan
	 */
	public void predecir(int[] vector, Direccion direccion) {
		super.getHelper().getPosConDelta(vector, direccion, CELDAS_DELANTE);
		super.cambiarObjetivo(vector[0], vector[1]);
	}
}
