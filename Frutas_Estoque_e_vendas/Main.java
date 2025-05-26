package produto;

import fruta.FrutaRepositorio;
import servico.frutaservicoImpl;
import servico.frutaservicoImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FrutaRepositorio repositorio = new FrutaRepositorio();
        frutaservicoImpl servico = new frutaservicoImpl(repositorio);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Cadastrar Fruta");
            System.out.println("2. Vender Fruta");
            System.out.println("3. Listar Frutas");
            System.out.println("4. Remover Fruta");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Cor: ");
                    String cor = scanner.nextLine();
                    System.out.print("Preço: ");
                    double preco = scanner.nextDouble();
                    scanner.nextLine(); // Limpa o buffer
                    System.out.print("Estoque: ");
                    int estoque = scanner.nextInt();
                    scanner.nextLine(); // Limpa o buffer
                    servico.cadastrarFruta(nome, cor, preco, estoque);
                    break;
                case 2:
                    System.out.print("Nome da fruta: ");
                    String nomeVenda = scanner.nextLine();
                    System.out.print("Quantidade: ");
                    int quantidade = scanner.nextInt();
                    scanner.nextLine(); // Limpa o buffer
                    servico.venderFruta(nomeVenda, quantidade);
                    break;
                case 3:
                    // Exibe detalhes das frutas ao listar
                    for (fruta.Fruta fruta : servico.listarFrutas()) {
                        fruta.exibirDetalhes();
                    }
                    break;
                case 4:
                    System.out.print("Nome da fruta a remover: ");
                    String nomeRemover = scanner.nextLine();
                    servico.removerFruta(nomeRemover);
                    break;
                case 5:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
