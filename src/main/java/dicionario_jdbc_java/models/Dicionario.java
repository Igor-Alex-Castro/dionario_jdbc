package dicionario_jdbc_java.models;

import java.util.List;

public class Dicionario {


	private Long id;
	
	private String nome;
	

	private List<Palavra> palavras;

	
	
	public List<Palavra> getPalavras() {
		return palavras;
	}

	public void setPalavras(List<Palavra> palavras) {
		this.palavras = palavras;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}