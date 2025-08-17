package dicionario_jdbc_java.service;

import java.sql.SQLException;
import java.util.List;

import dicionario_jdbc_java.daoRpository.DaoDicionarioRository;
import dicionario_jdbc_java.daoRpository.DaoFraseRository;
import dicionario_jdbc_java.daoRpository.DaoPalavraRository;
import dicionario_jdbc_java.daoRpository.DaoSinificadoRository;
import dicionario_jdbc_java.models.Dicionario;
import dicionario_jdbc_java.models.Frase;
import dicionario_jdbc_java.models.Palavra;
import dicionario_jdbc_java.models.Significado;

public class FraseService {

	
	
	
	private final DaoFraseRository daoFraseRository;

	
	public FraseService() {
		
		this.daoFraseRository = new DaoFraseRository();
	}
	
	public void savarFrase(Long idPalavra, Frase frase ) throws SQLException {
		
		daoFraseRository.salvarFrase(idPalavra, frase); 
	}

	
	public List<Frase> frasePorPalavra (Long idPalavra) throws SQLException {
		return daoFraseRository.frasePorPalavra(idPalavra);
	}
}
