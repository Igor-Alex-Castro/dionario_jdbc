package dicionario_jdbc_java.daoRpository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dicionario_jdbc_java.connection.SigleConnection;
import dicionario_jdbc_java.models.Dicionario;
import dicionario_jdbc_java.models.Origem;
import dicionario_jdbc_java.models.Palavra;
import dicionario_jdbc_java.models.Significado;

public class DaoSinificadoRository {
	private Connection connection;

	
	public DaoSinificadoRository() {

		connection = SigleConnection.getConnection();
	}

	

	public void salvarSignificado(Long idPalavra, Significado sigficado) throws SQLException {

		String sql = "INSERT INTO DICIONARIO.SIGNIFICADO (DESCRICAO, PALAVRA_ID) VALUES (?,?)";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		preparedStatement.setString(1, sigficado.getDescricao());
		preparedStatement.setLong(2, idPalavra);
	

		preparedStatement.execute();

		connection.commit();

	}
	
	
	public List<Significado> significadoPorPalavra (Long idPalavra) throws SQLException {

		 List<Significado> significados = new ArrayList<Significado>();
		
		String sql = "SELECT * FROM DICIONARIO.significado WHERE PALAVRA_ID = ?";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		preparedStatement.setLong(1, idPalavra);

		ResultSet resultSet = preparedStatement.executeQuery();

		while(resultSet.next()) {;

			Significado significado = new Significado();

			
			significado.setDescricao((resultSet.getString("descricao")));  
			
			
			significados.add(significado);
		}
		
		return significados.size() <= 0 ?  null : significados  ;
	}

	
}
