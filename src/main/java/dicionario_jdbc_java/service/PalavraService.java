package dicionario_jdbc_java.service;

import java.sql.SQLException;
import java.util.List;

import dicionario_jdbc_java.daoRpository.DaoDicionarioRository;
import dicionario_jdbc_java.daoRpository.DaoPalavraRository;
import dicionario_jdbc_java.models.Dicionario;
import dicionario_jdbc_java.models.Palavra;

public class PalavraService {

	
	
	
	private final DaoPalavraRository daoPalavraRository;

	
	public PalavraService() {
		
		this.daoPalavraRository = new DaoPalavraRository();
	}
	
	public void savarPalavra(Long idDiconario, Palavra palavra) throws SQLException {
		
		daoPalavraRository.salvarPalavra(idDiconario, palavra);
	}

	public List<Palavra> verPalavra(Long idDicionario) throws SQLException {
		 
		return daoPalavraRository.verPalavraPorDicionario(idDicionario);
		
	}
	
}
