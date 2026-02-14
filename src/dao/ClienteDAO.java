package dao;

import util.Conexao;
import model.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteDAO {

    public void inserir (Cliente cliente) {

        String sql = "INSERT INTO Cliente (nome, email) VALUES (?, ?)";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){

                 stmt.setString(1, cliente.getNome());
                 stmt.setString(2, cliente.getEmail());

                 stmt.executeUpdate();


        } catch (SQLException e) {
                 throw new RuntimeException("Erro ao inserir o cliente!", e);
        }
    }

    public void alterar (String emailAntigo, Cliente cliente) {

        String sql = "UPDATE Cliente SET nome = ?, email = ? WHERE email = ?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

                stmt.setString(1, cliente.getNome());
                stmt.setString(2, cliente.getEmail());
                stmt.setString(3, emailAntigo);

                stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao alterar os dados do cliente!", e);
        }
    }

    public void deletar (String email) {

        String sql = "DELETE FROM Cliente WHERE email = ?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){

                stmt.setString(1, email);

                stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar o cliente!", e);
        }
    }
}
