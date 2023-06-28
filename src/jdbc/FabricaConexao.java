package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {

	public static Connection getConexao() {
		try {
			String stringConexao = "jdbc:mysql://localhost:3306/jdbc_db?verifyServerCertificate=false&useSSL=true";
			String user = "root";
			String senha = "sousa";
			
			return DriverManager.getConnection(stringConexao, user, senha);
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
