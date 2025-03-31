import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FrutaRepositorio repositorio = new FrutaRepositorio();
        FrutaServico servico = new FrutaServicoImpl(repositorio);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Cadastrar Fruta");
            System.out.println("2. Vender Fruta");
            System.out.println("3. Listar Frutas");
            System.out.println("4. Remover Fruta");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar bufe

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Cor: ");
                    String cor = scanner.nextLine();
                    System.out.print("Preço: ");
                    double preco = scanner.nextDouble();
                    System.out.print("Estoque: ");
                    int estoque = scanner.nextInt();
                    servico.cadastrarFruta(nome, cor, preco, estoque);
                    break;
                case 2:
                    System.out.print("Nome da fruta: ");
                    String nomeVenda = scanner.nextLine();
                    System.out.print("Quantidade: ");
                    int quantidade = scanner.nextInt();
                    servico.venderFruta(nomeVenda, quantidade);
                    break;
                case 3:
                    servico.listarFrutas();
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
