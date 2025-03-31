class FrutaServicoImpl implements FrutaServico {
    private FrutaRepositorio repositorio;

    public FrutaServicoImpl(FrutaRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public void cadastrarFruta(String nome, String cor, double preco, int estoque) {
        Fruta fruta = new Fruta(nome, cor, preco, estoque);
        repositorio.adicionar(fruta);
    }

    @Override
    public void venderFruta(String nome, int quantidade) {
        Fruta fruta = repositorio.buscar(nome);
        if (fruta != null) {
            fruta.vender(quantidade);
        } else {
            System.out.println("Fruta não encontrada.");
        }
    }

    @Override
    public void listarFrutas() {
        for (Fruta fruta : repositorio.listar()) {
            fruta.exibirDetalhes();
        }
    }

    @Override
    public void removerFruta(String nome) {
        repositorio.remover(nome);
        System.out.println("Fruta " + nome + " removida.");
    }
}
