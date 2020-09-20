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
	 * Este método não se está implementado pois existem diversos tipos de memória:
	 * 	.LIFO
	 * 	.FIFO
	 */
	protected abstract MemoriaProcura iniciarMemoria ();

	public Solucao resolver (P problema) {
		return resolver (problema, Integer.MAX_VALUE);
	}
	
	/**
	 * Retorna a solução do problema
	 * 
	 * @param problema
	 * @param profMax
	 * @return
	 */
	public Solucao resolver (P problema, int profMax) {
		this.problema = problema;
		memoriaProcura.limpar(); // Limpar a memoria
		No noInicial = new No (problema.getEstadoInicial());
		memoriaProcura.inserir(noInicial); // Colocar o primeiro nó em memória
		
		/*
		 * Enquanto a fronteira estiver vazia vamos remover o nó,
		 * 	verificar se esse nó é a solução, se for -> return
		 * 	se não -> prosseguimos no loop
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
	 * Método para expandir cada nó
	 * 
	 * @param no
	 */
	private void expandir (No no) {
		Estado estado = no.getEstado();
		Operador[] operadores = problema.getOperadores();
		
		/*
		 * Aplicar todos os operadores ao estado atual e,
		 * 	se o(s) estado(s) não forem nulos,
		 * 	inserimos na fronteira de exploração
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
	 * Verifica o percurso realizado até à resposta
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
