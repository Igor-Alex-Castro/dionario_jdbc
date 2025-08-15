package dicionario_jdbc_java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dicionario_jdbc_java.daoRpository.DaoDicionarioRository;
import dicionario_jdbc_java.migrations.FlywayMigration;

/**
 * Hello world!
 *
 */
public class App 
{
	private static Connection connection;
	
	public static void main( String[] args ) throws ClassNotFoundException
    {
    	
    	
    	DaoDicionarioRository daoDicionarioRository = new DaoDicionarioRository();
    	
    	daoDicionarioRository.clienteReturn();
    	System.out.println(System.getProperty("java.version"));
        System.out.println(System.getProperty("java.runtime.version"));
        System.out.println(System.getProperty("java.vm.version"));
    	
    	 FlywayMigration.runMigrations();
    }
}
