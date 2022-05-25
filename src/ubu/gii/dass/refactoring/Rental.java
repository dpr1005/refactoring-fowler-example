package ubu.gii.dass.refactoring;
/**
 * Tema Refactorizaciones
 * 
 * Ejemplo de aplicación de refactorizaciones. Actualizado para colecciones
 * genéricas de java 1.5.
 * 
 * @author M. Fowler y <A HREF="mailto:clopezno@ubu.es">Carlos López</A>
 * @version 1.1
 * @see java.io.File
 * 
 */
public class Rental {
	private final Movie _movie;
	private final int _daysRented;

	public Rental(Movie movie, int daysRented) {
		_movie = movie;
		_daysRented = daysRented;
	}

	public int getDaysRented() {
		return _daysRented;
	}

	public Movie getMovie() {
		return _movie;
	}

	public double getAmount() {
		double thisAmount = 0;
		switch (getMovie().getPriceCode()) {
			case MovieType.REGULAR:
				thisAmount += 2;
				if (getDaysRented() > 2)
					thisAmount += (getDaysRented() - 2) * 1.5;
				break;
			case MovieType.NEW_RELEASE:
				thisAmount += getDaysRented() * 3;
				break;
			case MovieType.CHILDRENS:
				thisAmount += 1.5;
				if (getDaysRented() > 3)
					thisAmount += (getDaysRented() - 3) * 1.5;
				break;
		}
		return thisAmount;
	}

	public int getFrequentRenterPoints() {
		// add frequent renter points
		int frequentRenterPoints = 1;
		// add bonus for a two-day new release rental
		if ((getMovie().getPriceCode() == MovieType.NEW_RELEASE) && getDaysRented() > 1)
			frequentRenterPoints++;
		return frequentRenterPoints;
	}

}
