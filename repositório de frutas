import java.util.ArrayList;
import java.util.List;

class FrutaRepositorio implements Repositorio<Fruta> {
    private List<Fruta> frutas = new ArrayList<>();

    @Override
    public void adicionar(Fruta fruta) {
        frutas.add(fruta);
    }
    @Override
    public void remover(String nome) {
        frutas.removeIf(fruta -> fruta.getNome().equalsIgnoreCase(nome));    
    }

    @Override
    public Fruta buscar(String nome) {
        for (Fruta fruta : frutas) {
            if (fruta.getNome().equalsIgnoreCase(nome)) {
                return fruta;
            }
        }
        return null;
    }

    @Override
    public List<Fruta> listar() {
        return frutas;
    }
}
