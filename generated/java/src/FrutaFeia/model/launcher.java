package FrutaFeia.model;

import java.util.Scanner;

public class launcher {
	private static final String title = "        <<  Fruta Feia  >>";
	private static boolean menuDone = false;
	private static FrutaFeia frutaFeia;
	private static Agricultor agricultorUser;
	private static Cliente clienteUser;

	public static void  viewClients(Scanner scan){
		System.out.println(frutaFeia.getTodosClientes());
		String input = scan.next();
		displayManageClientsMenu(scan);
	}

	public static void addClient(Scanner scan){
		Cliente cliente;

		System.out.println("Nome: ");
		String name = scan.next();
		System.out.println("Género(H/M): ");
		String genre = scan.next();
		System.out.println("Localização: ");
		String local = scan.next();

		if(genre.equals("H"))
			cliente = new Cliente(name, Quotes.HOMEMQuote.getInstance());
		else
			cliente = new Cliente(name, Quotes.MULHERQuote.getInstance());

		frutaFeia.adicionaCliente(cliente, local);

		System.out.println("Cliente "+name+" criado com sucesso!");

		String input = scan.next();
		displayManageClientsMenu(scan);
	}

	public static void  removeClient(Scanner scan){
		Cliente cliente;

		System.out.println("Nome: ");
		String name = scan.next();
		System.out.println("Centro associado: ");
		String centro = scan.next();

		frutaFeia.removeCliente(name, centro);

		System.out.println("Cliente "+name+" removido com sucesso!");

		String input = scan.next();
		displayManageClientsMenu(scan);
	}

	public static void  viewAgricultores(Scanner scan){
		System.out.println(frutaFeia.agricultores);
		String input = scan.next();
		displayManageAgricultoresMenu(scan);
	}

	public static void addAgricultor(Scanner scan){
		Agricultor agricultor;

		System.out.println("Nome: ");
		String name = scan.next();
		System.out.println("Localização: ");
		String local = scan.next();

		agricultor = new Agricultor(name, local);

		frutaFeia.adicionaAgricultor(agricultor);

		System.out.println("Agricultor "+name+" criado com sucesso!");

		String input = scan.next();
		displayManageAgricultoresMenu(scan);
	}

	public static void  removeAgricultor(Scanner scan){

		System.out.println("Nome: ");
		String name = scan.next();

		frutaFeia.removeAgricultor(name);

		System.out.println("Agricultor "+name+" removido com sucesso!");

		String input = scan.next();
		displayManageAgricultoresMenu(scan);
	}

	public static void displayManageClientsMenu(Scanner scan){
		System.out.println("\n		<< Menu Clientes >>\n");
		System.out.println("		>> 1 - Ver Clientes");
		System.out.println("		>> 2 - Adicionar Cliente");
		System.out.println("		>> 3 - Remover Cliente");
		System.out.println("		>> 4 - Voltar");
		System.out.println("		>> 5 - Sair");
		System.out.println();

		int input = 0;
		menuDone = false;

		while (!menuDone){
			input = getUserInput(scan, 1, 5);
			switch(input){
				case 1:
					menuDone = true;
					viewClients(scan);
					break;
				case 2:
					menuDone = true;
					addClient(scan);
					break;
				case 3:
					menuDone = true;
					removeClient(scan);
					break;
				case 4:
					menuDone = true;
					displayAdminMenu(scan);
					break;
				case 5:
					menuDone = true;
					System.out.println("A sair de Fruta Feia..");
					scan.close();
					System.exit(0);
			}
		}
	}

	public static void displayManageAgricultoresMenu(Scanner scan){
		System.out.println("\n		<< Menu Agricultores >>\n");
		System.out.println("		>> 1 - Ver Agricultores");
		System.out.println("		>> 2 - Adicionar Agricultor");
		System.out.println("		>> 3 - Remover Agricultor");
		System.out.println("		>> 4 - Voltar");
		System.out.println("		>> 5 - Sair");
		System.out.println();

		int input = 0;
		menuDone = false;

		while (!menuDone){
			input = getUserInput(scan, 1, 5);
			switch(input){
				case 1:
					menuDone = true;
					viewAgricultores(scan);
					break;
				case 2:
					menuDone = true;
					addAgricultor(scan);
					break;
				case 3:
					menuDone = true;
					removeAgricultor(scan);
					break;
				case 4:
					menuDone = true;
					displayAdminMenu(scan);
					break;
				case 5:
					menuDone = true;
					System.out.println("A sair de Fruta Feia..");
					scan.close();
					System.exit(0);
			}
		}
	}

	public static void  viewCentros(Scanner scan){
		System.out.println(frutaFeia.centros);
		String input = scan.next();
		displayManageCentrosMenu(scan);
	}

	public static void addCentro(Scanner scan){
		CentroDistribuicao centro;

		System.out.println("Localização: ");
		String local = scan.next();

		centro = new CentroDistribuicao(local);

		frutaFeia.adicionaCentro(centro);

		System.out.println("Centro "+local+" criado com sucesso!");

		String input = scan.next();
		displayManageCentrosMenu(scan);
	}

	public static void  removeCentro(Scanner scan){
		System.out.println("Local: ");
		String local = scan.next();

		frutaFeia.removeCentro(local);

		System.out.println("Centro "+local+" removido com sucesso!");

		String input = scan.next();
		displayManageCentrosMenu(scan);
	}

	public static void displayManageCentrosMenu(Scanner scan){
		System.out.println("\n		<< Menu Admin >>\n");
		System.out.println("		>> 1 - Ver Centros");
		System.out.println("		>> 2 - Adicionar Centro");
		System.out.println("		>> 3 - Remover Centro");
		System.out.println("		>> 4 - Voltar");
		System.out.println("		>> 5 - Sair");
		System.out.println();

		int input = 0;
		menuDone = false;

		while (!menuDone){
			input = getUserInput(scan, 1, 5);
			switch(input){
				case 1:
					menuDone = true;
					viewCentros(scan);
					break;
				case 2:
					menuDone = true;
					addCentro(scan);
					break;
				case 3:
					menuDone = true;
					removeCentro(scan);
					break;
				case 4:
					menuDone = true;
					displayAdminMenu(scan);
					break;
				case 5:
					menuDone = true;
					System.out.println("A sair de Fruta Feia..");
					scan.close();
					System.exit(0);
			}
		}
	}

	public static void createCestas(Scanner scan){
		frutaFeia.geraCestaTodosClientes();

		System.out.println("Cestas geradas com sucesso!");
		String input = scan.next();
		displayAdminMenu(scan);
	}

	/**
	 * Displays the Admin Menu
	 */
	public static void displayAdminMenu(Scanner scan){
		System.out.println("\n		<< Menu Admin >>\n");
		System.out.println("		>> 1 - Gerar Cestas");
		System.out.println("		>> 2 - Gerir Clientes");
		System.out.println("		>> 3 - Gerir Agricultores");
		System.out.println("		>> 4 - Gerir Centros");
		System.out.println("		>> 5 - Voltar");
		System.out.println("		>> 6 - Sair");
		System.out.println();

		int input = 0;
		menuDone = false;

		while (!menuDone){
			input = getUserInput(scan, 1, 6);
			switch(input){
				case 1:
					menuDone = true;
					createCestas(scan);
					break;
				case 2:
					menuDone = true;
					displayManageClientsMenu(scan);
					break;
				case 3:
					menuDone = true;
					displayManageAgricultoresMenu(scan);
					break;
				case 4:
					menuDone = true;
					displayManageCentrosMenu(scan);
					break;
				case 5:
					menuDone = true;
					displayMainMenu(scan);
					break;
				case 6:
					menuDone = true;
					System.out.println("A sair de Fruta Feia..");
					scan.close();
					System.exit(0);
			}
		}
	}

	public static void viewCesta(Scanner scan){
		System.out.println(clienteUser.encomenda);
		String input = scan.next();
		displayClientMenu(scan);
	}

	public static void changeCesta(Scanner scan){
		System.out.println(clienteUser.encomenda);

		System.out.println("Deseja alterar o tipo de cesta?(S/N) ");
		String answer = scan.next();

		if(answer.toUpperCase().equals("S")){
			if(clienteUser.encomenda.tamanho == Quotes.GRANDEQuote.getInstance())
				clienteUser.encomenda.alterarTamanho(Quotes.PEQUENAQuote.getInstance());
			else
				clienteUser.encomenda.alterarTamanho(Quotes.GRANDEQuote.getInstance());

			System.out.println("Tipo de cesta alterado com sucesso!");
		}

		String input = scan.next();
		displayClientMenu(scan);
	}

	public static  void pickCesta(Scanner scan){
		clienteUser.levantaCesta();
		clienteUser.mudaCesta(new Cesta());
		System.out.println("A cesta foi levantada com sucesso!");
		String input = scan.next();
		displayClientMenu(scan);
	}

	/**
	 * Displays the Client menu
	 */
	public static void displayClientMenu(Scanner scan){
		System.out.println("\n		<< Menu Cliente >>\n");
		System.out.println("		>> 1 - Ver cesta");

		if(clienteUser.estadoEnc != Quotes.PRONTAQuote.getInstance())
			System.out.println("		>> 2 - Alterar cesta");
		else
			System.out.println("		>> 2 - Levantar cesta");

		System.out.println("		>> 3 - Voltar");
		System.out.println("		>> 4 - Sair");
		System.out.println();

		int input = 0;
		menuDone = false;

		if(clienteUser.estadoEnc != Quotes.PRONTAQuote.getInstance()){
			while (!menuDone){
				input = getUserInput(scan, 1, 5);
				switch(input){
					case 1:
						menuDone = true;
						viewCesta(scan);
						break;
					case 2:
						menuDone = true;
						changeCesta(scan);
						break;
					case 3:
						menuDone = true;
						menuLoginCliente(scan);
						break;
					case 4:
						menuDone = true;
						System.out.println("A sair de Fruta Feia..");
						scan.close();
						System.exit(0);
				}
			}
		}
		else {
			while (!menuDone) {
				input = getUserInput(scan, 1, 5);
				switch (input) {
					case 1:
						menuDone = true;
						viewCesta(scan);
						break;
					case 2:
						menuDone = true;
						pickCesta(scan);
						break;
					case 3:
						menuDone = true;
						menuLoginCliente(scan);
						break;
					case 4:
						menuDone = true;
						System.out.println("A sair de Fruta Feia..");
						scan.close();
						System.exit(0);
				}
			}
		}
	}

	public static void viewProdutosAgricultor(Scanner scan, Agricultor agricultor){
		System.out.println(agricultor.stock);
		String input = scan.next();
		displayAgricultorMenu(scan);
	}

	public static void addProdutoAgricultor(Scanner scan){
		System.out.println("Nome: ");
		String name = scan.next();
		System.out.println("Origem: ");
		String origin = scan.next();

		Produto produto = new Produto(name, origin, 0);

		agricultorUser.adicionaProduto(produto);

		System.out.println("Produto "+name+" criado com sucesso!");

		String input = scan.next();
		displayAgricultorMenu(scan);
	}

	public static void  removeProdutoAgricultor(Scanner scan){
		System.out.println("Nome produto: ");
		String name = scan.next();

		agricultorUser.removeProduto(name);

		System.out.println("Produto "+name+" removido com sucesso!");

		String input = scan.next();
		displayAgricultorMenu(scan);
	}

	public static void addPesoProdutoAgricultor(Scanner scan){
		System.out.println("Nome produto: ");
		String name = scan.next();
		System.out.println("Peso: ");
		String peso = scan.next();

		agricultorUser.adicionaPesoProduto(name, Double.valueOf(peso));

		System.out.println("Peso adicionado!");

		String input = scan.next();
		displayAgricultorMenu(scan);
	}

	public static void removePesoProdutoAgricultor(Scanner scan){
		System.out.println("Nome produto: ");
		String name = scan.next();
		System.out.println("Peso: ");
		String peso = scan.next();

		agricultorUser.removePesoProduto(name, Double.valueOf(peso));

		System.out.println("Peso removido!");

		String input = scan.next();
		displayAgricultorMenu(scan);
	}

	/**
	 * Displays the Agricultor menu
	 */
	public static void displayAgricultorMenu(Scanner scan){
		System.out.println("\n		<< Menu Agricultor >>\n");
		System.out.println("		>> 1 - Ver produtos ");
		System.out.println("		>> 2 - Adicionar produto");
		System.out.println("		>> 3 - Remover produto");
		System.out.println("		>> 4 - Adicionar peso produto");
		System.out.println("		>> 5 - Remover peso produto");
		System.out.println("		>> 6 - Voltar");
		System.out.println("		>> 7 - Sair");
		System.out.println();

		int input = 0;
		menuDone = false;

		while (!menuDone){
			input = getUserInput(scan, 1, 7);
			switch(input){
				case 1:
					menuDone = true;
					viewProdutosAgricultor(scan, agricultorUser);
					break;
				case 2:
					menuDone = true;
					addProdutoAgricultor(scan);
					break;
				case 3:
					menuDone = true;
					removeProdutoAgricultor(scan);
					break;
				case 4:
					menuDone = true;
					addPesoProdutoAgricultor(scan);
					break;
				case 5:
					menuDone = true;
					removePesoProdutoAgricultor(scan);
					break;
				case 6:
					menuDone = true;
					menuLoginAgricultor(scan);
					break;
				case 7:
					menuDone = true;
					System.out.println("A sair de Fruta Feia..");
					scan.close();
					System.exit(0);
			}
		}
	}

	public static void loginCliente(Scanner scan){
		boolean found = false;

		System.out.println("Nome: ");
		String name = scan.next();

		for (Object cliente: frutaFeia.getTodosClientes()){
			if(((Cliente) cliente).nome.equals(name)){
				clienteUser = (Cliente) cliente;
				found = true;
				break;
			}
		}

		if(found)
			displayClientMenu(scan);
		else {
			System.out.println("Utilizador não encontrado. Tente novamente!");
			menuLoginCliente(scan);
		}
	}

	public static void registerCliente(Scanner scan){
		System.out.println("Nome: ");
		String name = scan.next();
		System.out.println("Género(H/M): ");
		String genre = scan.next();
		System.out.println("Localização: ");
		String local = scan.next();

		if(genre.equals("H"))
			clienteUser = new Cliente(name, Quotes.HOMEMQuote.getInstance());
		else
			clienteUser = new Cliente(name, Quotes.MULHERQuote.getInstance());

		frutaFeia.adicionaCliente(clienteUser, local);

		System.out.println("Cliente "+name+" criado com sucesso!");

		String input = scan.next();
		displayClientMenu(scan);
	}

	public static void menuLoginCliente(Scanner scan){
		System.out.println("\n		<< Menu Cliente>>\n");
		System.out.println("		>> 1 - Entrar ");
		System.out.println("		>> 2 - Registar");
		System.out.println("		>> 3 - Voltar");
		System.out.println("		>> 4 - Sair");
		System.out.println();

		int input = 0;
		menuDone = false;

		while (!menuDone){
			input = getUserInput(scan, 1, 4);
			switch(input){
				case 1:
					menuDone = true;
					loginCliente(scan);
					break;
				case 2:
					menuDone = true;
					registerCliente(scan);
					break;
				case 3:
					menuDone = true;
					displayMainMenu(scan);
					break;
				case 4:
					menuDone = true;
					System.out.println("A sair de Fruta Feia..");
					scan.close();
					System.exit(0);
			}
		}
	}

	public static void loginAgricultor(Scanner scan){
		boolean found = false;

		System.out.println("Nome: ");
		String name = scan.next();

		for (Object agricultor: frutaFeia.agricultores){
			if(((Agricultor) agricultor).nome.equals(name)){
				agricultorUser = (Agricultor) agricultor;
				found = true;
				break;
			}
		}

		if(found)
			displayAgricultorMenu(scan);
		else {
			System.out.println("Utilizador não encontrado. Tente novamente!");
			menuLoginAgricultor(scan);
		}
	}

	public static void registerAgricultor(Scanner scan){
		System.out.println("Nome: ");
		String name = scan.next();
		System.out.println("Localização: ");
		String local = scan.next();

		agricultorUser = new Agricultor(name, local);

		frutaFeia.adicionaAgricultor(agricultorUser);

		System.out.println("Agricultor "+name+" criado com sucesso!");

		String input = scan.next();
		displayAgricultorMenu(scan);
	}

	public static void menuLoginAgricultor(Scanner scan){
		System.out.println("\n		<< Menu Agricultor >>\n");
		System.out.println("		>> 1 - Entrar ");
		System.out.println("		>> 2 - Registar");
		System.out.println("		>> 3 - Voltar");
		System.out.println("		>> 4 - Sair");
		System.out.println();

		int input = 0;
		menuDone = false;

		while (!menuDone){
			input = getUserInput(scan, 1, 4);
			switch(input){
				case 1:
					menuDone = true;
					loginAgricultor(scan);
					break;
				case 2:
					menuDone = true;
					registerAgricultor(scan);
					break;
				case 3:
					menuDone = true;
					displayMainMenu(scan);
					break;
				case 4:
					menuDone = true;
					System.out.println("A sair de Fruta Feia..");
					scan.close();
					System.exit(0);
			}
		}
	}

	/**
	 * Displays the Main Menu
	 */
	public static void displayMainMenu(Scanner scan){
		System.out.println("\n		<< Menu Inicial >>\n");
		System.out.println("		>> 1 - Menu Admin");
		System.out.println("		>> 2 - Menu Cliente ");
		System.out.println("		>> 3 - Menu Agricultor");
		System.out.println("		>> 4 - Sair");
		System.out.println();

		int input = 0;
		menuDone = false;

		while (!menuDone){
			input = getUserInput(scan, 1, 4);
			switch(input){
				case 1:
					menuDone = true;
					displayAdminMenu(scan);
					break;
				case 2:
					menuDone = true;
					menuLoginCliente(scan);
					break;
				case 3:
					menuDone = true;
					menuLoginAgricultor(scan);
					break;
				case 4:
					menuDone = true;
					System.out.println("A sair de Fruta Feia..");
					scan.close();
					System.exit(0);
					break;
			}
		}
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
		Produto produto1 = new Produto("Maca", "Golden", 50);
		Produto produto2 = new Produto("Pera", "Rocha", 50);
		Produto produto3 = new Produto("Batata", "Nacional", 50);
		Produto produto4 = new Produto("Couve", "Nacional", 50);
		Produto produto5 = new Produto("Bróculo", "Nacional", 50);
		Produto produto6 = new Produto("Nabo", "Nacional", 50);
		Produto produto7 = new Produto("Laranga", "Nacional", 50);
		Produto produto8 = new Produto("Espinafre", "Nacionl", 50);

		Produto produto9 = new Produto("Maca", "Golden", 50);
		Produto produto10 = new Produto("Pera", "Rocha", 50);
		Produto produto11 = new Produto("Batata", "Nacional", 50);
		Produto produto12 = new Produto("Couve", "Nacional", 50);
		Produto produto13 = new Produto("Bróculo", "Nacional", 50);
		Produto produto14 = new Produto("Nabo", "Nacional", 50);
		Produto produto15 = new Produto("Laranga", "Nacional", 50);
		Produto produto16 = new Produto("Espinafre", "Nacionl", 50);

		agricultor1.adicionaProduto(produto1);
		agricultor1.adicionaProduto(produto2);
		agricultor1.adicionaProduto(produto3);
		agricultor1.adicionaProduto(produto4);
		agricultor1.adicionaProduto(produto5);
		agricultor1.adicionaProduto(produto6);
		agricultor1.adicionaProduto(produto7);
		agricultor1.adicionaProduto(produto8);

		agricultor2.adicionaProduto(produto9);
		agricultor2.adicionaProduto(produto10);
		agricultor2.adicionaProduto(produto11);
		agricultor2.adicionaProduto(produto12);

		agricultor3.adicionaProduto(produto13);
		agricultor3.adicionaProduto(produto14);
		agricultor3.adicionaProduto(produto15);
		agricultor3.adicionaProduto(produto16);

		// Clientes
		Cliente cliente1 = new Cliente("Pedro", Quotes.HOMEMQuote.getInstance());
		Cliente cliente2 = new Cliente("Manuel", Quotes.HOMEMQuote.getInstance());
		Cliente cliente3 = new Cliente("Carlos", Quotes.HOMEMQuote.getInstance());

		frutaFeia.adicionaCliente(cliente1, "Porto");
		frutaFeia.adicionaCliente(cliente2, "Porto");
		frutaFeia.adicionaCliente(cliente3, "Porto");

		// Cestas
		Cesta cesta1 = new Cesta();
		Cesta cesta2 = new Cesta();
		Cesta cesta3 = new Cesta();
		cesta3.alterarTamanho(Quotes.GRANDEQuote.getInstance());

		cliente1.mudaCesta(cesta1);
		cliente2.mudaCesta(cesta2);
		cliente3.mudaCesta(cesta3);
	}

	public static void main (String[] args) {
		initializeFrutaFeia();

		Scanner scan = new Scanner(System.in);
		int input = 0;
		System.out.println(title);

		displayMainMenu(scan);
	}
}
