/**
 * 
 */
package personajes;

import utils.NewPositionsHelper;
import java.awt.Image;

/**
 * Representa un objeto que puede moverse por el tablero durante la partida
 * @author Calder�n Sergio, Ercoli Juan Mart�n
 * @version 1
 */
public abstract class Entidad {
	private Posicion mPosicion;
	private Direccion angulo;
	private NewPositionsHelper helper;
	private Image graficos;
	private boolean manejadoPorCPU;
	private int velocidadEnMs;
	
	/**
	 * Constructor por defecto, sin par�metros
	 */
	public Entidad() {
		this.helper = new NewPositionsHelper();
		this.resetearPosicion();
	}
	
	/**
	 * Constructor que permite referenciar el tablero
	 * @param tablero la instancia del tablero utilizada por la partida y 
	 * el resto de personajes
	 */
	public Entidad(board.Tablero tablero) {
		this();
		helper.referenciarTablero(tablero);
	}
	
	/**
	 * @return el valor del atributo mPosicion
	 */
	public Posicion getmPosicion() {
		return mPosicion;
	}



	/**
	 * @param mPosicion el valor del atributo mPosicion a asignar
	 */
	public void setmPosicion(Posicion mPosicion) {
		this.mPosicion = mPosicion;
	}



	/**
	 * @return el valor del atributo angulo
	 */
	public Direccion getAngulo() {
		return angulo;
	}



	/**
	 * @param angulo el valor del atributo angulo a asignar
	 */
	public void setAngulo(Direccion angulo) {
		this.angulo = angulo;
	}


	/**
	 * @return el valor del atributo graficos
	 */
	public Image getGraficos() {
		return graficos;
	}



	/**
	 * @param graficos el valor del atributo graficos a asignar
	 */
	public void setGraficos(Image graficos) {
		this.graficos = graficos;
	}



	/**
	 * @return el valor del atributo manejadoPorCPU
	 */
	public boolean isManejadoPorCPU() {
		return manejadoPorCPU;
	}



	/**
	 * @param manejadoPorCPU el valor del atributo manejadoPorCPU a asignar
	 */
	public void setManejadoPorCPU(boolean manejadoPorCPU) {
		this.manejadoPorCPU = manejadoPorCPU;
	}



	/**
	 * @return el valor del atributo velocidadEnMs
	 */
	public int getVelocidadEnMs() {
		return velocidadEnMs;
	}



	/**
	 * @param velocidadEnMs el valor del atributo velocidadEnMs a asignar
	 */
	public void setVelocidadEnMs(int velocidadEnMs) {
		this.velocidadEnMs = velocidadEnMs;
	}



	/**
	 * Restaura la ubicaci�n por defecto, �til cuando PacMan pierde una vida
	 */
	abstract void resetearPosicion();
	
	/**
	 * Delega el c�lculo de la siguiente posici�n en la direcci�n propuesta y efect�a
	 * el movimiento en caso de que sea posible
	 * @param direccion el �ngulo inicial, es decir, antes de efectuar el movimiento
	 * @return si fue posible avanzar en dicha direcci�n en el caso de entidades 
	 * manejadas por el usuario. Siempre devolver� true si lo maneja la CPU ya que 
	 * lo gira autom�ticamente
	 */
	public boolean intentarMov(Direccion direccion) {
		int[] vector = mPosicion.getVector();
		helper.getPosInmediata(vector, direccion);
		
		if (this.manejadoPorCPU) {
			while (!helper.validarPosicion(vector)) {
				this.girarHorario();
				helper.getPosInmediata(vector, direccion);
			}
			mPosicion.cambiar(vector[0], vector[1]);
			return true;
		} else {
			if (helper.validarPosicion(vector)) {
				mPosicion.cambiar(vector[0], vector[1]);
				return true;
			}
		}
		
		return false;
	}
	
	public void pasarPorTunel(Direccion direccion) {
		int[] vector = mPosicion.getVector();
		velocidadEnMs += 10;
		// efectuar animacion
		helper.getPosInversa(vector, direccion);
		mPosicion.cambiar(vector[0], vector[1]);
		velocidadEnMs -= 10;
	}
	
	
	/**
	 * Cambia el �ngulo a la siguiente direcci�n en el sentido de las agujas del reloj
	 */
	public void girarHorario() {
		switch (angulo) {
			case DOWN: {
				angulo = Direccion.LEFT;
				break;
			}
			case LEFT: {
				angulo = Direccion.UP;
				break;
			}
			case UP: {
				angulo = Direccion.RIGHT;
				break;
			}
			case RIGHT: {
				angulo = Direccion.DOWN;
				break;
			}
		}
	}
	
	/**
	 * Actualiza el gr�fico de la entidad
	 */
	private void redibujar() {
		// Implementaci�n
	}
}
