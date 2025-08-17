package dicionario_jdbc_java.daoRpository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dicionario_jdbc_java.connection.SigleConnection;
import dicionario_jdbc_java.models.Dicionario;
import dicionario_jdbc_java.models.Palavra;

public class DaoPalavraRository {
	private Connection connection;

	
	public DaoPalavraRository() {

		connection = SigleConnection.getConnection();
	}

	

	public void salvarPalavra(Long idDiconario, Palavra palavra) throws SQLException {

		String sql = "INSERT INTO DICIONARIO.PALAVRA (NOME, DICIONARIO_ID) VALUES (?,?)";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		preparedStatement.setString(1, palavra.getNome());
		preparedStatement.setLong(2, idDiconario);
	

		preparedStatement.execute();

		connection.commit();

	}
	
	public List<Palavra> verPalavraPorDicionario(Long idDiconario) throws SQLException {
		List<Palavra> palavras = new ArrayList<>();
		
	
		String sql = "SELECT * FROM DICIONARIO.PALAVRA WHERE  DICIONARIO_ID = ?";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		
		preparedStatement.setLong(1, idDiconario);
	
	
		
		ResultSet resultSet = preparedStatement.executeQuery();

		while(resultSet.next()) {
			Palavra palavra = new Palavra();
			
			palavra.setId(resultSet.getLong("id"));
			palavra.setNome(resultSet.getString("nome"));
			
			palavras.add(palavra);
		}
		

		

		return palavras;

	}

	
	public Palavra verPalavraPorId(Long idPalavra) throws SQLException {
		
		
	
		String sql = "SELECT * FROM DICIONARIO.PALAVRA WHERE ID = ?";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		
		preparedStatement.setLong(1, idPalavra);
	
	
		
		ResultSet resultSet = preparedStatement.executeQuery();

		
			Palavra palavra = new Palavra();
			
			palavra.setId(resultSet.getLong("id"));
			palavra.setNome(resultSet.getString("nome"));
			
			
		
		

		

		return palavra;

	}

	
}
