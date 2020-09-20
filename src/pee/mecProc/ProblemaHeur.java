package pee.mecProc;

import pee.modprob.Estado;
import pee.modprob.Operador;

public abstract class ProblemaHeur extends Problema {

	public ProblemaHeur(Estado estadoInicial,
						Operador[] operadores) {
		
		super(estadoInicial, operadores);
	}
	
	/**
	 * M�todo para calcular a heuristica atrav�s do estado
	 * 
	 * @param estado
	 * @return
	 */
	public abstract double heuristica (Estado estado);

}
