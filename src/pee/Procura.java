package pee;

import pee.mecProc.Problema;
import pee.modprob.Solucao;

public interface Procura {
	
	public Solucao resolver (Problema problema);
	public Solucao resolver (Problema problema, int profMax);
	
	public int getCustoEspacial ();
	public int getCustoTemporal ();
	
}
