package pee.melhorprim;

import pee.ProcuraHeur;
import pee.mecProc.No;
import pee.mecProc.ProblemaHeur;
import pee.mecProc.ProcuraMelhorPrim;

public class ProcuraSofrega extends ProcuraMelhorPrim<ProblemaHeur> implements ProcuraHeur {
	
	protected double f (No no) {
		return problema.heuristica(no.getEstado()); // f(n) = h(n)
	}
	
}
