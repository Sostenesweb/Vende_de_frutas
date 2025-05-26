package servico;

import fruta.FrutaRepositorio;
import fruta.Fruta;
import java.util.List;

public class frutaservicoImpl implements frutaservico {
    public FrutaRepositorio repositorio;

    public void FrutaServicoImpl(FrutaRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public void cadastrarfruta(String nome, String cor, double preco, int estoque) {
        Fruta fruta = new Fruta(nome, cor, preco, estoque);
        repositorio.adicionar(fruta);
    }

    @Override
    public void venderFruta(String nome, int quantidade) {
        Fruta fruta = repositorio.buscarPorNome(nome);
        if (fruta != null) {
            fruta.vender(quantidade);
        } else {
            System.out.println("Fruta não encontrada.");
        }
    }

    @Override
    public List<Fruta> listarFrutas() {
        return repositorio.listar();
    }

    @Override
    public void removerFruta(String nome) {
        repositorio.removerPorNome(nome);
        System.out.println("Fruta " + nome + " removida.");
    }
}
