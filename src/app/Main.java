package app;

import dao.ClienteDAO;
import model.Cliente;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ClienteDAO clienteDAO = new ClienteDAO();

        System.out.println("==========CADASTRO DE CLIENTES==========");

        System.out.print("Insira o nome: ");
        String nome = scanner.nextLine();

        System.out.print("Insira o email: ");
        String email = scanner.nextLine();

        Cliente cliente = new Cliente(nome, email);

        clienteDAO.inserir(cliente);

        System.out.println("Cliente cadastrado com sucesso!");

        scanner.close();

    }
}