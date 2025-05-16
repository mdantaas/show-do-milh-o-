package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/show_do_milhao";
    private static final String USER = "root"; // Substitua pelo seu usuário
    private static final String PASSWORD = "sua_senha"; // Substitua pela sua senha

    public static Connection connect() {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Conexão com o banco de dados realizada com sucesso!");
            return conn;
        } catch (SQLException e) {
            System.out.println("❌ Erro ao conectar com o banco de dados: " + e.getMessage());
            return null;
        }
    }
}
