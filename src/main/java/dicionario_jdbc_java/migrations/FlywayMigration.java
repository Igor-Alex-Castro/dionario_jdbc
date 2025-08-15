package dicionario_jdbc_java.migrations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.flywaydb.core.Flyway;

import dicionario_jdbc_java.daoRpository.DaoDicionarioRository;

/**
 * Hello world!
 *
 */
public class FlywayMigration
{
	
	
	public static void runMigrations() throws ClassNotFoundException {
        // Caminho relativo para a pasta migrations/scripts
		 Class.forName("oracle.jdbc.driver.OracleDriver");
        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:oracle:thin:@localhost:1521/XEPDB1", "DICIONARIO", "admin123")
                .locations("classpath:db/migrations")
                .load();
   
        flyway.migrate();
    }
	
}
