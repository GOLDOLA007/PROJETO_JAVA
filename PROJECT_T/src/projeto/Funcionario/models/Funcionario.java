package projeto.Funcionario.models;

import projeto.Pessoa.models.*;
import projeto.Pessoa.exceptions.models.InvalidAgeException;
import projeto.Pessoa.exceptions.models.InvalidCpfException;
import projeto.Pessoa.exceptions.models.InvalidNameException;
import projeto.Pessoa.interfaces.IPessoa;

public class Funcionario extends Pessoa implements IPessoa {

	private int idEmployee;

	public Funcionario() {

	}

	public Funcionario(String name, String cpf, int age, int id)
			throws InvalidNameException, InvalidCpfException, InvalidAgeException {
		setName(name);
		setCpf(cpf);
		setAge(age);
		this.idEmployee = id;
	}

	// ID EMPLOYEE
	public void setIdEmployee(int id) {
		this.idEmployee = id;
	}

	public int getIdEmployee() {
		return idEmployee;
	}

	@Override
	public String toString() {
		return "\n==============DADOS-FUNCIONÁRIO==============\n" + "Nome: " + getName() + "\n" + "CPF: " + getCpf()
				+ "\n" + "Idade: " + getAge() + "\n" + "ID: " + idEmployee;
	}

	@Override
	public String viewData() {
		return toString();
	}
}
