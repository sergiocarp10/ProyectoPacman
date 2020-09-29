/**
 * 
 */
package personajes;

import board.Tablero;

/**
 * Representa los comportamientos comunes de los enemigos de PacMan
 * @author Calderón Sergio, Ercoli Juan Martín
 * @version 1
 */
public abstract class Fantasma extends Entidad {
	private ModoJuego modo = ModoJuego.PERSECUCION;
	private Posicion objetivo, esqAsignada;
	private Pacman pacman;
	private int color;
	private boolean estaEnCasa = true;
	
	public Fantasma() {
		// TODO Auto-generated constructor stub
		super();
	}

	/**
	 * Constructor que permite referenciar el tablero, la entidad a perseguir y asignar un color
	 * @param tablero la instancia del tablero utilizada por la partida y el resto de personajes
	 * @param pacman La instancia del PacMan que maneja el agente/usuario
	 * @param color El color particular (valores de 0 al 7)
	 */
	public Fantasma(Tablero tablero, Pacman pacman, int color) {
		super(tablero, true);
		this.color = color;
	}
	
	

	@Override
	public abstract void resetearPosicion();

	/**
	 * @return el valor del atributo modo
	 */
	public ModoJuego getModo() {
		return modo;
	}

	/**
	 * @param modo el valor del atributo modo a asignar
	 */
	public void setModo(ModoJuego modo) {
		this.modo = modo;
	}

	/**
	 * @return el valor del atributo color
	 */
	public int getColor() {
		return color;
	}

	/**
	 * @param color el valor del atributo color a asignar
	 */
	public void setColor(int color) {
		this.color = color;
	}

	/**
	 * @return el valor del atributo estaEnCasa
	 */
	public boolean isEstaEnCasa() {
		return estaEnCasa;
	}

	/**
	 * @param estaEnCasa el valor del atributo estaEnCasa a asignar
	 */
	public void setEstaEnCasa(boolean estaEnCasa) {
		this.estaEnCasa = estaEnCasa;
	}
	
	
	/**
	 * Desplaza al fantasma fuera del espacio de la casa
	 */
	public void abandonarCasa() {
		// Implementación
	}
	
	/**
	 * Cambia el modo de juego a asustado (si es posible) y actualiza los gráficos
	 */
	public void asustar() {
		if (this.getModo() != ModoJuego.COMIDO) {
			this.setModo(ModoJuego.ASUSTADO);
			int[] esqRandom = super.getHelper().getRandomPosValida();
			this.esqAsignada.cambiar(esqRandom[0], esqRandom[1]);
		}
		// actualizar gráficos
	}
	
	/**
	 * Cambia el modo de juego a persecución (si es posible) y actualiza los gráficos
	 */
	public void normalizar() {
		if (this.getModo() != ModoJuego.COMIDO) {
			this.setModo(ModoJuego.DISPERSION);
		}
		// actualizar gráficos
	}

	/**
	 * Revisa el modo de juego actual del fantasma y realiza un movimiento hacia 
	 * el objetivo o hacia la esquina asignada según corresponda
	 */
	public void moverSegunModo() {
		Posicion posBuscaLlegar;
		
		// A MODO DE EJEMPLO
		if (this.getModo() == ModoJuego.ASUSTADO || this.getModo() == ModoJuego.DISPERSION) {
			posBuscaLlegar = this.esqAsignada;
		} else posBuscaLlegar = this.objetivo;
		
		// analizar hacia que direccion conviene moverse segun posBuscaLlegar
		Direccion dirConveniente = Direccion.UP;	// a modo de ejemplo
		super.intentarMov(dirConveniente);
	}
	
	
	/**
	 * Verifica el modo del fantasma y cambia su valor si es necesario
	 * @return Si el fantasma pudo ser comido. En caso falso, excepto 
	 * si ya fue comido anteriormente, PacMan perdería una vida
	 */
	public boolean intentarComer() {
		if (this.getModo() == ModoJuego.ASUSTADO) {
			// implementación
			return true;
		} else if (this.getModo() == ModoJuego.COMIDO){
			// do nothing
			return true;
		}
		
		return false;
	}
	
	/**
	 * Método que los fantasmas deben sobreescribir para actuar en consecuencia
	 * de un nuevo desplazamiento de PacMan, informado por la Partida
	 */
	public abstract void notificarPosPacman();
	
	/**
	 * Realiza un cambio de la posición donde el fantasma busca llegar.
	 * @param x el valor de la posible abscisa (eje X)
	 * @param y el valor de la posible ordenada (eje Y)
	 */
	protected void cambiarObjetivo(int x, int y) {
		this.esqAsignada.cambiar(x, y);
	}
	
	/**
	 * 
	 * @return La instancia cargada previamente de PacMan. Los fantasmas pueden conocer
	 * la posición y dirección del mismo a través de esta referencia.
	 */
	protected Pacman getPacman() {
		return this.pacman;
	}
}
