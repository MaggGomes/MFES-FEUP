package FrutaFeia.model;

import java.util.Scanner;

public class launcher {
	private static final String title = "        <<  Fruta Feia  >>";
	private static boolean done = false;
	private static FrutaFeia frutaFeia;

	/**
	 * Displays the Admin Menu
	 */
	public static void displayAdminMenu(){
		System.out.println("\n		<< Menu Admin >>\n");
		System.out.println("		>> 1 - Gerir Clientes");
		System.out.println("		>> 2 - Gerir Agricultores");
		System.out.println("		>> 3 - Gerir Centros");
		System.out.println("		>> 4 - Voltar");
		System.out.println("		>> 5 - Sair");
		System.out.println();
	}

	/**
	 * Displays the Client menu
	 */
	public static void displayClientMenu(){
		System.out.println("\n		<< Menu Cliente >>\n");
		System.out.println("		>> 1 - Fazer encomenda");
		System.out.println("		>> 2 - Alterar cesta");
		System.out.println("		>> 3 - Levantar cesta");
		System.out.println("		>> 4 - Voltar");
		System.out.println("		>> 5 - Sair");
		System.out.println();
	}

	/**
	 * Displays the Agricultor menu
	 */
	public static void displayAgricultorMenu(){
		System.out.println("\n		<< Menu Agricultor >>\n");
		System.out.println("		>> 1 - Ver produtos ");
		System.out.println("		>> 2 - Adicionar produto");
		System.out.println("		>> 3 - Remover produto");
		System.out.println("		>> 4 - Sair");
		System.out.println();

		Scanner scan = new Scanner(System.in);
		int input = 0;

		while (!done){
			input = getUserInput(scan, 1, 4);
			switch(input){
				case 1:
					displayAdminMenu();
					break;
				case 2:
					displayClientMenu();
					break;
				case 3:
					displayAgricultorMenu();
					break;
				case 4:
					done = true;
					break;
			}
		}
	}

	/**
	 * Displays the Main Menu
	 */
	public static void displayMainMenu(){
		System.out.println("\n		<< Menu Inicial >>\n");
		System.out.println("		>> 1 - Menu Admin");
		System.out.println("		>> 2 - Menu Cliente ");
		System.out.println("		>> 3 - Menu Agricultor");
		System.out.println("		>> 4 - Sair");
		System.out.println();
	}

	/**
	 * Reads the user input
	 *
	 * @param scan to be used to get input from user
	 * @param min value
	 * @param max value
	 * @return user input
	 */
	public static int getUserInput(Scanner scan, int min, int max){
		int input = 0;

		do {
			try{
				input = scan.nextInt();
				if (input < min || input > max)
					throw new IllegalArgumentException();
			}

			catch(Exception e) {
				scan.nextLine();
				System.err.println("\nERROR:: Opção inválida! Por favor tente novamente!\n");
			}
		} while (input < min || input > max);

		scan.nextLine();

		return input;
	}

	public static void initializeFrutaFeia(){
		// Fruta Feia
		frutaFeia = new FrutaFeia();

		// Centros de Distribuição
		CentroDistribuicao centro1 = new CentroDistribuicao("Porto");
		CentroDistribuicao centro2 = new CentroDistribuicao("Braga");
		CentroDistribuicao centro3 = new CentroDistribuicao("Lisboa");

		frutaFeia.adicionaCentro(centro1);
		frutaFeia.adicionaCentro(centro2);
		frutaFeia.adicionaCentro(centro3);

		// Agricultores

		Agricultor agricultor1 = new Agricultor("João", "Mirandela");
		Agricultor agricultor2 = new Agricultor("Rodrigo", "Aveiro");
		Agricultor agricultor3 = new Agricultor("Eva", "Évora");

		frutaFeia.adicionaAgricultor(agricultor1);
		frutaFeia.adicionaAgricultor(agricultor2);
		frutaFeia.adicionaAgricultor(agricultor3);

		// Produtos
		Produto produto1 = new Produto("Maca", "Golden", 10);
		Produto produto2 = new Produto("Pera", "Rocha", 10);
		Produto produto3 = new Produto("Batata", "Nacional", 10);
		Produto produto4 = new Produto("Couve", "Nacional", 10);
		Produto produto5 = new Produto("Bróculo", "Nacional", 10);
		Produto produto6 = new Produto("Nabo", "Nacional", 10);
		Produto produto7 = new Produto("Laranga", "Nacional", 10);
		Produto produto8 = new Produto("Espinafre", "Nacionl", 10);

		// Clientes
		Cliente cliente1 = new Cliente("António", "Porto");
		Cliente cliente2 = new Cliente("Álvaro", "Porto");
		Cliente cliente3 = new Cliente("André", "Braga");

	}

	public static void main (String[] args) {

		initializeFrutaFeia();

		Scanner scan = new Scanner(System.in);
		int input = 0;
		System.out.println(title);

		displayMainMenu();

		while (!done){
			input = getUserInput(scan, 1, 4);
			switch(input){
				case 1:
					displayAdminMenu();
					break;
				case 2:
					done = true;
					displayClientMenu();
					break;
				case 3:
					displayAgricultorMenu();
					break;
				case 4:
					done = true;
					break;
			}
		}

		System.out.println("A sair de Fruta Feia..");
		scan.close();
	}
}
