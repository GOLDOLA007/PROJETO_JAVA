package projeto.Cliente.models;

import Exceptions.models.InvalidAgeException;
import Exceptions.models.InvalidCodeException;
import Exceptions.models.InvalidCpfException;
import Exceptions.models.InvalidEmailException;
import Exceptions.models.InvalidNameException;
import projeto.Pessoa.interfaces.IPessoa;
import projeto.Pessoa.models.Pessoa;

import projeto.Pessoa.utils.validator.*;

public class Cliente extends Pessoa implements IPessoa{
	private String email;
	private int codCliente;

	public Cliente() {

	}
	public Cliente(String name, String cpf, int age, int codCliente, String email) throws InvalidNameException, InvalidAgeException, InvalidCpfException{
		setName(name);
		setAge(age);
		setCpf(cpf);
		this.codCliente = codCliente;
		this.email = email;
	}

	//EMAIL
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) throws InvalidEmailException{
		Validator.validateEmail(email);
		this.email = email;
	}

	//COD
	public int getCodCliente() {
		return codCliente;
	}
	public void setCodCliente(int codCliente) throws InvalidCodeException{
		Validator.validateCod(null,codCliente);
		this.codCliente = codCliente;
	}
	
	@Override
	public String toString() {
		return "==============DADOS-CLIENTE==============\n" +
				"Nome: " + getName() + "\n" +
				"CPF: " + getCpf() + "\n" +
				"Idade: " + getAge() + "\n" +
				"Código: " + codCliente + "\n" +
				"Email: " + email + "\n";
	}

	@Override
	public String viewData() {
		return toString();
	}
}
