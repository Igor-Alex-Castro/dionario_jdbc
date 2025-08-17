package dicionario_jdbc_java.models;

import java.util.List;

public class Palavra {


	
		private Long id;

		private String nome;


		private Origem origem;
		
		private List<Significado> significados;

		private List<Frase> frases;
		
		

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}
		
		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}


		public Origem getOrigem() {
			return origem;
		}

		public void setOrigem(Origem origem) {
			this.origem = origem;
		}

		public List<Significado> getSignificados() {
			return significados;
		}

		public void setSignificados(List<Significado> significados) {
			this.significados = significados;
		}

		public List<Frase> getFrases() {
			return frases;
		}

		public void setFrases(List<Frase> frases) {
			this.frases = frases;
		}

		
}

