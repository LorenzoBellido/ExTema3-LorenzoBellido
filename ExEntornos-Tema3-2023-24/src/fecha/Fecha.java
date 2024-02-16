package fecha;
/**
 * Clase Fecha en la que realizaremos una serie de métodos para mostrar la fecha
 * @author Lorenzo Bellido
 * @version 1.0
 */
public class Fecha {
	
	/**
	 * Atributo para el día
	 */
	private int d; //d�a
	/**
	 * Atributo para el mes
	 */
	private int m; //mes
	/**
	 * Atributo para el anho
	 */
	private int a; //a�o

	/** 
	 * Constructor sin parámetros
	 */
	public Fecha() {

	}

	/**
	 * Constructor con parámetros 
	 * @param dia Atributo del dia
	 * @param mes Atributo del mes
	 * @param anio Atributo del anho
	 */
	public Fecha(int dia, int mes, int anio) {
		this.d = dia;
		this.m = mes;
		this.a = anio;
	}

	
	/**
	 * Método sin parámetros de entrada que devuelve un booleano según si el anho es bisiesto
	 * @return Verdadero si la fecha esta bien escrita
	 */
	public boolean fechaCorrecta() {
		boolean diaCorrecto, mesCorrecto, anioCorrecto;
		anioCorrecto = a > 0;
		mesCorrecto = m >= 1 && m <= 12;
		switch (m) {
		case 2:
			if (esBisiesto()) {
				diaCorrecto = d >= 1 && d <= 29;
			} else {
				diaCorrecto = d >= 1 && d <= 28;
			}
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			diaCorrecto = d >= 1 && d <= 30;
			break;
		default:
			diaCorrecto = d >= 1 && d <= 31;
		}
		return diaCorrecto && mesCorrecto && anioCorrecto;
	}

	// M�todo esBisiesto. Solo lo usa fechaCorrecta, por eso es privado
	/**
	 * Método sin parámetros de entrada que devuelve un booleano según si el año es bisiesto
	 * @return Si el año es bisiesto devuelve true
	 */
	private boolean esBisiesto() {
		boolean esBisiesto = (a % 4 == 0 && a % 100 != 0 || a % 400 == 0);
		return esBisiesto;
	}

	// M�todo diaSiguiente
	/**
	 * Método que no recibe ni devuelve nada y solo pasa de dia en la fecha
	 */
	public void diaSiguiente() {
		d++;
		if (!fechaCorrecta()) {
			d = 1;
			m++;
			if (!fechaCorrecta()) {
				m = 1;
				a++;
			}
		}
	}

	// M�todo toString
	/**
	 * Método que no recibe ni devuelve nada y convierte la fecha en String
	 */
	public String toString() {
		if (d < 10 && m < 10) {
			return "0" + d + "-0" + m + "-" + a;
		} else if (d < 10 && m >= 10) {
			return "0" + d + "-" + m + "-" + a;
		} else if (d >= 10 && m < 10) {
			return d + "-0" + m + "-" + a;
		} else {
			return d + "-" + m + "-" + a;
		}
	}

}
