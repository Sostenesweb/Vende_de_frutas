package conexao;

import java.sql.Connection;         
import java.sql.DriverManager;      
import java.sql.SQLException;      

public class ConexaoMySQL {
    private static final String URL = "jdbc:mysql://localhost:3306/venda_de_frutas";
    private static final String USUARIO = "root";
    private static final String SENHA = "my20072002";

    public static Connection getConexao() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
}
