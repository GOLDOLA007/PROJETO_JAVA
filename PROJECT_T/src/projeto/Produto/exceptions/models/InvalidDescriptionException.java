package projeto.Produto.exceptions.models;

public class InvalidDescriptionException extends Exception {

	public InvalidDescriptionException(String message, String invalidDescription) {
		super(message + invalidDescription);
	}

}
