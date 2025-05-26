package fruta;.

import produto.Produto;             

public class Fruta extends Produto {
    private int id;
    private String cor;
    private int vendidos;

    public Fruta(int id, String nome, String cor, double preco, int estoque, int vendidos) {
        super(nome, preco, estoque);
        this.id = id;
        this.cor = cor;
        this.vendidos = vendidos;
    }

    public Fruta(String nome, String cor, double preco, int estoque) {
        this(0, nome, cor, preco, estoque, 0);
    }

    public int getId() { return id; }
    public String getCor() { return cor; }
    public int getVendidos() { return vendidos; }
    public String getNome() { return nome; }
    public double getPreco() { return preco; }
    public int getEstoque() { return estoque; }

    public void vender(int quantidade) {
        if (quantidade <= 0) {
            System.out.println("Quantidade inválida para venda.");
            return;
        }
        if (estoque >= quantidade) {
            estoque -= quantidade;
            vendidos += quantidade;
            System.out.println(quantidade + " " + nome + "(s) vendidos com sucesso.");
        } else {
            System.out.println("Estoque insuficiente de " + nome + ".");
        }
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("ID: " + id + ", Nome: " + nome + ", Cor: " + cor + ", Preço: " + preco + ", Estoque: " + estoque + ", Vendidos: " + vendidos);
    }
}

