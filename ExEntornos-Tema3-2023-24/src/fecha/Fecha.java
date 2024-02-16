package fecha;

public class Fecha {
	public static final int DIEZ = 10;
	private int d; //d�a
	private int m; //mes
	private int a; //a�o

	
	public Fecha() {

	}

	
	public Fecha(int dia, int mes, int anio) {
		this.d = dia;
		this.m = mes;
		this.a = anio;
	}

	
	
	public boolean fechaCorrecta() {
		boolean diaCorrecto, mesCorrecto, anioCorrecto;
		anioCorrecto = a > 0;
		mesCorrecto = m >= 1 && m <= 12;
		boolean diaMayor1 = d >= 1;
		switch (m) {
		case 2:
			if (esBisiesto()) {
				diaCorrecto = diaMayor1 && d <= 29;
			} else {
				diaCorrecto = diaMayor1 && d <= 28;
			}
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			diaCorrecto = diaMayor1 && d <= 30;
			break;
		default:
			diaCorrecto = diaMayor1 && d <= 31;
		}
		return diaCorrecto && mesCorrecto && anioCorrecto;
	}

	// M�todo esBisiesto. Solo lo usa fechaCorrecta, por eso es privado
	private boolean esBisiesto() {
		boolean esBisiesto = (a % 4 == 0 && a % 100 != 0 || a % 400 == 0);
		return esBisiesto;
	}

	// M�todo diaSiguiente
	public void nextDay() {
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
	public String toString() {
		if (d < DIEZ && m < DIEZ) {
			return "0" + d + "-0" + m + "-" + a;
		} else if (d < DIEZ && m >= DIEZ) {
			return "0" + d + "-" + m + "-" + a;
		} else if (d >= DIEZ && m < DIEZ) {
			return d + "-0" + m + "-" + a;
		} else {
			return d + "-" + m + "-" + a;
		}
	}

}
