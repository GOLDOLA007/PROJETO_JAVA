package projeto;

import java.io.OptionalDataException;
import java.util.Scanner;

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
	public static Cliente registerCustomer() {
		//SCANNER
		Scanner keyboard =new Scanner(System.in);
		
		//REGISTER
		System.out.println("==============CADASTRO==============");
		System.out.println("Nome: ");
		String name = keyboard.nextLine();
		System.out.println("CPF: ");
		String cpf = keyboard.nextLine();
		System.out.println("Idade: ");
		int age = keyboard.nextInt();
		System.out.println("Código: ");
		int cod = keyboard.nextInt();
		keyboard.nextLine(); //Read a empty String
		System.out.println("Email: ");
		String email = keyboard.nextLine();
		
		//NEW CUSTOMER
		Cliente novoCliente=new Cliente(name, cpf, age, cod, email);
		return novoCliente;
	}
	
	//DELETE CUSTOMER
	
	
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
