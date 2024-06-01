package projeto.Main;

import java.util.ArrayList;

import java.util.Scanner;

import projeto.Pessoa.exceptions.models.InvalidAgeException;
import projeto.Pessoa.exceptions.models.InvalidCpfException;
import projeto.Pessoa.exceptions.models.InvalidNameException;
//import projeto.Cliente.models.Cliente;
import projeto.Pessoa.models.Pessoa;
import projeto.Produto.service.ProdutoService;
import projeto.Produto.exceptions.models.InvalidDescriptionException;
import projeto.Produto.exceptions.models.InvalidIdException;
import projeto.Produto.exceptions.models.InvalidPriceException;
import projeto.Produto.models.Produto;
import projeto.Cliente.exceptions.models.InvalidCodeException;
import projeto.Cliente.exceptions.models.InvalidEmailException;
import projeto.Cliente.services.*;
import projeto.Funcionario.services.FuncionarioService;
import projeto.Menu.models.Menu;

public class Main {
	public static void main(String[] args)
			throws InvalidNameException, InvalidAgeException, InvalidCpfException, InvalidCodeException,
			InvalidEmailException, InvalidPriceException, InvalidDescriptionException, InvalidIdException {
		// LIST
		ArrayList<Pessoa> listPerson = new ArrayList<Pessoa>();
		ArrayList<Produto> listProduct = new ArrayList<Produto>();
		// SCANNER
		Scanner keyboard = new Scanner(System.in);

		while (true) {

			// MENU
			Menu.viewMenu();
			String option = keyboard.nextLine();

			if (option.equalsIgnoreCase("S")) {
				System.out.println("Tchau!");
				break;
			}

			if (option.equals("1")) {

				Menu.viewClientMenu();
				String optionC = keyboard.nextLine();

				if (optionC.equalsIgnoreCase("V")) {

				} else if (optionC.equalsIgnoreCase("C")) {
					ClienteService.registerCustomerWithRetry(keyboard, listPerson);
				} else if (optionC.equalsIgnoreCase("E")) {
					ClienteService.deleteCustomer(listPerson, keyboard);
				} else if (optionC.equalsIgnoreCase("M")) {
					ClienteService.viewRecords(listPerson);
				} else {
					System.out.println("Tecla inválida, tente novamente.");
				}
			}

			else if (option.equals("0")) {

				Menu.viewEmployeeMenu();
				String optionE = keyboard.nextLine();

				if (optionE.equalsIgnoreCase("V")) {

				} else if (optionE.equalsIgnoreCase("C")) {
					FuncionarioService.registerEmployeeWithRetry(keyboard, listPerson);
				} else if (optionE.equalsIgnoreCase("E")) {
					FuncionarioService.deleteEmployee(listPerson, keyboard);
				} else if (optionE.equalsIgnoreCase("M")) {
					FuncionarioService.viewRecords(listPerson);
				} else {
					System.out.println("Tecla inválida, tente novamente.");
				}

			} else if (option.equals("-1")) {
				Menu.viewProductMenu();
				String optionP = keyboard.nextLine();

				if (optionP.equalsIgnoreCase("V")) {

				} else if (optionP.equalsIgnoreCase("C")) {
					ProdutoService.registerProductWithRetry(listProduct, keyboard);
				} else if (optionP.equalsIgnoreCase("E")) {
					ProdutoService.deleteProduct(listProduct, keyboard);
				} else if (optionP.equalsIgnoreCase("M")) {
					ProdutoService.viewRecords(listProduct);
				} else {
					System.out.println("Tecla inválida, tente novamente.");
				}
			}
		}
		keyboard.close();
	}
}
