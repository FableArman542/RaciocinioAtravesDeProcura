package pee.modprob;
import java.util.Iterator;

import pee.PassoSolucao;

public interface Solucao extends Iterable<PassoSolucao> {
	
	public Iterator<PassoSolucao> iterator ();
	public int getDimensao ();
	public double getCusto ();
	
}