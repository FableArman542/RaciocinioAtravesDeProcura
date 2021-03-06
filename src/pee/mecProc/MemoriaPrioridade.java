package pee.mecProc;

import java.util.Comparator;
import java.util.PriorityQueue;

import pee.mecProc.mem.MemoriaProcura;

public class MemoriaPrioridade extends MemoriaProcura {

	public MemoriaPrioridade(Comparator<No> comparador) {
		super(new PriorityQueue<No>(1, comparador));
	}

}
