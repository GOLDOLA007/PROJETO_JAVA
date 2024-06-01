package projeto.Produto.utils.validator;

import projeto.Produto.exceptions.models.InvalidDescriptionException;
import projeto.Produto.exceptions.models.InvalidIdException;
import projeto.Produto.exceptions.models.InvalidPriceException;
import projeto.Produto.models.Produto;

import java.util.ArrayList;
import java.util.Iterator;

public class ValidatorProduto extends Produto {

	// VALIDATE PRICE
	public static void validatePrice(Double invalidPrice) throws InvalidPriceException {
		if (invalidPrice == null) {
			throw new InvalidPriceException("O preço não pode ser nulo! -> Preço digitado: ", null);
		} else if (invalidPrice <= 0) {
			throw new InvalidPriceException("O preço deve ser maior que 0! -> Preço digitado: ", invalidPrice);
		}
	}

	// VALIDATE DESCRIPTION
	public static void validateDescription(String invalidDescription) throws InvalidDescriptionException {
		if (invalidDescription.trim().isEmpty()) {
			throw new InvalidDescriptionException("Esse campo não pode ser vazio! -> Conteúdo digitado: ",
					invalidDescription);
		}
	}

	// VALIDATE ID
	public static void validateId(ArrayList<Produto> list1, Integer invalidId) throws InvalidIdException {
		if (invalidId == null) {
			throw new InvalidIdException("O ID não pode ser nulo! -> ID digitado: ", invalidId);
		} else if (list1 != null) {
			findExistentId(list1, invalidId);
		}
	}

	// FIND EXISTENT ID
	public static void findExistentId(ArrayList<Produto> list1, Integer invalidId) throws InvalidIdException {
		Iterator<Produto> iterator = list1.iterator();

		while (iterator.hasNext()) {
			Produto p = iterator.next();

			if (((Integer) p.getId()).equals(invalidId)) {
				throw new InvalidIdException(
						"Esse ID já está registrado, por favor, utilize outro ID. -> ID digitado: ", invalidId);
			}
		}
	}
}
