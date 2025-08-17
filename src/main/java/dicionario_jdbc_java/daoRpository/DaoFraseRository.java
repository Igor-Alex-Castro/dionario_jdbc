package dicionario_jdbc_java.daoRpository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dicionario_jdbc_java.connection.SigleConnection;
import dicionario_jdbc_java.models.Dicionario;
import dicionario_jdbc_java.models.Frase;
import dicionario_jdbc_java.models.Palavra;
import dicionario_jdbc_java.models.Significado;

public class DaoFraseRository {
	private Connection connection;

	
	public DaoFraseRository() {

		connection = SigleConnection.getConnection();
	}

	

	
	  public void salvarFrase(Long idPalavra, Frase frase) throws SQLException {
	  
	  String sql =
	  "INSERT INTO DICIONARIO.FRASE (DESCRICAO, PALAVRA_ID) VALUES (?,?)";
	  
	  PreparedStatement preparedStatement = connection.prepareStatement(sql);
	  
	  preparedStatement.setString(1,  frase.getDescricao());
	  preparedStatement.setLong(2, idPalavra);
	  
	  
	  preparedStatement.execute();
	  
	  connection.commit();
	  
	  }
	 
	
	  public List<Frase> frasePorPalavra (Long idPalavra) throws SQLException {

			
		  	List<Frase> frases = new ArrayList<Frase>();
			
			String sql = "SELECT * FROM DICIONARIO.frase WHERE PALAVRA_ID = ?";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setLong(1, idPalavra);

			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {

			  Frase frase = new  Frase();

				
			  	frase.setDescricao((resultSet.getString("descricao")));  
				
				
			  	frases.add(frase);
			}
			
			return frases.size() <= 0 ?  null : frases  ;
		}



	
}
