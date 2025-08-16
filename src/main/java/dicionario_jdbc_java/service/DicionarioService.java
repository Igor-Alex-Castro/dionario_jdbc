package dicionario_jdbc_java.service;

import java.sql.SQLException;
import java.util.List;

import dicionario_jdbc_java.daoRpository.DaoDicionarioRository;
import dicionario_jdbc_java.models.Dicionario;

public class DicionarioService {

	
	
	
	private final DaoDicionarioRository daoDicionarioRository;

	public DicionarioService() {
		
		this.daoDicionarioRository = new DaoDicionarioRository();
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
}
