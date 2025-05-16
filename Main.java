package logic.src.logic;    
import database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {

    public static boolean autenticar(String email, String senha) {
        String sql = "SELECT * FROM usuarios WHERE email = ? AND senha = ?";
        
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, email);
            stmt.setString(2, senha);
            
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                // Usuário encontrado, login válido
                String tipo = rs.getString("tipo");
                System.out.println("Login realizado com sucesso! Tipo: " + tipo);
                return true;
            } else {
                // Login inválido
                System.out.println("Email ou senha incorretos.");
                return false;
            }
            
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco: " + e.getMessage());
            return false;
        }
    }

    // Para testar o login rapidamente
    public static void main(String[] args) {
        String emailTeste = "aluno@poliedro.com";
        String senhaTeste = "123456";
        autenticar(emailTeste, senhaTeste);
    }
}
