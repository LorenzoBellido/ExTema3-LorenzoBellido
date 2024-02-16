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
	private int dia; //d�a
	/**
	 * Atributo para el mes
	 */
	private int mes; //mes
	/**
	 * Atributo para el anho
	 */
	private int anio; //a�o

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
		this.dia = dia;
		this.mes = mes;
		this.anio = anio;
	}

	
	/**
	 * Método sin parámetros de entrada que devuelve un booleano según si el anho es bisiesto
	 * @return Verdadero si la fecha esta bien escrita
	 */
	public boolean fechaCorrecta() {
		boolean diaCorrecto;
		boolean mesCorrecto;
		boolean anioCorrecto;
		anioCorrecto = anio > 0;
		mesCorrecto = mes >= 1 && mes <= 12;
		switch (mes) {
		case 2:
			if (esBisiesto()) {
				diaCorrecto = dia >= 1 && dia <= 29;
			} else {
				diaCorrecto = dia >= 1 && dia <= 28;
			}
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			diaCorrecto = dia >= 1 && dia <= 30;
			break;
		default:
			diaCorrecto = dia >= 1 && dia <= 31;
		}
		return diaCorrecto && mesCorrecto && anioCorrecto;
	}

	// M�todo esBisiesto. Solo lo usa fechaCorrecta, por eso es privado
	/**
	 * Método sin parámetros de entrada que devuelve un booleano según si el año es bisiesto
	 * @return Si el año es bisiesto devuelve true
	 */
	private boolean esBisiesto() {
		return (anio % 4 == 0 && anio % 100 != 0 || anio % 400 == 0);
	}

	// M�todo diaSiguiente
	/**
	 * Método que no recibe ni devuelve nada y solo pasa de dia en la fecha
	 */
	public void diaSiguiente() {
		dia++;
		if (!fechaCorrecta()) {
			dia = 1;
			mes++;
			if (!fechaCorrecta()) {
				mes = 1;
				anio++;
			}
		}
	}

	// M�todo toString
	/**
	 * Método que no recibe ni devuelve nada y convierte la fecha en String
	 */
	public String toString() {
		String cad;
		if (dia < 10 && mes < 10) {
			cad = "0" + dia + "-0" + mes + "-" + anio;
		} else if (dia < 10 && mes >= 10) {
			cad = "0" + dia + "-" + mes + "-" + anio;
		} else if (dia >= 10 && mes < 10) {
			cad = dia + "-0" + mes + "-" + anio;
		} else {
			cad = dia + "-" + mes + "-" + anio;
		}
		return cad;
		
	}

}
