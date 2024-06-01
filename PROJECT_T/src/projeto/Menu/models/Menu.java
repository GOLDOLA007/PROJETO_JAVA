package projeto.Menu.models;

public class Menu {
	// MENU
	public static void viewMenu() {
		System.out.println("\n==================ADEGA-DO-PAPAI==================\n");

		System.out.println("Para Funcionário digite 0\n");
		System.out.println("Para Cliente digite 1\n");
		System.out.println("Para produto digite -1\n");
		System.out.println("S para sair");
	}

	// CLIENT MENU
	public static void viewClientMenu() {
		System.out.println("\n==================ÁREA-CLIENTE==================\n");
		System.out.println("Bem-Vindo!");
		System.out.println("\nDigite:");
		System.out.println("C para Cadastrar.");
		System.out.println("E para Excluir.");
		System.out.println("M para Mostrar os cadastros.");
		System.out.println("V para Voltar.");
	}

	// EMPLOYEE MENU
	public static void viewEmployeeMenu() {
		System.out.println("\n==================ÁREA-FUNCIONÁRIO==================\n");
		System.out.println("Bem-Vindo!");
		System.out.println("\nDigite: ");
		System.out.println("C para Cadastrar.");
		System.out.println("E para Excluir.");
		System.out.println("M para Mostrar os cadastros.");
		System.out.println("V para Voltar");
	}

	// PRODUCT MENU
	public static void viewProductMenu() {
		System.out.println("\n==================ÁREA-PRODUTO==================\n");
		System.out.println("Bem-Vindo!");
		System.out.println("\nDigite: ");
		System.out.println("C para Cadastrar.");
		System.out.println("E para Excluir.");
		System.out.println("M para Mostrar os cadastros.");
		System.out.println("V para Voltar.");
	}
}
