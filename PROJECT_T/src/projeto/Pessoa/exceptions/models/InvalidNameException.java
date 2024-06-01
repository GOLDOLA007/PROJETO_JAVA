package projeto.Pessoa.exceptions.models;

public class InvalidNameException extends Exception {

	public InvalidNameException(String message, String invalidName) {
		super(message + invalidName);
	}

}
