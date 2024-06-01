package projeto.Pessoa.services;

import java.util.ArrayList;

import java.util.Scanner;

import projeto.Pessoa.exceptions.models.InvalidAgeException;
import projeto.Pessoa.exceptions.models.InvalidCpfException;
import projeto.Pessoa.exceptions.models.InvalidNameException;
import projeto.Pessoa.models.Pessoa;
import projeto.Pessoa.utils.validator.ValidatorPessoa;

public class PessoaService extends Pessoa {

	private static String nameNewPerson, cpfNewPerson;
	private static int ageNewPerson;

	// NAME NEW PERSON
	public static void setNameNewPerson(String newName) {
		nameNewPerson = newName;
	}

	public static String getNameNewPerson() {
		return nameNewPerson;
	}

	// CPF NEW PERSON
	public static void setCpfNewPerson(String newCpf) {
		cpfNewPerson = newCpf;
	}

	public static String getCpfNewPerson() {
		return cpfNewPerson;
	}

	// AGE NEW PERSON
	public static void setAgeNewPerson(int newAge) {
		ageNewPerson = newAge;
	}

	public static int getAgeNewPerson() {
		return ageNewPerson;
	}

	// REGISTER PERSON (MENU)
	public static void registerPerson(Scanner keyboard)
			throws InvalidNameException, InvalidAgeException, InvalidCpfException {

		// REGISTER
		System.out.println("==============CADASTRO==============");

		// NAME
		System.out.println("Nome: ");
		nameNewPerson = keyboard.nextLine();
		ValidatorPessoa.validateName(nameNewPerson);

		// CPF
		System.out.println("CPF: ");
		cpfNewPerson = keyboard.nextLine();
		ValidatorPessoa.validateCPF(cpfNewPerson);

		// AGE
		System.out.println("Idade: ");
		ageNewPerson = keyboard.nextInt();
		ValidatorPessoa.validateAge(ageNewPerson);
	}

	// VIEW RECORDS
	public static void viewRecords(ArrayList<Pessoa> list1) {
		for (Pessoa p : list1) {
			System.out.println(p);
		}
	}
}
