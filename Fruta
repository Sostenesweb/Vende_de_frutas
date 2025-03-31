class Fruta extends Produto {
    private String cor;
    private int vendidos;

    public Fruta(String nome, String cor, double preco, int estoque) {
        super(nome, preco, estoque);
        this.cor = cor;
        this.vendidos = 0;
    }

    public String getCor() { return cor; }
    public int getVendidos() { return vendidos; }

    public void vender(int quantidade) {
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
        System.out.println("Nome: " + nome + ", Cor: " + cor + ", Preço: " + preco + ", Estoque: " + estoque + ", Vendidos: " + vendidos);
    }
}
