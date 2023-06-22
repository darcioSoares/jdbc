package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarBanco {
	
	public static void main(String[] args) throws SQLException {		
		String stringConexao = "jdbc:mysql://localhost:3306?verifyServerCertificate=false&useSSL=true";
		String user = "root";
		String senha = "sousa";
		
		Connection conexao = DriverManager.getConnection(stringConexao, user, senha);
		
		Statement stmt = conexao.createStatement();
		stmt.execute("CREATE DATABASE IF NOT EXISTS jdbc_db");
		System.out.println("Banco criado com sucesso");
		
		
		conexao.close();
		
	}

}
