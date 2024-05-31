package projeto.Pessoa.utils.menu;

public class Menu {
	//MENU
		public static void viewMenu() {
			System.out.println("\n==================ADEGA-DO-PAPAI==================\n");
			
			System.out.println("Para Funcionário digite 0\n");
			System.out.println("Para Cliente digite 1");	
		}
	
		//CLIENT MENU
		public static void viewClientMenu() {
			System.out.println("\nBem-Vindo!");
			System.out.println("\nDigite:");
			System.out.println("C para Cadastrar.");
			System.out.println("E para excluir.");
			System.out.println("M para mostrar os cadastros.");
			System.out.println("S para sair.");
		}
}
