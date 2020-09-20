package pee;

import pee.mecProc.ProblemaHeur;
import pee.modprob.Solucao;

public interface ProcuraHeur {
	public Solucao resolver (ProblemaHeur problema);
	public Solucao resolver (ProblemaHeur problema, int profMax);
	
	public int getCustoEspacial ();
	public int getCustoTemporal ();
}
