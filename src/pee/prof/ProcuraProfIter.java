package pee.prof;

import pee.mecProc.Problema;
import pee.modprob.Solucao;

public class ProcuraProfIter extends ProcuraProf {
	
	private int incProf;
	
	public ProcuraProfIter (int incProf) {
		this.incProf = incProf;
	}
	
	public int getIncProf () {
		return incProf;
	}
	
	public void setIncProf (int incProf) {
		this.incProf = incProf;
	}
	
	/**
	 * Esta variante do método resolver apenas percorre uma profundidade
	 * 	máxima
	 */
	public Solucao resolver (Problema problema, int profmax) {
		
		for (int prof = incProf; prof < profmax; prof += incProf) {
			Solucao solucao = super.resolver(problema, prof);
			if (solucao != null) return solucao;
		}
		return null;
	}
	
}
