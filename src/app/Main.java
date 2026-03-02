package app;

import dao.ClienteDAO;
import dao.ProdutoDAO;
import model.Cliente;
import model.Produto;

import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ClienteDAO clienteDAO = new ClienteDAO();
        ProdutoDAO produtoDAO = new ProdutoDAO();

        int opcao;

        do {

            System.out.println("==========CRUD==========");
            System.out.println("Escolha uma das opções a seguir:");
            System.out.println("1 - Cliente\n2 - Produto\n0 - Sair");
            System.out.print("Insira a sua escolha: ");
            opcao = scanner.nextInt();
            scanner.nextLine();
            System.out.println("========================");

            if (opcao < 0 || opcao > 2) {
                System.out.println("Opção inválida! Tente novamente.");
                continue;
            }
            

            switch (opcao) {

                case 1:
                    menuCliente(scanner, clienteDAO);
                    break;
                case 2:
                    menuProduto(scanner, produtoDAO);
                    break;
                case 0:
                    System.out.println("Finalizando...");
            }



        } while (opcao != 0);

        scanner.close();

    }

    public static void menuCliente(Scanner scanner, ClienteDAO clienteDAO) {

        int opcao;
        do {

            System.out.println("======MENU-CLIENTE======");
            System.out.println("Escolha uma das opções a seguir:");
            System.out.println("1 - Cadastrar\n2 - Listar\n3 - Alterar\n4 - Deletar\n0 - Voltar");
            System.out.print("Insira a sua escolha: ");
            opcao = scanner.nextInt();
            scanner.nextLine();
            System.out.println("========================");

            if (opcao < 0 || opcao > 4) {
                System.out.println("Opção inválida! Tente novamente.");
                continue;
            }


            switch (opcao) {
                case 1:
                    inserirCliente(scanner, clienteDAO);
                    break;
                case 2:
                    listarCliente(clienteDAO);
                    break;
                case 3:
                    alterarCliente(scanner, clienteDAO);
                    break;
                case 4:
                    deletarCliente(scanner, clienteDAO);
                    break;
                case 0:
                    System.out.println("Voltando...");
                    break;

            }

        } while (opcao != 0);
    }

    public static void menuProduto(Scanner scanner, ProdutoDAO produtoDAO) {

        int opcao;
        do {

            System.out.println("======MENU-PRODUTO======");
            System.out.println("Escolha uma das opções a seguir:");
            System.out.println("1 - Cadastrar\n2 - Listar\n3 - Alterar\n4 - Deletar\n0 - Voltar");
            System.out.print("Insira a sua escolha: ");
            opcao = scanner.nextInt();
            scanner.nextLine();
            System.out.println("========================");

            if (opcao < 0 || opcao > 4) {
                System.out.println("Opção inválida! Tente novamente.");
                continue;
            }


            switch (opcao) {
                case 1:
                    inserirProduto(scanner, produtoDAO);
                    break;
                case 2:
                    listarProduto(produtoDAO);
                    break;
                case 3:
                    alterarProduto(scanner, produtoDAO);
                    break;
                case 4:
                    deletarProduto(scanner, produtoDAO);
                    break;
                case 0:
                    System.out.println("Voltando...");
                    break;

            }

        } while (opcao != 0);
    }

    public static void inserirCliente(Scanner scanner, ClienteDAO clienteDAO) {

        // Leitura do nome e email
        System.out.print("Insira o nome: ");
        String nome = scanner.nextLine().trim();


        System.out.print("Insira o email: ");
        String email = scanner.nextLine().trim();

        email = validarEmail(email, scanner);

        // criação do objeto cliente
        Cliente cliente = new Cliente(nome, email);

        // obejto clienteDAO inserindo o objeto cliente no BD
        clienteDAO.inserir(cliente);

        System.out.println("Cliente cadastrado com sucesso!");

    }

    public static void listarCliente(ClienteDAO clienteDAO) {

        // Criação do array
        List<Cliente> clientes = clienteDAO.listar();

        // Loop pra mostrar os nome e email de cada cliente da tabela
        for (Cliente c : clientes) {
            System.out.println("Nome: " + c.getNome());
            System.out.println("Email: " + c.getEmail());
            System.out.println("-----------------");
        }
    }

    public static void alterarCliente(Scanner scanner, ClienteDAO clienteDAO) {

        // Leitura do email antigo
        System.out.print("Insira o email antigo do cliente: ");
        String emailAntigo = scanner.nextLine().trim();
        emailAntigo = validarEmail(emailAntigo, scanner);

        // Leitura dos novos dados
        System.out.print("Insira o nome do cliente: ");
        String nome = scanner.nextLine().trim();

        System.out.print("Insira o email do cliente: ");
        String email = scanner.nextLine().trim();
        email = validarEmail(email, scanner);


        // Criação de um objeto cliente
        Cliente cliente = new Cliente(nome, email);

        // Objeto clienteDAO alterando o BD
        clienteDAO.alterar(emailAntigo, cliente);

    }

    public static void deletarCliente(Scanner scanner, ClienteDAO clienteDAO) {

        // Leitura do email
        System.out.print("Insira o email do cliente: ");
        String email = scanner.nextLine().trim();
        email = validarEmail(email, scanner);

        // objeto clienteDAO deletando o cliente no BD
        clienteDAO.deletar(email);

    }

    public static String validarEmail(String email, Scanner scanner) {


        while (!email.contains("@") || !email.contains(".")){
            System.out.println("Email inválido! Tente novamente.");
            System.out.print("Insira o email: ");
            email = scanner.nextLine().trim();

        }

        return email;
    }

    public static void inserirProduto(Scanner scanner, ProdutoDAO produtoDAO) {

        // Leitura do nome e preço
        System.out.print("Insira o nome do produto: ");
        String nome = scanner.nextLine().trim();


        System.out.print("Insira o preço: ");
        double preco = scanner.nextDouble();
        scanner.nextLine();

        // criação do objeto produto
        Produto produto = new Produto(nome, preco);

        // obejto produtoDAO inserindo o objeto cliente no BD
        produtoDAO.inserir(produto);

        System.out.println("Produto cadastrado com sucesso!");

    }

    public static void listarProduto(ProdutoDAO produtoDAO) {

        // Criação do array
        List<Produto> produtos = produtoDAO.listar();

        // Loop pra mostrar os nome e preços de cada produto
        for (Produto p : produtos) {
            System.out.println("Nome: " + p.getNome());
            System.out.println("Preço: " + p.getPreco());
            System.out.println("-----------------");
        }
    }

    public static void alterarProduto(Scanner scanner, ProdutoDAO produtoDAO) {

        // Leitura do nome antigo
        System.out.print("Insira o nome do produto: ");
        String nomeAntigo = scanner.nextLine().trim();

        // Leitura dos novos dados
        System.out.print("Insira o nome do produto: ");
        String nome = scanner.nextLine().trim();

        System.out.print("Insira o preço do produto: ");
        double preco = scanner.nextDouble();
        scanner.nextLine();



        // Criação de um objeto cliente
        Produto produto = new Produto(nome, preco);

        // Objeto produtoDAO alterando o BD
        produtoDAO.alterar(nomeAntigo, produto);

    }

    public static void deletarProduto(Scanner scanner, ProdutoDAO produtoDAO) {

        // Leitura do nome
        System.out.print("Insira o nome do produto: ");
        String nome = scanner.nextLine().trim();

        // objeto produtoDAO deletando o cliente no BD
        produtoDAO.deletar(nome);

    }

}
