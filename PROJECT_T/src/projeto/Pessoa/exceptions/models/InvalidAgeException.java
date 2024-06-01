package projeto.Pessoa.exceptions.models;

public class InvalidAgeException extends Exception {

	public InvalidAgeException(String message, Integer invalidAge) {
		super(message + invalidAge);
	}

}
