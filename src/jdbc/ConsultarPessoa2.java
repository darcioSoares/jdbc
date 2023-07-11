package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsultarPessoa2 {

	public static void main(String[] args) throws SQLException {
		
		Scanner entrada = new Scanner(System.in);
		
		Connection  conexao = FabricaConexao.getConexao();
		String sql = "SELECT * FROM pessoas WHERE nome like ?";
		
		System.out.print("Informe um valor :");
		String valor = entrada.nextLine();
		
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, "%"+valor+"%");
		
		ResultSet result = stmt.executeQuery();
				
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
		entrada.close();
		
		
		
	}
	
}
