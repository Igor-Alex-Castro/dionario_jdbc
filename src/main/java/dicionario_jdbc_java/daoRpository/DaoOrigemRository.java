package dicionario_jdbc_java.daoRpository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.OrientationRequested;

import dicionario_jdbc_java.connection.SigleConnection;
import dicionario_jdbc_java.models.Dicionario;
import dicionario_jdbc_java.models.Origem;
import dicionario_jdbc_java.models.Palavra;
import dicionario_jdbc_java.models.Significado;

public class DaoOrigemRository {
	private Connection connection;

	public DaoOrigemRository() {

		connection = SigleConnection.getConnection();
	}

	public void salvarOrigem(Long idPalavra, Origem origem) throws SQLException {

		String sql = "INSERT INTO DICIONARIO.ORIGEM (TIPO, TITULO, PAG, PALAVRA_ID) VALUES (?,?, ?, ?)";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		preparedStatement.setString(1, origem.getTipo());
		preparedStatement.setString(2, origem.getTitulo());
		preparedStatement.setString(3, origem.getPag());
		preparedStatement.setLong(4, idPalavra);

		preparedStatement.execute();

		connection.commit();

	}

	public Origem verOrigemPalavraId(Long idPalavra) throws SQLException {

		String sql = "SELECT * FROM DICIONARIO.ORIGEM WHERE PALAVRA_ID = ?";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		preparedStatement.setLong(1, idPalavra);

		ResultSet resultSet = preparedStatement.executeQuery();

		if(resultSet.next()) {;

			Origem origem = new Origem();

			origem.setId(resultSet.getLong("id"));
			origem.setTipo(resultSet.getString("tipo"));
			origem.setTitulo(resultSet.getString("titulo"));
			origem.setPag(resultSet.getString("pag"));

			return origem;
		}	
		return null;
	}

}
