package dicionario_jdbc_java.service;

import java.sql.SQLException;
import java.util.List;

import dicionario_jdbc_java.daoRpository.DaoPalavraRository;
import dicionario_jdbc_java.models.Frase;
import dicionario_jdbc_java.models.Origem;
import dicionario_jdbc_java.models.Palavra;
import dicionario_jdbc_java.models.Significado;

public class PalavraService {

	
	
	
	private final DaoPalavraRository daoPalavraRository;
	private final OrigemService origemService;
	private final SignificadoService significadoService;
	private final FraseService fraseService;
	
	public PalavraService() {
		
		this.daoPalavraRository = new DaoPalavraRository();
		this.origemService = new OrigemService();
		this.significadoService = new SignificadoService();
		this.fraseService = new FraseService();

	}
	
	public void savarPalavra(Long idDiconario, Palavra palavra) throws SQLException {
		
		daoPalavraRository.salvarPalavra(idDiconario, palavra);
	}

	public List<Palavra> verPalavraPorDicionario(Long idDicionario) throws SQLException {
		 
		return daoPalavraRository.verPalavraPorDicionario(idDicionario);
		
	}
	public Palavra verPalavraPorId(Long idPalavra) throws SQLException {
		 
		return daoPalavraRository.verPalavraPorId( idPalavra) ;
		
	}
	
	public List<Palavra> verPalavraPorDicionarioCompleto(Long idDicionario) throws SQLException {
		 
		List<Palavra> plavras = daoPalavraRository.verPalavraPorDicionario(idDicionario);
		
		for (Palavra palavra : plavras) {
			
			Origem origem = origemService.verOrigemPalavraId(palavra.getId());
			
			List<Significado> significados = significadoService.significadoPorPalavra(palavra.getId());
			List<Frase> frases =  fraseService.frasePorPalavra(palavra.getId());
			
			palavra.setFrases(frases);
			palavra.setSignificados(significados);
			palavra.setOrigem(origem);
			
		}
		
		return plavras ;
		
	}
	

	
	
}
