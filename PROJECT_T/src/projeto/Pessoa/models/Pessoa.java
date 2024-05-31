package projeto.Pessoa.models;

import Exceptions.models.*;

import projeto.Pessoa.utils.validator.*;

public abstract class Pessoa {
	private String name, cpf;
	private int age;
	
	//NAME
	public String getName() {
		return name;
	}
	public void setName(String name) throws  InvalidNameException{
		
		Validator.validateName(name);
		this.name=name;
	}
	
	//AGE
	public int getAge() {
		return age;
	}
	public void setAge(Integer age) throws InvalidAgeException{
		Validator.validateAge(age);
		this.age=age;
	}
	
	//CPF
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) throws InvalidCpfException{
		Validator.validateCPF(cpf);	
		this.cpf=cpf;
	}
	
}
