/**
 * 
 */
package personajes;

import board.Tablero;

/**
 * Representa el personaje manejado por el usuario
 * @author Calderón Sergio, Ercoli Juan Martín
 * @version 1
 */
public class Pacman extends Entidad {
	private int vidas;
	private boolean enMovimiento;
	
	/**
	 * Constructor por defecto, sin parámetros
	 */
	public Pacman() {
		// TODO Auto-generated constructor stub
		this(null);
	}

	/**
	 * Constructor que permite referenciar el tablero
	 * @param tablero la instancia del tablero utilizada por la partida y 
	 * el resto de personajes
	 */
	public Pacman(Tablero tablero) {
		super(tablero);
		// TODO Auto-generated constructor stub
		super.setManejadoPorCPU(false);
	}
	
	

	/**
	 * Constructor que permite referenciar el tablero y asignar una cantidad de vidas
	 * @param tablero la instancia del tablero utilizada por la partida y 
	 * el resto de personajes
	 * @param vidas la cantidad de vidas al inicio de la partida
	 */
	public Pacman(Tablero tablero, int vidas) {
		this(tablero);
		this.vidas = vidas;
	}

	@Override
	public void resetearPosicion() {
		// TODO Auto-generated method stub
		super.getPosActual().cambiar(16, 20);
		super.setAngulo(Direccion.LEFT);
		super.setVelocidadEnMs(900);
		this.setEnMovimiento(true);
	}

	/**
	 * @return el valor del atributo vidas
	 */
	public int getVidas() {
		return vidas;
	}

	/**
	 * @param vidas el valor del atributo vidas a asignar
	 */
	public void setVidas(int vidas) {
		this.vidas = vidas;
	}

	/**
	 * @return el valor del atributo enMovimiento
	 */
	public boolean isEnMovimiento() {
		return enMovimiento;
	}

	/**
	 * @param enMovimiento el valor del atributo enMovimiento a asignar
	 */
	public void setEnMovimiento(boolean enMovimiento) {
		this.enMovimiento = enMovimiento;
	}
	
	/**
	 * Decrementa en uno la cantidad de vidas actuales de PacMan
	 * @return si hay quedan vidas disponibles
	 */
	public boolean restarVida() {
		this.animacionPerder();
		return (--this.vidas) > 0;
	}

	/**
	 * Realiza un giro del personaje durante unos segundos indicando que perdió una vida
	 */
	private void animacionPerder() {
		this.setEnMovimiento(false);
		for (int i=0; i<8; i++) {
			super.girarHorario();
			// delay
		}
	}
}
