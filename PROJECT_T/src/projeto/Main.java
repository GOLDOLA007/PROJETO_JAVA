package projeto;


import java.util.ArrayList;


import java.util.Scanner;

import Exceptions.models.*;
//import projeto.Cliente.models.Cliente;
import projeto.Pessoa.models.Pessoa;
import projeto.Cliente.services.*;
import projeto.Pessoa.services.*;
import projeto.Pessoa.utils.menu.*;


public class Main {
	public static void main(String[] args) throws InvalidNameException, InvalidAgeException, InvalidCpfException, InvalidCodeException, InvalidEmailException {
		//LIST
		ArrayList<Pessoa> list1 = new ArrayList<Pessoa>();
		//SCANNER
		Scanner keyboard=new Scanner(System.in);
		
		while(true) {	
			
			//MENU
			Menu.viewMenu();
			String option = keyboard.nextLine();
			
			if (option.equals("1")) {
				
				Menu.viewClientMenu();
				String optionC = keyboard.nextLine();
				
				if (optionC.equalsIgnoreCase("S")) {
					System.out.println("\nTchau!");
					break;
				}
				else if (optionC.equalsIgnoreCase("C")) {
					boolean tf=false;
					do{
						try {
							ClienteService.registerCustomer(keyboard, list1);
							tf=false;
						}
						catch(InvalidNameException e) {
							System.out.println(e.getMessage());
							tf=true;
						}
						catch(InvalidAgeException e) {
							System.out.println(e.getMessage());
							tf=true;
						}
						catch(InvalidCpfException e) {
							System.out.println(e.getMessage());
							tf=true;
						}
						catch(InvalidEmailException e) {
							System.out.println(e.getMessage());
							tf=true;
						}
						catch(InvalidCodeException e) {
							System.out.println(e.getMessage());
							tf=true;
						}
					}
					while(tf==true);
					
				}
				else if (optionC.equalsIgnoreCase("E")) {
					ClienteService.deleteCustomer(list1, keyboard);
				}
				else if (optionC.equalsIgnoreCase("M")) {
					PessoaService.viewRecords(list1);
				}
				else{
					System.out.println("Tecla inválida, tente novamente");
				}
			}
			keyboard.close();
			
		}
	}
}
