package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class NovaPessoa {

	public static void main(String[] args) throws SQLException {
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Informe o nome: ");
		String nome = entrada.nextLine();
		
		System.out.println(nome);
		
		//conexão com banco de dados		
		Connection conexao = FabricaConexao.getConexao();
		
		//dessa forma ele tambem trata a string, evitando que passe alguns sql injector
		String sql = "INSERT INTO pessoas (nome)VALUES(?)";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, nome);
		
		stmt.execute();
		
		System.out.println("Pessoa incluida com sucesso!");
		
		entrada.close();
	}
}
