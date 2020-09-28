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
	private ModoJuego modo;
	private Posicion objetivo, esqAsignada;
	private String nombre;
	private int color;
	private boolean estaEnCasa;
	
	/**
	 * Constructor por defecto, sin parámetros
	 */
	public Fantasma() {
		// TODO Auto-generated constructor stub
		this(null);
	}

	/**
	 * Constructor que permite referenciar el tablero
	 * @param tablero la instancia del tablero utilizada por la partida y 
	 * el resto de personajes
	 */
	public Fantasma(Tablero tablero) {
		super(tablero);
		// TODO Auto-generated constructor stub
		super.setManejadoPorCPU(true);
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
	 * @return el valor del atributo objetivo
	 */
	public Posicion getObjetivo() {
		return objetivo;
	}

	/**
	 * @param objetivo el valor del atributo objetivo a asignar
	 */
	public void setObjetivo(Posicion objetivo) {
		this.objetivo = objetivo;
	}

	/**
	 * @return el valor del atributo esqAsignada
	 */
	public Posicion getEsqAsignada() {
		return esqAsignada;
	}

	/**
	 * @param esqAsignada el valor del atributo esqAsignada a asignar
	 */
	public void setEsqAsignada(Posicion esqAsignada) {
		this.esqAsignada = esqAsignada;
	}

	/**
	 * @return el valor del atributo nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre el valor del atributo nombre a asignar
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
		if (this.getModo() != ModoJuego.COMIDO)
			this.setModo(ModoJuego.ASUSTADO);
		// actualizar gráficos
	}
	
	/**
	 * Cambia el modo de juego a persecución (si es posible) y actualiza los gráficos
	 */
	public void normalizar() {
		if (this.getModo() != ModoJuego.COMIDO)
			this.setModo(ModoJuego.PERSECUCION);
		// actualizar gráficos
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
	 * Realiza un cambio de la posición donde el fantasma busca llegar. 
	 * En caso de no ser válida, puede hacer uso del Helper repetidamente.
	 * @param x el valor de la posible abscisa (eje X)
	 * @param y el valor de la posible ordenada (eje Y)
	 */
	public void cambiarObjetivo(int x, int y) {
		// Implementación
	}
	
}
