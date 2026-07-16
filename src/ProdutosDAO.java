/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ProdutosDAO {
    
    Connection conn;
    
    public boolean cadastrarProduto (ProdutosDTO produto){
        String sql = "INSERT INTO produtos (nome, valor, status) VALUES (?, ?, ?)";
        conn = new conectaDAO().connectDB();

        if (conn == null) {
            return false;
        }

        try (Connection connection = conn;
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, produto.getNome());
            statement.setInt(2, produto.getValor());
            statement.setString(3, produto.getStatus());

            return statement.executeUpdate() == 1;
        } catch (SQLException erro) {
            System.err.println("Erro ao cadastrar produto: " + erro.getMessage());
            return false;
        }
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        String sql = "SELECT id, nome, valor, status FROM produtos ORDER BY id";
        ArrayList<ProdutosDTO> produtos = new ArrayList<>();
        conn = new conectaDAO().connectDB();

        if (conn == null) {
            return produtos;
        }

        try (Connection connection = conn;
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultado = statement.executeQuery()) {

            while (resultado.next()) {
                ProdutosDTO produto = new ProdutosDTO();
                produto.setId(resultado.getInt("id"));
                produto.setNome(resultado.getString("nome"));
                produto.setValor(resultado.getInt("valor"));
                produto.setStatus(resultado.getString("status"));
                produtos.add(produto);
            }
        } catch (SQLException erro) {
            System.err.println("Erro ao listar produtos: " + erro.getMessage());
        }

        return produtos;
    }

    public boolean venderProduto(int id) {
        String sql = "UPDATE produtos SET status = ? WHERE id = ? AND status <> ?";
        conn = new conectaDAO().connectDB();

        if (conn == null) {
            return false;
        }

        try (Connection connection = conn;
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, "Vendido");
            statement.setInt(2, id);
            statement.setString(3, "Vendido");

            return statement.executeUpdate() == 1;
        } catch (SQLException erro) {
            System.err.println("Erro ao vender produto: " + erro.getMessage());
            return false;
        }
    }
    
    
    
        
}

