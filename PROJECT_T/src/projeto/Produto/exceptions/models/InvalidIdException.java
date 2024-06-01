package projeto.Produto.exceptions.models;

public class InvalidIdException extends Exception {

	public InvalidIdException(String message, Integer invalidId) {
		super(message + invalidId);
	}

}
