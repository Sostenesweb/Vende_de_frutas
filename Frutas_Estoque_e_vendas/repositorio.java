package produto;

import java.util.List;
import java.util.function.Predicate;

public interface repositorio<T> {
    void adicionar(T objeto);
    void removerPorNome(String nome);
    void removerPorId(int id);
    T buscarPorNome(String nome);
    T buscarPorId(int id);
    List<T> listar();
    void atualizar(T objeto);
    List<T> buscarPorFiltro(Predicate<T> filtro);
}
