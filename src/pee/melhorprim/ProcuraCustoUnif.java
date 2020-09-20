package pee.melhorprim;

import pee.Procura;
import pee.mecProc.No;
import pee.mecProc.Problema;
import pee.mecProc.ProcuraMelhorPrim;

public class ProcuraCustoUnif extends ProcuraMelhorPrim <Problema>
								implements Procura{

	@Override
	protected double f(No no) {
		return no.getCusto(); // f(n) = g(n)
	}
}
