package pee.melhorprim;

import pee.ProcuraHeur;
import pee.mecProc.No;
import pee.mecProc.ProblemaHeur;
import pee.mecProc.ProcuraMelhorPrim;

public class ProcuraAA extends ProcuraMelhorPrim<ProblemaHeur> implements ProcuraHeur {
	
	protected double f (No no) {
		return no.getCusto() + problema.heuristica(no.getEstado()); // f(n) = g(n) + h(n)
	}
	
}
