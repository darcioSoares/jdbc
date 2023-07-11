package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConsultarPessoa1 {
	public static void main(String[] args) throws SQLException {
		Connection  conexao = FabricaConexao.getConexao();
		String sql = "SELECT * FROM pessoas";
		
		Statement stmt = conexao.createStatement();
		ResultSet result = stmt.executeQuery(sql);
		
		List<Pessoa> pessoas = new ArrayList<>();
		
		//o next retonar true or false, quando acabar os dados ele retornara false e saira do while
		//while para criar o objeto pessoa com os dados
		while(result.next()) {
			int codigo = result.getInt("codigo");// nome da coluna no banco de dados
			String nome = result.getString("nome");
			
			pessoas.add(new Pessoa(codigo, nome));
		}
		
		for(Pessoa p: pessoas) {
			System.out.println(p.getCodigo() + " ====> " + p.getNome());
		}
				
		stmt.close();
		conexao.close();
		
	}
}
