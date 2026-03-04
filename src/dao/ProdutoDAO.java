package dao;

import util.Conexao;
import model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    public void inserir(Produto produto) {

        String sql = "INSERT INTO produto (nome, preco) VALUES (?, ?)";

        try (Connection conn = Conexao.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir o produto!", e);
        }
    }

    public List<Produto> listar() {

        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT nome, preco FROM produto";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                String nome = rs.getString("nome");
                double preco = rs.getDouble("preco");

                Produto produto = new Produto(nome, preco);
                produtos.add(produto);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar os produtos!", e);
        }

        return produtos;
    }

    public boolean alterar (String nomeAntigo, Produto produto) {

        int linhasAlteradas;
        String sql = "UPDATE produto SET nome = ?, preco = ? WHERE nome = ?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.setString(3, nomeAntigo);

            linhasAlteradas = stmt.executeUpdate();

            return linhasAlteradas > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao alterar os dados do produto!", e);
        }

    }

    public boolean deletar (String nome) {

        int linhasAlteradas;
        String sql = "DELETE FROM produto WHERE nome = ?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, nome);

            linhasAlteradas = stmt.executeUpdate();

            return linhasAlteradas > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar o produto!", e);
        }

    }
}
