/**
 * 
 */
package personajes;

import board.Tablero;

/**
 * Representa el fantasma llamado Inky, que tiene una estrategia avanzada 
 * para lograr emboscar a PacMan, utilizando las posiciones de éste y también de Blinky
 * @author Calderón Sergio, Ercoli Juan Martín
 * @version 1
 */
public class Inky extends Fantasma {
	private static final int CELDAS_DELANTE = 2;
	private static final int MIN_PUNTOS_SALIR = 30;
	
	/**
	 * Constructor por defecto, sin parámetros
	 */
	public Inky() {
		// TODO Auto-generated constructor stub
		this(null);
	}

	/**
	 * Constructor que permite referenciar el tablero
	 * @param tablero la instancia del tablero utilizada por la partida y 
	 * el resto de personajes
	 */
	public Inky(Tablero tablero) {
		super(tablero);
		// TODO Auto-generated constructor stub
		super.setNombre("Inky");
		super.setColor(5);
	}
	
	@Override
	public void resetearPosicion() {
		// TODO Auto-generated method stub
		super.setEstaEnCasa(true);
		super.setModo(ModoJuego.PERSECUCION);
		super.setAngulo(Direccion.DOWN);
		int[] posInicio = super.getHelper().getPosCasaSegunIndice(1);
		super.getPosicion().cambiar(posInicio[0], posInicio[1]);
	}
	
	/**
	 * Realiza el cambio de objetivo a partir de la información de Pacman y Blinky
	 * @param posPacman el vector posición de PacMan
	 * @param dirPacman en cuál de las 4 direcciones está avanzando PacMan
	 * @param posBlinky el vector posición de Blinky
	 */
	public void predecir(int[] posPacman, Direccion dirPacman, int[] posBlinky) {
		super.getHelper().getPosConDelta(posPacman, dirPacman, CELDAS_DELANTE);
		int[] vec = this.calcularVector(posPacman, posBlinky);
		this.duplicarVector(vec);
		super.cambiarObjetivo(vec[0], vec[1]);
	}
	
	/**
	 * Notifica al fantasma el puntaje actual y lo saca de la casa si es necesario
	 * @param puntaje la cantidad de puntos actuales en la partida
	 */
	public void notifyPuntos(int puntaje) {
		if (super.isEstaEnCasa() && puntaje >= MIN_PUNTOS_SALIR) {
			super.abandonarCasa();
		}
	}
	
	/**
	 * Traza un vector entre dos posiciones
	 * @param v1 el vector de la primera posición
	 * @param v2 el vector de la segunda posición
	 * @return el vector resultante de ir desde la primera hasta la segunda
	 */
	private int[] calcularVector(int[] v1, int[] v2) {
		// implementación
		return null;
	}
	
	/**
	 * Multiplica ambos pares de valores (x,y) por dos y lo devuelve vía parámetro
	 * @param vector el arreglo de dos numeros correspondientes al vector
	 */
	private void duplicarVector(int[] vector) {
		vector[0] *= 2;
		vector[1] *= 2;
	}
}
