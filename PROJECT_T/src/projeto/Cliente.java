package projeto;

import java.io.OptionalDataException;

import java.util.Scanner;

import java.util.ArrayList;

import java.util.Iterator;

public class Cliente extends Pessoa implements IPessoa{
	private String cpf, email;
	private int cod;
	
	public Cliente() {
	
	}
	public Cliente(String name, String cpf, int age, int cod, String email) {
		setName(name);
		setAge(age);
		this.cpf = cpf;
		this.cod = cod;
		this.email = email;
	}
	
	//CPF
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf=cpf;
	}
	
	//EMAIL
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email=email;
	}
	
	//COD
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod=cod;
	}
	
	//MENU
	public static void viewMenu() {
		System.out.println("\nDigite:");
		System.out.println("C para Cadastrar");
		System.out.println("E para excluir");
		System.out.println("S para sair");
	}
	
	//REGISTER COSTUMER
	public static Cliente registerCustomer(Scanner keyboard) {
		
		//REGISTER
		System.out.println("==============CADASTRO==============");
		//NAME
		System.out.println("Nome: ");
		String name = keyboard.nextLine();
		
		//CPF
		System.out.println("CPF: ");
		String cpf = keyboard.nextLine();
		
		//AGE
		System.out.println("Idade: ");
		int age = keyboard.nextInt();
		
		//CODE
		System.out.println("Código: ");
		int cod = keyboard.nextInt();
		keyboard.nextLine(); //Consume new line
		
		//EMAIL
		System.out.println("Email: ");
		String email = keyboard.nextLine();
		
		//NEW CUSTOMER
		Cliente novoCliente=new Cliente(name, cpf, age, cod, email);
		return novoCliente;
	}
	
	//DELETE CUSTOMER (MENU)
	public static void deleteCustomer(ArrayList<Pessoa> list1, Scanner keyboard) {
		System.out.println("\nClientes: ");
		for (Pessoa p : list1) {
			System.out.println(p);
		}
		System.out.println("\n\nCódigo do cliente que deseja excluir: ");
		int cod=keyboard.nextInt();
		
		Cliente.findDeleteCustomer(list1, cod);
		keyboard.nextLine();
	}
	//FIND COSTUMER (DELETE COSTUMER)
	public static void findDeleteCustomer(ArrayList<Pessoa> list1, int code) {
		Iterator<Pessoa> iterator = list1.iterator();
		
		while(iterator.hasNext()) {
			Pessoa p = iterator.next();
			
			if (p instanceof Cliente) {
				Cliente c = (Cliente)p;
				
				if (c.getCod() == code) {
					iterator.remove();
					System.out.println("Cliente removido com sucesso!");
					break;
				}
			}
		}
	}
	
	@Override
	public String toString() {
		return "==============DADOS-CLIENTE==============\n" +
				"Nome: " + getName() + "\n" +
				"CPF: " + cpf + "\n" +
				"Idade: " + getAge() + "\n" +
				"Código: " + cod + "\n" +
				"Email: " + email;
	}
	
	@Override
	public String viewData() {
		return toString();
	}
}
