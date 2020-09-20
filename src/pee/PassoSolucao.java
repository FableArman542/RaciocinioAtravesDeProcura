package pee;

import pee.modprob.Estado;
import pee.modprob.Operador;

public interface PassoSolucao {
	
	public Estado getEstado ();
	public Operador getOperador ();
	public double getCusto ();
	
}
