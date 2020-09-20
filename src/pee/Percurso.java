package pee;
import java.util.Iterator;
import java.util.LinkedList;

import pee.mecProc.No;
import pee.modprob.Solucao;

public class Percurso implements Solucao {
	
	private LinkedList<PassoSolucao> percurso = new LinkedList<PassoSolucao>();
	
	public int getDimensao () {
		return 0;
	}
	
	public double getCusto () {
		return (percurso.isEmpty()) ?
				0 : percurso.getLast().getCusto();
	}
	
	public Iterator<PassoSolucao> iterator () {
		return percurso.iterator();
	}
	
	public void juntarInicio (No no) {
		percurso.addFirst(no);
	}
	
}
