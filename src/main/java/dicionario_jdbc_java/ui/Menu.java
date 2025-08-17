package dicionario_jdbc_java.ui;

import java.sql.SQLException;

import java.util.List;
import java.util.Scanner;

import dicionario_jdbc_java.models.Dicionario;
import dicionario_jdbc_java.models.Frase;
import dicionario_jdbc_java.models.Origem;
import dicionario_jdbc_java.models.Palavra;
import dicionario_jdbc_java.models.Significado;
import dicionario_jdbc_java.service.DicionarioService;
import dicionario_jdbc_java.service.FraseService;
import dicionario_jdbc_java.service.OrigemService;
import dicionario_jdbc_java.service.PalavraService;
import dicionario_jdbc_java.service.SignificadoService;

public class Menu {

	private final Scanner scanner;

	private final DicionarioService dicionarioService;
	private final PalavraService palavraService;
	private final SignificadoService significadoService;
	private final FraseService fraseService;
	private final OrigemService origemService;

	public Menu() {

		scanner = new Scanner(System.in);
		dicionarioService = new DicionarioService();
		palavraService = new PalavraService();
		significadoService = new SignificadoService();
		fraseService = new FraseService();
		origemService = new OrigemService();
	}

	public void menuOption() {

		System.out.println("O que deseja fazer: ");

		System.out.println("[1] - Adicionar um dicionario");
		System.out.println("[2] - Ver dicionarios");
		System.out.println("[3] - Adicionar palavra a um dicionarios");
		System.out.println("[4] - Ver lista palavras");
		System.out.println("[5] - Adicionar siginficado palavra");
		System.out.println("[6] - Adicionar frase palavra");
		System.out.println("[7] - Adicionar origem palavra");
		System.out.println("[8] - Ver dicionario completo");

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
		case "5":

			criarSignficado();
			break;
		case "6":

			criarFrase();
			break;
		case "7":

			criarOrigem();
			break;

		case "8":

			verDicionarioCompleto();
			break;
		}
	}

	private void verDicionarioCompleto() {
		System.out.print("Digite o numero do dicionario: ");
		Long idDicionario = scanner.nextLong();

		Dicionario dicionario;
		try {
			dicionario = dicionarioService.allDicionariosId(idDicionario);
			System.out.println("==== Dicionario " + dicionario.getNome() + " ====== ");

			List<Palavra> palavras = palavraService.verPalavraPorDicionarioCompleto(idDicionario);

			for (Palavra palavra : palavras) {
				System.out.println(palavra.getId() + " - " + palavra.getNome());

				if(palavra.getSignificados() == null) {
					System.out.println("Sinificados: Palavra sem signifciado");
				}else {
					System.out.println("Sinificados: ");
					for (Significado significado : palavra.getSignificados()) {
						System.out.println("   " + significado.getDescricao());
					}
				}
				
				if(palavra.getFrases() == null) {
					System.out.println("Frases: Palavra sem frases");
				}else {
					System.out.println("Sinificados: ");
					for (Frase frase : palavra.getFrases()) {
						System.out.println("   " + frase.getDescricao());
					}
				}
				
				if (palavra.getOrigem() != null) {

					System.out.println("Origem: (Titulo - Tipo - Pag): " + palavra.getOrigem().getTipo() + " - "
							+ palavra.getOrigem().getTitulo() + " - " + palavra.getOrigem().getPag());
					
				
				}else {
					System.out.println("Origem: palavra sem origem");
				}
				System.out.println("=====================================");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void criarOrigem() {
		// TODO Auto-generated method stub
		System.out.println("ID da palavra que deseja adicionar a origem");
		Long idPalavra = scanner.nextLong();
		scanner.nextLine();
		try {
			palavraService.verPalavraPorId(idPalavra);

			System.out.println("Escreva a tipo: ");
			String tipo = scanner.nextLine();
			System.out.println("Escreva a titulo: ");
			String titulo = scanner.nextLine();
			System.out.println("Escreva a pag: ");
			String pag = scanner.nextLine();

			Origem origem = new Origem();

			origem.setTitulo(titulo);
			origem.setTipo(tipo);
			origem.setPag(pag);

			origemService.savarOrigem(idPalavra, origem);

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	private void criarFrase() {
		System.out.println("ID da palavra que deseja adicionar a frase");
		Long idPalavra = scanner.nextLong();
		scanner.nextLine();
		try {
			palavraService.verPalavraPorId(idPalavra);

			System.out.println("Escreva a frase: ");
			String frase = scanner.nextLine();

			Frase fraseObj = new Frase();

			fraseObj.setDescricao(frase);

			fraseService.savarFrase(idPalavra, fraseObj);
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	private void criarSignficado() {

		System.out.println("ID da palavra que deseja adicionar o significado");
		Long idPalavra = scanner.nextLong();
		scanner.nextLine();
		try {
			palavraService.verPalavraPorId(idPalavra);

			System.out.println("Escreva o significado: ");
			String signifciado = scanner.nextLine();

			Significado significadoObj = new Significado();

			significadoObj.setDescricao(signifciado);

			significadoService.savarSignificado(idPalavra, significadoObj);
		} catch (SQLException e) {

			e.printStackTrace();
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

			List<Palavra> palavras = palavraService.verPalavraPorDicionario(idDicionario);

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
