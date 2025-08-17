package dicionario_jdbc_java.service;

import java.sql.SQLException;
import java.util.List;

import dicionario_jdbc_java.daoRpository.DaoDicionarioRository;
import dicionario_jdbc_java.daoRpository.DaoOrigemRository;
import dicionario_jdbc_java.daoRpository.DaoPalavraRository;
import dicionario_jdbc_java.daoRpository.DaoSinificadoRository;
import dicionario_jdbc_java.models.Dicionario;
import dicionario_jdbc_java.models.Origem;
import dicionario_jdbc_java.models.Palavra;
import dicionario_jdbc_java.models.Significado;

public class OrigemService {

	
	
	
	private final DaoOrigemRository daoOrigemRository;

	
	public OrigemService() {
		
		this.daoOrigemRository = new DaoOrigemRository();
	}
	
	public void savarOrigem(Long idPalavra, Origem  origem) throws SQLException {
		
		daoOrigemRository.salvarOrigem(idPalavra,  origem);
	}
	
	public Origem verOrigemPalavraId(Long idPalavra) throws SQLException {
		
		return daoOrigemRository.verOrigemPalavraId(idPalavra);
	}

	
	
}
