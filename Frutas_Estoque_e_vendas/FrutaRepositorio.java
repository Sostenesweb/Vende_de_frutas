package fruta;.

import fruta.Fruta;                 
import conexao.ConexaoMySQL;        
import java.sql.*;                  
import java.util.*;                 
import java.util.function.Predicate;

public class FrutaRepositorio implements Repositorio<Fruta> {

    @Override
    public void adicionar(Fruta fruta) {
        String sql = "INSERT INTO frutas (nome, cor, preco, estoque, vendidos) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConexaoMySQL.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, fruta.getNome());
            stmt.setString(2, fruta.getCor());
            stmt.setDouble(3, fruta.getPreco());
            stmt.setInt(4, fruta.getEstoque());
            stmt.setInt(5, fruta.getVendidos());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removerPorNome(String nome) {
        String sql = "DELETE FROM frutas WHERE nome = ?";
        try (Connection conn = ConexaoMySQL.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removerPorId(int id) {
        String sql = "DELETE FROM frutas WHERE id = ?";
        try (Connection conn = ConexaoMySQL.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Fruta buscarPorNome(String nome) {
        String sql = "SELECT * FROM frutas WHERE nome = ?";
        try (Connection conn = ConexaoMySQL.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Fruta(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("cor"),
                    rs.getDouble("preco"),
                    rs.getInt("estoque"),
                    rs.getInt("vendidos")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Fruta buscarPorId(int id) {
        String sql = "SELECT * FROM frutas WHERE id = ?";
        try (Connection conn = ConexaoMySQL.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Fruta(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("cor"),
                    rs.getDouble("preco"),
                    rs.getInt("estoque"),
                    rs.getInt("vendidos")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Fruta> listar() {
        List<Fruta> frutas = new ArrayList<>();
        String sql = "SELECT * FROM frutas";
        try (Connection conn = ConexaoMySQL.getConexao();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Fruta fruta = new Fruta(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("cor"),
                    rs.getDouble("preco"),
                    rs.getInt("estoque"),
                    rs.getInt("vendidos")
                );
                frutas.add(fruta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return frutas;
    }

    @Override
    public void atualizar(Fruta fruta) {
        String sql = "UPDATE frutas SET nome=?, cor=?, preco=?, estoque=?, vendidos=? WHERE id=?";
        try (Connection conn = ConexaoMySQL.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, fruta.getNome());
            stmt.setString(2, fruta.getCor());
            stmt.setDouble(3, fruta.getPreco());
            stmt.setInt(4, fruta.getEstoque());
            stmt.setInt(5, fruta.getVendidos());
            stmt.setInt(6, fruta.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Fruta> buscarPorFiltro(java.util.function.Predicate<Fruta> filtro) {
        List<Fruta> todas = listar();
        List<Fruta> filtradas = new ArrayList<>();
        for (Fruta fruta : todas) {
            if (filtro.test(fruta)) {
                filtradas.add(fruta);
            }
        }
        return filtradas;
    }
}
