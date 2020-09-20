package pee.mecProc;

import pee.PassoSolucao;
import pee.modprob.Estado;
import pee.modprob.Operador;

public class No implements PassoSolucao {
	
	private Estado estado;
	private int profundidade = 0;
	private double custo = 0.0f;
	private No antecessor;
	private Operador operador;
	
	public No (Estado estado) {
		this.estado = estado;
	}
	
	/**
	 * Cada nó pertence a um estado,
	 * 	provém de um antecessor e,
	 * 	um operador a ser aplicado
	 * 	
	 * @param estado
	 * @param operador
	 * @param antecessor
	 */
	public No (Estado estado,
				Operador operador,
				No antecessor) {
		this.estado = estado;
		this.antecessor = antecessor;
		this.operador = operador;
		this.profundidade = this.antecessor.profundidade + 1;
		this.custo = antecessor.getCusto() + operador.custo(antecessor.getEstado(),
									estado);
	}
	
	public Estado getEstado () {
		return estado;
	}
	
	public Operador getOperador () {
		return operador;
	}
	
	public No getAntecessor () {
		return antecessor;
	}
	
	public int getProfundidade () {
		return profundidade;
	}
	
	public double getCusto () {
		return custo;
	}
	
}
