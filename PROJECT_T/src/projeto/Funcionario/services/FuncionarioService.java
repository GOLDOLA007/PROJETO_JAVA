package projeto.Funcionario.services;

import projeto.Pessoa.services.*;
import projeto.Pessoa.utils.validator.*;
import projeto.Pessoa.exceptions.models.InvalidAgeException;
import projeto.Pessoa.exceptions.models.InvalidCpfException;
import projeto.Pessoa.exceptions.models.InvalidNameException;
import projeto.Pessoa.models.Pessoa;
import projeto.Cliente.exceptions.models.InvalidCodeException;
import projeto.Funcionario.models.Funcionario;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

public class FuncionarioService extends Funcionario {

	// REGISTER EMPLOYEE
	public static void registerEmployeer(Scanner keyboard, ArrayList<Pessoa> list1)
			throws InvalidNameException, InvalidAgeException, InvalidCpfException, InvalidCodeException {
		PessoaService.registerPerson(keyboard);

		// ID
		System.out.println("ID: ");
		int idNewEmployee = keyboard.nextInt();
		keyboard.nextLine();
		ValidatorPessoa.validateCod(list1, idNewEmployee);

		// NEW EMPLOYEE
		Funcionario newEmployee = new Funcionario(PessoaService.getNameNewPerson(), PessoaService.getCpfNewPerson(),
				PessoaService.getAgeNewPerson(), idNewEmployee);
		list1.add(newEmployee);

		System.out.println("Funcionário cadastrado com sucesso!");
	}

	// DELETE EMPLOYEE (MENU)
	public static void deleteEmployee(ArrayList<Pessoa> list1, Scanner keyboard) {

		System.out.println("\nID do funcionário que deseja excluir: ");
		int idEmployeeRemove = keyboard.nextInt();

		findDeleteEmployee(list1, idEmployeeRemove);
		keyboard.nextLine();
	}

	// FIND EMPLOYEE'S ID (DELETE)
	public static void findDeleteEmployee(ArrayList<Pessoa> list1, int idEmployeeRemove) {
		Iterator<Pessoa> iterator = list1.iterator();

		while (iterator.hasNext()) { // Determine whether the iteration has more elements.
			Pessoa p = iterator.next(); // Get the next element (if hasNext equals true).

			if (p instanceof Funcionario) {
				Funcionario f = (Funcionario) p;

				if (f.getIdEmployee() == idEmployeeRemove) {
					iterator.remove();
					System.out.println("\nFuncionário removido com sucesso!");
					break;
				}
			}
		}
	}

	// REGISTER EMPLOYEE WITH RETRY
	public static void registerEmployeeWithRetry(Scanner keyboard, ArrayList<Pessoa> list1) {
		boolean tf = false;
		do {
			try {
				registerEmployeer(keyboard, list1);
				tf = false;
			} catch (InvalidNameException e) {
				System.out.println(e.getMessage());
				tf = true;
			} catch (InvalidAgeException e) {
				System.out.println(e.getMessage());
				tf = true;
			} catch (InvalidCpfException e) {
				System.out.println(e.getMessage());
				tf = true;
			} catch (InvalidCodeException e) {
				System.out.println(e.getMessage());
				tf = true;
			}
		} while (tf == true);
	}

	// VIEW ALL EMPLOYEES
	public static void viewRecords(ArrayList<Pessoa> list1) {
		for (Pessoa p : list1) {
			if (p instanceof Funcionario) {
				System.out.println(p);
			}
		}
	}
}
