package dicionario_jdbc_java.ui;

import java.sql.SQLException;

import java.util.List;
import java.util.Scanner;

import dicionario_jdbc_java.models.Dicionario;
import dicionario_jdbc_java.models.Palavra;
import dicionario_jdbc_java.service.DicionarioService;
import dicionario_jdbc_java.service.PalavraService;

public class Menu {

	private final Scanner scanner;

	private final DicionarioService dicionarioService;
	private final PalavraService palavraService;

	public Menu() {

		scanner = new Scanner(System.in);
		dicionarioService = new DicionarioService();
		palavraService = new PalavraService();
	}

	public void menuOption() {

		System.out.println("O que deseja fazer: ");

		System.out.println("[1] - Adicionar um dicionario");
		System.out.println("[2] - Ver dicinario um dicionario");
		System.out.println("[3] - Adicionar palavra a um dicionario");
		System.out.println("[4] - Ver lista palavras");
		System.out.println("[5] - Adicionar  origem palavra");

		String menuOption = scanner.nextLine();

		switch (menuOption) {
		case "1":
			salvarDicionario();
			break;
		case "2":
			verDicionario();
			break;
		case "3":
			criarPalavra();
			break;
		case "4":

			verPalavras();
			break;

		}
	}

	private void verPalavras() {
		// TODO Auto-generated method stub
		System.out.print("Digite o numero do dicionario: ");
		Long idDicionario = scanner.nextLong();

		try {
			Dicionario dicioaniro = dicionarioService.allDicionariosId(idDicionario);
			System.out.println("==== " + dicioaniro.getNome() + "=====");
			System.out.println("==== Lista de Palavras ======");

			List<Palavra> palavras = palavraService.verPalavra(idDicionario);

			for (Palavra palavra : palavras) {
				System.out.println(palavra.getId() + " - " + palavra.getNome());
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void salvarDicionario() {
		System.out.println("Digite o nome dicionario");
		String nomeDicionario = scanner.nextLine();

		Dicionario dicionario = new Dicionario();
		dicionario.setNome(nomeDicionario);

		try {
			dicionarioService.savarDicionario(dicionario);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	private void verDicionario() {
		System.out.println("==== Lista de dicionarios ======");
		try {
			List<Dicionario> dicionarios = dicionarioService.verDicionario();

			for (Dicionario dicionario : dicionarios) {
				System.out.print(dicionario.getId() + " - " + dicionario.getNome());
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void criarPalavra() {

		System.out.print("Digite o numero do dicionario: ");
		Long idDicionario = scanner.nextLong();
		scanner.nextLine();

		System.out.println("Digite a palavra");
		String palavra = scanner.nextLine();

		Palavra palavraObj = new Palavra();
		palavraObj.setNome(palavra);

		try {
			palavraService.savarPalavra(idDicionario, palavraObj);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
}
