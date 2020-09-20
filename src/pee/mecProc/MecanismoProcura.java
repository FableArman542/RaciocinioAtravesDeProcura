package pee.mecProc;

import pee.Percurso;
import pee.mecProc.mem.MemoriaProcura;
import pee.modprob.Estado;
import pee.modprob.Operador;
import pee.modprob.Solucao;

public abstract class MecanismoProcura <P extends Problema> {

	private MemoriaProcura memoriaProcura;
	protected P problema;
	
	public int custoTemp = 0;
	public int custoEsp = 0;
	
	/**
	 * Assim que instanciado, o MecanismoProcura inicia a memoria
	 */
	public MecanismoProcura () {
		memoriaProcura = iniciarMemoria ();
	}
	
	/**
	 * Este m�todo n�o se est� implementado pois existem diversos tipos de mem�ria:
	 * 	.LIFO
	 * 	.FIFO
	 */
	protected abstract MemoriaProcura iniciarMemoria ();

	public Solucao resolver (P problema) {
		return resolver (problema, Integer.MAX_VALUE);
	}
	
	/**
	 * Retorna a solu��o do problema
	 * 
	 * @param problema
	 * @param profMax
	 * @return
	 */
	public Solucao resolver (P problema, int profMax) {
		this.problema = problema;
		memoriaProcura.limpar(); // Limpar a memoria
		No noInicial = new No (problema.getEstadoInicial());
		memoriaProcura.inserir(noInicial); // Colocar o primeiro n� em mem�ria
		
		/*
		 * Enquanto a fronteira estiver vazia vamos remover o n�,
		 * 	verificar se esse n� � a solu��o, se for -> return
		 * 	se n�o -> prosseguimos no loop
		 */
		while (!memoriaProcura.fronteiraVazia()) {
			No no = memoriaProcura.remover();
			if (problema.objetivo(no.getEstado()))
				return gerarSolucao (no);
			else
				if (no.getProfundidade() < profMax)
					expandir (no);
		}

		return null;
	}

	/**
	 * M�todo para expandir cada n�
	 * 
	 * @param no
	 */
	private void expandir (No no) {
		Estado estado = no.getEstado();
		Operador[] operadores = problema.getOperadores();
		
		/*
		 * Aplicar todos os operadores ao estado atual e,
		 * 	se o(s) estado(s) n�o forem nulos,
		 * 	inserimos na fronteira de explora��o
		 */
		for (Operador operador : operadores) {
			Estado estadoSuc = operador.aplicar(estado);
			
			if (estadoSuc != null) {
				No noSuc = new No (estadoSuc, operador, no);
				memoriaProcura.inserir(noSuc);
			}
			custoTemp ++;
		}
		
		if (memoriaProcura.fronteira.size() > custoEsp)
			custoEsp = memoriaProcura.fronteira.size();

	}
	
	/**
	 * Verifica o percurso realizado at� � resposta
	 * 
	 * @param noFinal
	 * @return
	 */
	private Solucao gerarSolucao (No noFinal) {
		
		Percurso percurso = new Percurso ();
		No no = noFinal;
		
		while (no != null) {
			percurso.juntarInicio(no);
			No antecessor = no.getAntecessor();
			no = antecessor;
		}
		
		return percurso;
	}
	
	public int getCustoEspacial () {return this.custoEsp;}
	public int getCustoTemporal () {return this.custoTemp;}

}
