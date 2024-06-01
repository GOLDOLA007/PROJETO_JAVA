package projeto.Produto.exceptions.models;

public class InvalidPriceException extends Exception {

	public InvalidPriceException(String message, Double invalidPrice) {
		super(message + invalidPrice);
	}

}
