package projeto;


import Exceptions.InvalidDataException;

import java.util.ArrayList;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws InvalidDataException {
		//LIST
		ArrayList<Pessoa> list1 = new ArrayList<Pessoa>();
		//SCANNER
		Scanner keyboard=new Scanner(System.in);
		
		while(true) {	
			
			//MENU
			Cliente.viewMenu();
			String option = keyboard.nextLine();
			
			if (option.equalsIgnoreCase("S")) {
				System.out.println("\nTchau!");
				break;
			}
			else if (option.equalsIgnoreCase("C")) {
				Cliente.registerCustomer(keyboard, list1);
			}
			else if (option.equalsIgnoreCase("E")) {
				Cliente.deleteCustomer(list1, keyboard);
			}
			else{
				System.out.println("Tecla inválida, tente novamente");
			}
		}
		
		keyboard.close();
		
	}
}
