package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteConexao {
	public static void main(String[] args) throws SQLException {
		
		String stringConexao = "jdbc:mysql://localhost:3306";
		String user = "root";
		String senha = "sousa";
		
		Connection conexao = DriverManager.getConnection(stringConexao, user, senha);
		
		System.out.println("Conexao efetuada com sucesso");
		conexao.close();
		
	}

}
