package produto;.

public abstract class Produto {
    protected String nome;
    protected double preco;
    protected int estoque;

    public Produto(String nome, double preco, int estoque) {
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }

    public abstract void exibirDetalhes();
}
