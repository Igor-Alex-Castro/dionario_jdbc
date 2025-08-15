package dicionario_jdbc_java.daoRpository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dicionario_jdbc_java.connection.SigleConnection;

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
		
			while(resultSet.next()) {
				
				String nome =  resultSet.getString("NOME") ;
				System.out.println(nome);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
	}
}
