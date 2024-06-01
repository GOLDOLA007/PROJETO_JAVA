package projeto.Pessoa.exceptions.models;

public class InvalidCpfException extends Exception {

	public InvalidCpfException(String message, String invalidCpf) {
		super(message + invalidCpf);
	}
}
