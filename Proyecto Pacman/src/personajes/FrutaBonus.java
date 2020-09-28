/**
 * 
 */
package personajes;

import board.Tablero;

/**
 * Representa una fruta especial que puede aparecer hasta 2 veces durante un nivel. 
 * Se puede mover por el tablero. No asusta a los fantasmas, s�lo proporciona puntaje extra.
 * @author Calder�n Sergio, Ercoli Juan Mart�n
 * @version 1
 */
public class FrutaBonus extends Entidad {
	private boolean visible;
	
	/**
	 * Constructor por defecto, sin par�metros
	 */
	public FrutaBonus() {
		// TODO Auto-generated constructor stub
		this(null);
	}

	/**
	 * Constructor que permite referenciar el tablero
	 * @param tablero la instancia del tablero utilizada por la partida y 
	 * el resto de personajes
	 */
	public FrutaBonus(Tablero tablero) {
		super(tablero);
		// TODO Auto-generated constructor stub
		super.setManejadoPorCPU(true);
	}

	@Override
	public void resetearPosicion() {
		// TODO Auto-generated method stub
		super.getPosActual().cambiar(0, 16);
		super.setAngulo(Direccion.RIGHT);
		super.setVelocidadEnMs(0);
		this.setVisible(false);
	}
	
	
	
	/**
	 * @return el valor del atributo visible
	 */
	public boolean isVisible() {
		return visible;
	}

	/**
	 * @param visible el valor del atributo visible a asignar
	 */
	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	/**
	 * Hace aparecer la fruta por uno de los t�neles (por defecto, el izquierdo)
	 */
	public void aparecerPorTunel() {
		this.setVisible(true);
		super.setVelocidadEnMs(500);
	}
	
	/**
	 * Desaparece la fruta del tablero
	 */
	public void comer() {
		super.setVelocidadEnMs(0);
		this.setVisible(false);
		this.resetearPosicion();
	}

}
