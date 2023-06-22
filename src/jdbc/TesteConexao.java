package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteConexao {
	public static void main(String[] args) throws SQLException {
		//verifyServerCertificate=false&useSSL=true -> estou dizendo para fazer um conexao segura ssl mas não checar o cert
		String stringConexao = "jdbc:mysql://localhost:3306?verifyServerCertificate=false&useSSL=true";
		String user = "root";
		String senha = "sousa";
		
		Connection conexao = DriverManager.getConnection(stringConexao, user, senha);
		
		System.out.println("Conexao efetuada com sucesso");
		conexao.close();
		
	}

}
