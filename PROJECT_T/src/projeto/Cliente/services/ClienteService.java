package projeto.Cliente.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import projeto.Cliente.exceptions.models.InvalidCodeException;
import projeto.Cliente.exceptions.models.InvalidEmailException;
import projeto.Cliente.models.Cliente;
import projeto.Funcionario.models.Funcionario;
import projeto.Pessoa.exceptions.models.InvalidAgeException;
import projeto.Pessoa.exceptions.models.InvalidCpfException;
import projeto.Pessoa.exceptions.models.InvalidNameException;
import projeto.Pessoa.models.Pessoa;
import projeto.Pessoa.utils.validator.ValidatorPessoa;
import projeto.Pessoa.services.*;

public class ClienteService extends Cliente {
	// REGISTER COSTUMER
	public static void registerCustomer(Scanner keyboard, ArrayList<Pessoa> list1) throws InvalidNameException,
			InvalidAgeException, InvalidCpfException, InvalidEmailException, InvalidCodeException {
		PessoaService.registerPerson(keyboard);

		// CODE
		System.out.println("Código: ");
		int codNewCustomer = keyboard.nextInt();
		keyboard.nextLine(); // Consume new line
		ValidatorPessoa.validateCod(list1, codNewCustomer);

		// EMAIL
		System.out.println("Email: ");
		String email = keyboard.nextLine();
		ValidatorPessoa.validateEmail(email);

		// NEW CUSTOMER
		Cliente newCostumer = new Cliente(PessoaService.getNameNewPerson(), PessoaService.getCpfNewPerson(),
				PessoaService.getAgeNewPerson(), codNewCustomer, email);

		// ADD
		list1.add(newCostumer);
		System.out.println("\nCliente cadastrado com sucesso!");
	}

	// DELETE CUSTOMER (MENU)
	public static void deleteCustomer(ArrayList<Pessoa> list1, Scanner keyboard) {
		PessoaService.viewRecords(list1);

		System.out.println("\nCódigo do cliente que deseja excluir: ");
		int codRemoveCustomer = keyboard.nextInt();

		findDeleteCustomer(list1, codRemoveCustomer);
		keyboard.nextLine();
	}

	// FIND COSTUMER (DELETE COSTUMER)
	public static void findDeleteCustomer(ArrayList<Pessoa> list1, int codRemoveCustomer) {
		Iterator<Pessoa> iterator = list1.iterator();

		while (iterator.hasNext()) { // Determine whether the iteration has more elements.
			Pessoa p = iterator.next(); // Get the next element (if hasNext equals true).

			if (p instanceof Cliente) {
				Cliente c = (Cliente) p;

				if (((Integer) c.getCodCliente()).equals(codRemoveCustomer)) {
					iterator.remove();
					System.out.println("Cliente removido com sucesso!\n");
					break;
				}
			}
		}
	}

	// REGISTER CUSTOMER WITH RETRY
	public static void registerCustomerWithRetry(Scanner keyboard, ArrayList<Pessoa> list1) {
		boolean tf = false;
		do {
			try {
				registerCustomer(keyboard, list1);
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
			} catch (InvalidEmailException e) {
				System.out.println(e.getMessage());
				tf = true;
			} catch (InvalidCodeException e) {
				System.out.println(e.getMessage());
				tf = true;
			}
		} while (tf == true);
	}

	// VIEW ALL CUSTOMERS
	public static void viewRecords(ArrayList<Pessoa> list1) {
		for (Pessoa p : list1) {
			if (p instanceof Cliente) {
				System.out.println(p);
			}
		}
	}
}
