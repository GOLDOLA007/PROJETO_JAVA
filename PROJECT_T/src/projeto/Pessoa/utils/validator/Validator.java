package projeto.Pessoa.utils.validator;

import java.util.ArrayList;
import java.util.Iterator;

import Exceptions.models.*;
import projeto.Cliente.models.Cliente;
import projeto.Pessoa.models.Pessoa;

public class Validator {
	//VALIDATE NAME
		public static void validateName(String VName) throws InvalidNameException{
			if (VName.trim().isEmpty()) {
				throw new InvalidNameException("O nome não deve ser vazio! -> Nome digitado: ", VName);
			}
			else if(VName.trim().length() < 3){
				throw new InvalidNameException("O nome deve conter ao menos 3 letras! -> Nome digitado: ", VName);
			}
		}
	
	//VALIDATE EMAIL
		public static void validateEmail(String email) throws InvalidEmailException{
			if (!(email.endsWith("@gmail.com") || (email.endsWith("@outlook.com")))) {
				throw new InvalidEmailException("Não foi possível identificar o domínio do e-mail: ", email);
			}
		}
	
		//VALIDATE AGE
		public static void validateAge(Integer VAge) throws InvalidAgeException{
			if (VAge == null) {
				throw new InvalidAgeException("A idade não pode ser vazia! -> Idade digitada: ", VAge);
		
			}
			else if (VAge <0) {
				throw new InvalidAgeException("A idade deve ser maior que 0! -> Idade digitada: ", VAge);
			}
		}
		
		//VALIDATE CPF
		public static void validateCPF(String VCpf) throws InvalidCpfException{
			if (VCpf.trim().isEmpty()) {
				throw new InvalidCpfException("O CPF não pode ser vazio! -> CPF digitado: ", VCpf);
			}
			else if ((VCpf.replaceAll("\\D", "")).length() != 11) {
				throw new InvalidCpfException("O CPF deve conter 11 digítos numéricos! -> CPF digitado: ", VCpf);
			}
		}
		
		//VALIDATE CODE
		public static void validateCod(ArrayList <Pessoa> list1 ,Integer cod) throws InvalidCodeException{
			if (cod == null) {
				throw new InvalidCodeException("O código não pode ser nulo! -> Código digitado: ", cod);
			}
			if (list1 != null) {
				findExistentCod(list1, cod);
			}
		}
		//FIND EXISTENT CODE	
		public static void findExistentCod(ArrayList<Pessoa> list1, Integer FEcod) throws InvalidCodeException {
			Iterator<Pessoa> iterator = list1.iterator();
			
			while(iterator.hasNext()) {
				Pessoa p = iterator.next();

				if (p instanceof Cliente) {
					Cliente c = (Cliente)p;

					if (c.getCodCliente() == FEcod) {
						throw new InvalidCodeException("Esse código já está registrado, por favor, utilize outro código. -> Código digitado: ", FEcod);
					}
				}
			}
		}
}
