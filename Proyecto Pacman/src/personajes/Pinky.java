/**
 * 
 */
package personajes;

import board.Tablero;

/**
 * Representa al fantasma llamado Pinky, el cual trata de emboscar a PacMan 
 * ubicando su objetivo 4 posiciones por delante
 * @author Calder�n Sergio, Ercoli Juan Mart�n
 * @version 1
 */
public class Pinky extends Fantasma {
	private static final int CELDAS_DELANTE = 4;
	
	/**
	 * Constructor por defecto, sin par�metros
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
		super.setModo(ModoJuego.PERSECUCION);
		super.getPosActual().cambiar(15, 16);
	}

	/**
	 * Realiza el cambio de objetivo a partir de la ubicaci�n de PacMan
	 * @param vector el par de valores (x,y) actuales de PacMan
	 * @param direccion En cu�l de las 4 direcciones posibles est� avanzando PacMan
	 */
	public void notifyPos(int[] vector, Direccion direccion) {
		this.predecir(vector, direccion);
		super.cambiarObjetivo(vector[0], vector[1]);
	}
	
	/**
	 * Utiliza {@link utils.NewPositionsHelper} para calcular una celda v�lida de emboscada
	 * @param vector el par de valores (x,y) actuales de PacMan
	 * @param direccion En cu�l de las 4 direcciones posibles est� avanzando PacMan
	 */
	private void predecir(int[] vector, Direccion direccion) {
		super.getHelper().getPosConDelta(vector, direccion, CELDAS_DELANTE);
	}
}
