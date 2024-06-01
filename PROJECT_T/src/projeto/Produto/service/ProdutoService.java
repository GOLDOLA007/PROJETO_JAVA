package projeto.Produto.service;

import projeto.Cliente.exceptions.models.InvalidCodeException;
import projeto.Cliente.exceptions.models.InvalidEmailException;
import projeto.Pessoa.exceptions.models.InvalidAgeException;
import projeto.Pessoa.exceptions.models.InvalidCpfException;
import projeto.Pessoa.exceptions.models.InvalidNameException;
import projeto.Produto.exceptions.models.InvalidDescriptionException;
import projeto.Produto.exceptions.models.InvalidIdException;
import projeto.Produto.exceptions.models.InvalidPriceException;
import projeto.Produto.models.Produto;
import projeto.Produto.utils.validator.ValidatorProduto;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

public class ProdutoService extends Produto {

	// REGISTER PRODUCT
	public static void registerProduct(Scanner keyboard, ArrayList<Produto> list1)
			throws InvalidPriceException, InvalidDescriptionException, InvalidIdException {
		// REGISTER
		System.out.println("==============CADASTRO-DE-PRODUTOS==============");

		// CATEGORY
		System.out.println("Categoria: ");
		String categoryNewProduct = keyboard.nextLine();
		ValidatorProduto.validateDescription(categoryNewProduct);

		// TYPE
		System.out.println("Tipo: ");
		String typeNewProduct = keyboard.nextLine();
		ValidatorProduto.validateDescription(typeNewProduct);

		// ID
		System.out.println("ID: ");
		int idNewProduct = keyboard.nextInt();
		keyboard.nextLine();
		ValidatorProduto.validateId(list1, idNewProduct);

		// DESCRIPTION
		System.out.println("Descrição: ");
		String descriptionNewProduct = keyboard.nextLine();
		ValidatorProduto.validateDescription(descriptionNewProduct);

		// PRICE
		System.out.println("Price: ");
		double priceNewProduct = keyboard.nextDouble();
		ValidatorProduto.validatePrice(priceNewProduct);

		// NEW PRODUCT
		Produto newProduct = new Produto(categoryNewProduct, typeNewProduct, descriptionNewProduct, idNewProduct,
				priceNewProduct);
		list1.add(newProduct);
	}

	// REGISTER PRODUCT WITH RETRY
	public static void registerProductWithRetry(ArrayList<Produto> list1, Scanner keyboard)
			throws InvalidIdException, InvalidPriceException, InvalidDescriptionException {
		boolean tf = false;
		do {
			try {
				registerProduct(keyboard, list1);
				tf = false;
			} catch (InvalidIdException e) {
				System.out.println(e.getMessage());
				tf = true;
			} catch (InvalidDescriptionException e) {
				System.out.println(e.getMessage());
				tf = true;
			} catch (InvalidPriceException e) {
				System.out.println(e.getMessage());
				tf = true;
			}
		} while (tf == true);
	}

	// SHOW ALL PRODUCTS
	public static void viewRecords(ArrayList<Produto> list1) {
		for (Produto p : list1) {
			System.out.println(p);
		}
	}

	// DELETE PRODUCT
	public static void deleteProduct(ArrayList<Produto> list1, Scanner keyboard) {
		viewRecords(list1);

		System.out.println("\nID do produto que deseja excluir: ");
		int idE = keyboard.nextInt();
		keyboard.nextLine();

		findDeleteProduct(list1, idE);
	}

	// FIND PRODUCT
	public static void findDeleteProduct(ArrayList<Produto> list1, int idE) {
		Iterator<Produto> iterator = list1.iterator();

		while (iterator.hasNext()) {
			Produto p = iterator.next();

			if (((Integer) p.getId()).equals(idE)) {
				iterator.remove();
				System.out.println("\nProduto removido com sucesso!");
				break;
			}
		}
	}
}
