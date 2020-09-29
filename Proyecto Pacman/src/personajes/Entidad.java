/**
 * 
 */
package personajes;

import utils.NewPositionsHelper;
import java.awt.Image;
import board.Tablero;

/**
 * Representa un objeto que puede moverse por el tablero durante la partida
 * @author Calderón Sergio, Ercoli Juan Martín
 * @version 1
 */
public abstract class Entidad {
	private Posicion posActual;
	private Direccion angulo;
	private NewPositionsHelper helper;
	private Image graficos;
	private boolean manejadoPorCPU;
	private int velocidadEnMs;
	
	/**
	 * Constructor por defecto, sin parámetros
	 */
	public Entidad() {
		this.helper = new NewPositionsHelper();
		this.posActual = new Posicion();
		this.resetearPosicion();
	}
	
	/**
	 * Constructor que permite referenciar el tablero
	 * @param tablero la instancia del tablero utilizada por la partida y 
	 * el resto de personajes
	 */
	public Entidad(Tablero tablero) {
		this();
		helper.referenciarTablero(tablero);
	}
	
	/**
	 * @return el valor del atributo posActual
	 */
	public Posicion getPosActual() {
		return posActual;
	}



	/**
	 * @param posActual el valor del atributo posActual a asignar
	 */
	public void setPosActual(Posicion posActual) {
		this.posActual = posActual;
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
	 * Restaura la ubicación por defecto, útil cuando PacMan pierde una vida
	 */
	public abstract void resetearPosicion();
	
	/**
	 * Cambia el ángulo a la siguiente dirección en el sentido de las agujas del reloj
	 */
	public void girarHorario() {
		switch (this.getAngulo()) {
			case DOWN: {
				this.setAngulo(Direccion.LEFT);
				break;
			}
			case LEFT: {
				this.setAngulo(Direccion.UP);
				break;
			}
			case UP: {
				this.setAngulo(Direccion.RIGHT);
				break;
			}
			case RIGHT: {
				this.setAngulo(Direccion.DOWN);
				break;
			}
		}
	}
	
	/**
	 * Delega el cálculo de la siguiente posición en la dirección propuesta y efectúa
	 * el movimiento en caso de que sea posible
	 * @param direccion el ángulo inicial, es decir, antes de efectuar el movimiento
	 * @return si fue posible avanzar en dicha dirección en el caso de entidades 
	 * manejadas por el usuario. Siempre devolverá true si lo maneja la CPU ya que 
	 * lo gira automáticamente, entonces la Partida puede ignorar el resultado en dicho caso
	 */
	public boolean intentarMov(Direccion direccion) {
		int[] vector = this.getPosActual().getVector();
		helper.getPosInmediata(vector, direccion);
		
		if (this.isManejadoPorCPU()) {
			while (!helper.validarPosicion(vector)) {
				this.girarHorario();
				helper.getPosInmediata(vector, direccion);
			}
			this.efectuarMov(vector);
			return true;
		} else {
			if (helper.validarPosicion(vector)) {
				this.efectuarMov(vector);
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Realiza la animación de pasar por un túnel y traslada la entidad a la posición de salida
	 * @param direccion En cuál de las 4 direcciones posibles está ingresando
	 */
	public void pasarPorTunel(Direccion direccion) {
		int[] vector = this.getPosActual().getVector();
		velocidadEnMs += 10;
		// efectuar animacion
		helper.getPosInversa(vector, direccion);
		this.efectuarMov(vector);
		velocidadEnMs -= 10;
	}
	
	/**
	 * Realiza la animación del personaje al moverse y actualiza su posición
	 * @param nuevaPos el vector (x,y) de la nueva celda válida a avanzar
	 */
	private void efectuarMov(int[] nuevaPos) {
		this.getPosActual().cambiar(nuevaPos[0], nuevaPos[1]);
		this.redibujar();
	}
	
	
	/**
	 * Actualiza el gráfico de la entidad
	 */
	private void redibujar() {
		// Implementación
	}
	
	/**
	 * 
	 * @return La instancia de utilidad para calcular y predecir posiciones
	 * (sólo está permitido su uso en clases heredadas, útil para los fantasmas)
	 */
	protected NewPositionsHelper getHelper() {
		return helper;
	}
}
