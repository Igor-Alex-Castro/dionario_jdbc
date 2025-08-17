package dicionario_jdbc_java.service;

import java.security.Provider.Service;
import java.sql.SQLException;
import java.util.List;

import dicionario_jdbc_java.daoRpository.DaoDicionarioRository;
import dicionario_jdbc_java.daoRpository.DaoPalavraRository;
import dicionario_jdbc_java.daoRpository.DaoSinificadoRository;
import dicionario_jdbc_java.models.Dicionario;
import dicionario_jdbc_java.models.Palavra;

public class DicionarioService {

	
	
	
	private final DaoDicionarioRository daoDicionarioRository;
	private final PalavraService palavraService;

	public DicionarioService() {
		
		this.daoDicionarioRository = new DaoDicionarioRository();
		this.palavraService = new PalavraService();
		
	}
	
	public void savarDicionario(Dicionario dicionario) throws SQLException {
		
		daoDicionarioRository.salvarDicionario(dicionario);
	}
	
	public List<Dicionario> verDicionario() throws SQLException {
		
		return daoDicionarioRository.allDicionarios();
	}
	
	public Dicionario allDicionariosId(Long dicionario) throws SQLException {
			
		
		return daoDicionarioRository.allDicionariosId(dicionario);
		
	}
	
	
	public Dicionario dicionarioCompleto(Long dicionario) throws SQLException {
		
		Dicionario dicionarioObj = daoDicionarioRository.allDicionariosId(dicionario);;
			
		
		
		List<Palavra> palavras = palavraService.verPalavraPorDicionarioCompleto(dicionario);
		dicionarioObj.setPalavras(palavras);	
		
	
		//return daoDicionarioRository.allDicionariosId(dicionario);
		return dicionarioObj;
	}
	
	
}
