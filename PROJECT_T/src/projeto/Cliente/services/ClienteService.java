package projeto.Cliente.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import Exceptions.models.InvalidAgeException;
import Exceptions.models.InvalidCodeException;
import Exceptions.models.InvalidCpfException;
import Exceptions.models.InvalidEmailException;
import Exceptions.models.InvalidNameException;
import projeto.Cliente.models.Cliente;
import projeto.Pessoa.models.Pessoa;
import projeto.Pessoa.utils.validator.Validator;
import projeto.Pessoa.services.*;

public class ClienteService{
	//REGISTER COSTUMER
		public static void registerCustomer(Scanner keyboard, ArrayList<Pessoa> list1) throws InvalidNameException, InvalidAgeException, InvalidCpfException, InvalidEmailException, InvalidCodeException {
			PessoaService.registerPerson(keyboard);

			//CODE
			System.out.println("Código: ");
			int codNewCustomer = keyboard.nextInt();
			keyboard.nextLine(); //Consume new line
			Validator.validateCod(list1, codNewCustomer);
			
			//EMAIL
			System.out.println("Email: ");
			String email = keyboard.nextLine();
			Validator.validateEmail(email);
			
			//NEW CUSTOMER
			Cliente newCostumer=new Cliente(PessoaService.getNameNewPerson(), PessoaService.getCpfNewPerson(), PessoaService.getAgeNewPerson(), codNewCustomer, email);
			
			//ADD
			list1.add(newCostumer);
		}

		//DELETE CUSTOMER (MENU)
		public static void deleteCustomer(ArrayList<Pessoa> list1, Scanner keyboard) {
			PessoaService.viewRecords(list1);

			System.out.println("\nCódigo do cliente que deseja excluir: ");
			int codRemoveCustomer=keyboard.nextInt();

			findDeleteCustomer(list1, codRemoveCustomer);
			keyboard.nextLine();
		}
		//FIND COSTUMER (DELETE COSTUMER)
		public static void findDeleteCustomer(ArrayList<Pessoa> list1, int codRemoveCustomer) {
			Iterator<Pessoa> iterator = list1.iterator();

			while(iterator.hasNext()) {
				Pessoa p = iterator.next();

				if (p instanceof Cliente) {
					Cliente c = (Cliente)p;

					if (c.getCodCliente() == codRemoveCustomer) {
						iterator.remove();
						System.out.println("Cliente removido com sucesso!\n");
						break;
					}
				}
			}
		}
}
