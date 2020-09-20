package pee.mecProc.mem;
import java.util.HashMap;
import java.util.Queue;

import pee.mecProc.No;
import pee.modprob.Estado;

public class MemoriaProcura {

	public Queue<No> fronteira;
	protected HashMap<Estado, No> explorados = new HashMap<Estado, No>();

	public MemoriaProcura (Queue<No> fronteira) {
		this.fronteira = fronteira;
	}

	public void limpar () {
		fronteira.clear();
		explorados.clear();
	}

	public void inserir (No no) {
		Estado estAtual = no.getEstado();
		No noMem = explorados.get(estAtual);
		
		if (noMem == null ? true : 
				(no.getCusto() < noMem.getCusto())) {
			fronteira.add(no);
			explorados.put(estAtual, no);
		}
	}

	public No remover () {
		return fronteira.poll();
	}

	public boolean fronteiraVazia () {
		return fronteira.isEmpty();
	}

}
