package projeto.Cliente.exceptions.models;

public class InvalidEmailException extends Exception {

	public InvalidEmailException(String message, String invalidEmail) {
		super(message + invalidEmail);
	}

}
