package dicionario_jdbc_java.daoRpository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dicionario_jdbc_java.connection.SigleConnection;
import dicionario_jdbc_java.models.Dicionario;

public class DaoDicionarioRository {
	private Connection connection;

	public DaoDicionarioRository() {

		connection = SigleConnection.getConnection();
	}

	public void clienteReturn() {
		String sql = "SELECT * FROM cliente";

		try {
			PreparedStatement statement = connection.prepareStatement(sql);

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {

				String nome = resultSet.getString("NOME");
				System.out.println(nome);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void salvarDicionario(Dicionario dicionario) throws SQLException {

		String sql = "INSERT INTO DICIONARIO.DICIONARIO (NOME) VALUES (?)";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		preparedStatement.setString(1, dicionario.getNome());

		preparedStatement.execute();

		connection.commit();

	}

	public List<Dicionario> allDicionarios() throws SQLException {

		List<Dicionario> dicionarios = new ArrayList<>();

		String sql = "SELECT * FROM DICIONARIO.DICIONARIO";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			Dicionario dicionario = new Dicionario();

			dicionario.setNome(resultSet.getString("nome"));
			dicionario.setId(resultSet.getLong("id"));

			dicionarios.add(dicionario);

		}

		return dicionarios;

	}

	public Dicionario allDicionariosId(Long id) throws SQLException {

		

		String sql = "SELECT * FROM DICIONARIO.DICIONARIO WHERE ID = ?";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		preparedStatement.setLong(1, id);

		ResultSet resultSet = preparedStatement.executeQuery();

		resultSet.next();

		Dicionario dicionario = new Dicionario();

		dicionario.setNome(resultSet.getString("nome"));
		dicionario.setId(resultSet.getLong("id"));

	

		return dicionario;

	}
	
	public Dicionario allDicionariosNome(String  nome) throws SQLException {

	

		String sql = "SELECT * FROM DICIONARIO.DICIONARIO WHERE NOME = ?";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		preparedStatement.setString(1, nome);

		ResultSet resultSet = preparedStatement.executeQuery();

		resultSet.next();

		Dicionario dicionario = new Dicionario();

		dicionario.setNome(resultSet.getString("nome"));
		dicionario.setId(resultSet.getLong("id"));

		return dicionario;

	}

	public void verDicionario() {
		
		
	}
}
