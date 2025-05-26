package servico;

import fruta.Fruta;                 
import java.util.List;              

public interface interface_de_servico {
    void cadastrarFruta(String nome, String cor, double preco, int estoque);
    void venderFruta(String nome, int quantidade);
    void removerFruta(String nome);
    List<Fruta> listarFrutas();
    Fruta buscarFrutaPorNome(String nome);
}
