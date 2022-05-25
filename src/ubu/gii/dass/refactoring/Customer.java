package ubu.gii.dass.refactoring;
import java.util.*;


/**
 * Tema  Refactorizaciones
 *
 * Ejemplo de aplicaci�n de refactorizaciones. Actualizado para colecciones gen�ricas de java 1.5
 *
 * @author M. Fowler y <A HREF="mailto:clopezno@ubu.es">Carlos L�pez</A>
 * @version 1.1
 * @see java.io.File
 *
 *
 */
public class Customer {
	private final String _name;
	private final List<Rental> _rentals;

	public Customer(String name) {
		_name = name;
		_rentals = new ArrayList<>();

	}

	public void addRental(Rental arg) {
		_rentals.add(arg);
	}

	public String getName() {
		return _name;
	}

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Iterator<Rental> rentals = _rentals.iterator();
		StringBuilder result = new StringBuilder("Rental Record for " + getName() + "\n");
		while (rentals.hasNext()) {
			Rental each = rentals.next();
			// determine amounts for each line
			double thisAmount = each.getAmount();

			frequentRenterPoints += each.getFrequentRenterPoints();
			// show figures for this rental
			result.append("\t").append(each.getMovie().getTitle()).append("\t").append(thisAmount).append("\n");
			totalAmount += thisAmount;
		}
		// add footer lines
		result.append("Amount owed is ").append(totalAmount).append("\n");
		result.append("You earned ").append(frequentRenterPoints).append(" frequent renter points");

		return result.toString();
	}

}
