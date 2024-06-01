package projeto.Pessoa.models;

import projeto.Pessoa.exceptions.models.InvalidAgeException;
import projeto.Pessoa.exceptions.models.InvalidCpfException;
import projeto.Pessoa.exceptions.models.InvalidNameException;
import projeto.Pessoa.utils.validator.*;

public abstract class Pessoa {
	private String name, cpf;
	private int age;

	// NAME
	public String getName() {
		return name;
	}

	public void setName(String name) throws InvalidNameException {

		ValidatorPessoa.validateName(name);
		this.name = name;
	}

	// AGE
	public int getAge() {
		return age;
	}

	public void setAge(Integer age) throws InvalidAgeException {
		ValidatorPessoa.validateAge(age);
		this.age = age;
	}

	// CPF
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) throws InvalidCpfException {
		ValidatorPessoa.validateCPF(cpf);
		this.cpf = cpf;
	}

}
