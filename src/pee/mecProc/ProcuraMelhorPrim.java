package pee.mecProc;

import java.util.Comparator;

import pee.mecProc.mem.MemoriaProcura;




public abstract class ProcuraMelhorPrim <P extends Problema>
								extends MecanismoProcura <P>
								implements Comparator <No> {


	@Override
	protected MemoriaProcura iniciarMemoria() {
		return new MemoriaPrioridade(this);
	}
	
	@Override
	public int compare (No o1, No o2) {
		return Double.compare(f(o1), f(o2));
	}
	
	/**
	 * Devolve o valor de f(n) para o respetivo n (nó)
	 * @param no
	 * @return
	 */
	protected abstract double f (No no);
}
