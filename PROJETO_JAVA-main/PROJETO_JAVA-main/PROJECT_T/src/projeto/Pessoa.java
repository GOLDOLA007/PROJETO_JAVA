package projeto;

import Exceptions.InvalidDataException;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Pessoa {
	private String name;
	private int age;
	protected static String nameNewPerson;
	protected static int ageNewPerson,cpfNewPerson;
	
	//NAME
	public String getName() {
		return name;
	}
	public void setName(String name) throws  InvalidDataException{
		if(name.trim().isEmpty()){
			throw new InvalidDataException("O nome não pode conter apenas espaços em branco.", name);
		}
		else if(name.trim().length() < 3){
			throw new InvalidDataException("O nome deve conter ao menos três letras.", name);
		}
		else{
			this.name = name;
		}
	}
	
	//AGE
	public int getAge() {
		return age;
	}
	public void setAge(int age) throws InvalidDataException{
		if(age < 0){
			throw new InvalidDataException("A idade não pode ser negativa", age);
		}
		else{
			this.age = age;
		}
	}
	
	//REGISTER PERSON (MENU)
	public static void registerPerson(Scanner keyboard){

		//REGISTER
		System.out.println("==============CADASTRO==============");
		//NAME
		System.out.println("Nome: ");
		nameNewPerson = keyboard.nextLine();

		//CPF
		System.out.println("CPF: ");
		cpfNewPerson = keyboard.nextInt();
		keyboard.nextLine();

		//AGE
		System.out.println("Idade: ");
		ageNewPerson = keyboard.nextInt();
	}

	//VIEW RECORDS
	public static void viewRecords(ArrayList<Pessoa> list1){
		for (Pessoa p : list1){
			System.out.println(p);
		}
	}
}
