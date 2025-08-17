package dicionario_jdbc_java.service;

import java.sql.SQLException;
import java.util.List;

import dicionario_jdbc_java.daoRpository.DaoDicionarioRository;
import dicionario_jdbc_java.daoRpository.DaoPalavraRository;
import dicionario_jdbc_java.daoRpository.DaoSinificadoRository;
import dicionario_jdbc_java.models.Dicionario;
import dicionario_jdbc_java.models.Palavra;
import dicionario_jdbc_java.models.Significado;

public class SignificadoService {

	
	
	
	private final DaoSinificadoRository daoSinificadoRository;
	
	
	public SignificadoService() {
		
		this.daoSinificadoRository = new DaoSinificadoRository();
		
	}
	
	public void savarSignificado(Long idPalavra, Significado significado ) throws SQLException {
		
		daoSinificadoRository.salvarSignificado(idPalavra, significado);
		
	}
	public List<Significado> significadoPorPalavra (Long idPalavra) throws SQLException {
		return daoSinificadoRository.significadoPorPalavra(idPalavra);
	}
	
	
}
