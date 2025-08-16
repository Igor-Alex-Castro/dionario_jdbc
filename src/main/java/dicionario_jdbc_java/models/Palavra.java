package dicionario_jdbc_java.models;


public class Palavra {


	
		private Long id;

		private String nome;

	
		private Dicionario dicionario;
		
		
		private Origem origem;

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

	
		
		public Dicionario getDicionario() {
			return dicionario;
		}

		public void setDicionario(Dicionario dicionario) {
			this.dicionario = dicionario;
		}

		public Origem getOrigem() {
			return origem;
		}

		public void setOrigem(Origem origem) {
			this.origem = origem;
		}

		

		
}

