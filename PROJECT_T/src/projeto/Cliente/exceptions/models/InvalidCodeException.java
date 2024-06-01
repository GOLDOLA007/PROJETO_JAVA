package projeto.Cliente.exceptions.models;

public class InvalidCodeException extends Exception {

	public InvalidCodeException(String message, Integer invalidCod) {
		super(message + invalidCod);
	}

}
