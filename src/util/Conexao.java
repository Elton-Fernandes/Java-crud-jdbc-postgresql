package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String URL = "jdbc:postgresql://localhost:5432/ProjetoJava";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "26122006";

    public static Connection getConnection() {

        try{
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar ao banco", e);
        }
    }
}
