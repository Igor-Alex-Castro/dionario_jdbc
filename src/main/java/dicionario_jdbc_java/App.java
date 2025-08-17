package dicionario_jdbc_java;

import dicionario_jdbc_java.migrations.FlywayMigration;
import dicionario_jdbc_java.ui.Menu;

/**
 * Hello world!
 *
 */
public class App {

	private final static Menu menu = new Menu();

	public static void main(String[] args) throws ClassNotFoundException {
		FlywayMigration.runMigrations();

		menu.menuOption();

	}
}
