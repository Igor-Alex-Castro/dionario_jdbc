package dicionario_jdbc_java.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class SigleConnection {

	
	private static String url = 
			"jdbc:oracle:thin:@localhost:1521/XEPDB1";
	
	private static Connection connection = null;
	
	static {
		conectar();
	}
	
	public SigleConnection(){ //quando tiver uma instancia vai conectar
		conectar();
	}
	
	public static Connection getConnection() {
		return connection;
	}
	
	private static void conectar() {
		try {
			if(connection == null) {
				//Class.forName()
				Class.forName("oracle.jdbc.driver.OracleDriver");
				connection = DriverManager.getConnection(url,"DICIONARIO", "admin123");
				connection.setAutoCommit(false);//para nao efetuar alteracoes no banco sem o nosso comando
				
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
